package com.liuqi.rabbitmqproducer.componet;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
public class RabbitSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    // 确认消息回调接口， 用于确认消息是否被broker接收
    final RabbitTemplate.ConfirmCallback callback= new RabbitTemplate.ConfirmCallback() {
        /**
         *
         * @param correlationData: 作为唯一的标识
         * @param b：是否 落盘成功
         * @param s：失败的异常消息
         */
        @Override
        public void confirm(CorrelationData correlationData, boolean b, String s) {
            System.out.println("消息ack确认："+correlationData.getId());
        }
    };

    /**
     * 发送消息的方法
     * @param massge: 消息内容
     * @param properties: 额外的属性
     */
    public void  send(String exchange, String routingKey,Object massge, Map<String,Object> properties){
        MessageHeaders messageHeaders = new MessageHeaders(properties);
        Message<?> message = MessageBuilder.createMessage(massge, messageHeaders);
        rabbitTemplate.setConfirmCallback(callback);
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        MessagePostProcessor postProcessor = new MessagePostProcessor() {
            @Override
            public org.springframework.amqp.core.Message postProcessMessage(org.springframework.amqp.core.Message message) throws AmqpException {
                System.out.println("消息为==========>"+message);
                return message;
            }
        };
        rabbitTemplate.convertAndSend(exchange, routingKey, massge,postProcessor,correlationData);
    }
}
