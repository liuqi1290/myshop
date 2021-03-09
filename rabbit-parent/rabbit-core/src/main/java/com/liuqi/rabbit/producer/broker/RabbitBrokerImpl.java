package com.liuqi.rabbit.producer.broker;

import com.liuqi.rabbit.api.Message;
import com.liuqi.rabbit.api.MessageType;
import com.liuqi.rabbit.common.contant.BrokerMessageConst;
import com.liuqi.rabbit.common.contant.BrokerMessageStatus;
import com.liuqi.rabbit.producer.entity.BrokerMessage;
import com.liuqi.rabbit.producer.service.MassageStoreService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class RabbitBrokerImpl implements RabbitBroker {
    @Autowired
    private RabbitTemplateContainer templateContainer;

    @Autowired
    private MassageStoreService massageStoreService;

    @Override
    public void repIdSend(Message message) {
        message.setMessageType(MessageType.RAPID);
        sendCore(message);
    }

    @Override
    public void confirmSend(Message message) {
        message.setMessageType(MessageType.CONFIRM);
        sendCore(message);
    }

    @Override
    public void reliantSend(Message message) {
        message.setMessageType(MessageType.RELIANT);
        Date date=new Date();
        BrokerMessage brokerMessage=new BrokerMessage();
        brokerMessage.setMessageId(message.getMessageId());
        brokerMessage.setStatus(BrokerMessageStatus.SENDING.getCode());
        brokerMessage.setCreateTime(date);
        brokerMessage.setUpdateTime(date);
        //第一次不需要设置TryCount
        //brokerMessage.setTryCount();
        brokerMessage.setNextRetry(DateUtils.addMinutes(date, BrokerMessageConst.TIMEOUT));
        brokerMessage.setMessage(message);
        massageStoreService.insertMassage(brokerMessage);
        sendCore(message);
    }

    @Override
    public void sendMessages() {

    }

    /**
     * 发送消息的核心方法，内部方法
     * @param message
     */
    private  void sendCore(Message message){
        AsyncBaseQueue.submit(()->{
            CorrelationData correlationDat= new CorrelationData(String.format("%s#%s#%s",
                    message.getMessageId(),
                    System.currentTimeMillis(),
                    message.getMessageType()));
            //使用RabbitTemplate池获取rabbitTemplate对象，解决单例性能地的问题。每一个topic对应一个rabbitTemplate
            // 可以扩展不同RabbitTemplate
            RabbitTemplate rabbitTemplate=templateContainer.getRabbitTemplate(message);
            rabbitTemplate.convertAndSend(message.getTopic(), message.getRoutingKey(), message, correlationDat );
            log.info("#RabbitBrokerImpl.sendCore# send to Rabbitmq,MessageId={}", message.getMessageId());
        } );
    }
}
