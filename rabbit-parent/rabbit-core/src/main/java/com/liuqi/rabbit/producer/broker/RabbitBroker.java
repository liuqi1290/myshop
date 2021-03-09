package com.liuqi.rabbit.producer.broker;

import com.liuqi.rabbit.api.Message;

/**
 * 不同类型的消息发送接口定义
 */
public interface RabbitBroker {
    void repIdSend(Message message);
    void confirmSend(Message message);
    void reliantSend(Message message);
    void sendMessages();
}
