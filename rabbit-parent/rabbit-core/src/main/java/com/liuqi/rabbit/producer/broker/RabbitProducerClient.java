package com.liuqi.rabbit.producer.broker;

import com.google.common.base.Preconditions;
import com.liuqi.rabbit.api.Message;
import com.liuqi.rabbit.api.MessageProducer;
import com.liuqi.rabbit.api.MessageType;
import com.liuqi.rabbit.api.SendCallBack;
import com.liuqi.rabbit.api.exception.MessageException;
import com.liuqi.rabbit.api.exception.MessageRunTimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 发送消息的实现
 */
@Component
public class RabbitProducerClient implements MessageProducer {
    @Autowired
    private  RabbitBroker rabbitBroker;

    @Override
    public void send(Message message, SendCallBack sendCallBack) throws MessageException {

    }

    @Override
    public void send(Message message) throws MessageRunTimeException {
        Preconditions.checkNotNull(message.getTopic());
        String messageType = message.getMessageType();
        switch ( messageType) {
            case MessageType.RAPID:
                rabbitBroker.repIdSend(message);
                break;
            case MessageType.CONFIRM:
                rabbitBroker.confirmSend(message);
                break;
            case MessageType.RELIANT:
                rabbitBroker.reliantSend(message);
                break;
            default:
                break; }


    }

    @Override
    public void send(List<Message> messages) throws MessageException {

    }
}
