package com.liuqi.rabbit.producer.broker;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import com.liuqi.rabbit.api.Message;
import com.liuqi.rabbit.api.MessageType;
import com.liuqi.rabbit.api.exception.MessageRunTimeException;
import com.liuqi.rabbit.common.convert.GenericMessageConverter;
import com.liuqi.rabbit.common.convert.RabbitMessageConverter;
import com.liuqi.rabbit.common.serializer.Serializer;
import com.liuqi.rabbit.common.serializer.impl.JacksonSerializerFactory;
import com.liuqi.rabbit.producer.service.MassageStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

;

/**
 * @auther liuqi
 * @create 2020-12-16  14:58
 */

@Slf4j
@Component
public class RabbitTemplateContainer implements RabbitTemplate.ConfirmCallback  {
    private JacksonSerializerFactory serializerFactory=JacksonSerializerFactory.INSTENCE;
    private Map<String/** TOPIC*/, RabbitTemplate> rabbitTemplateMap=Maps.newConcurrentMap();
    private Splitter splitter=Splitter.on("#");
    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private MassageStoreService massageStoreService;


    public RabbitTemplate getRabbitTemplate(Message message) throws MessageRunTimeException {
        Preconditions.checkNotNull(message);
        String topic=message.getTopic();
        RabbitTemplate rabbitTemplate=rabbitTemplateMap.get(topic);
        if (rabbitTemplate != null) {
            return rabbitTemplate;
        }
        RabbitTemplate newRabbitTemplate=new RabbitTemplate(connectionFactory);
        newRabbitTemplate.setExchange(message.getTopic());
        newRabbitTemplate.setRoutingKey(message.getRoutingKey());
        //设置message 序列化,使用自己封装的序列化工具
        Serializer serializer=serializerFactory.create();
        GenericMessageConverter genericMessageConverter=new GenericMessageConverter(serializer);
        RabbitMessageConverter rabbitMessageConverter=new RabbitMessageConverter(genericMessageConverter);
        newRabbitTemplate.setMessageConverter(rabbitMessageConverter);

        if (!MessageType.RAPID.equals(message.getMessageType())) {
            newRabbitTemplate.setConfirmCallback(this);
        }
        rabbitTemplateMap.put(topic, newRabbitTemplate);

        return rabbitTemplateMap.get(topic);
    }

    /**
     * 消息确认操作
     * @param correlationData
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        List<String> list=splitter.splitToList(correlationData.getId());
        String messageId=list.get(0);
        long time=Long.valueOf(list.get(1));
        if(ack){
            massageStoreService.success( messageId);
            log.info("#RabbitTemplateContainer.confirm # confirm success messageId={},time={}",messageId,time);
        }else{
           // massageStoreService.fail( messageId);失败的原因很多要具体情况具体处理
            log.info("#RabbitTemplateContainer.confirm # confirm error messageId={},time={}",messageId,time);

        }
    }
}
