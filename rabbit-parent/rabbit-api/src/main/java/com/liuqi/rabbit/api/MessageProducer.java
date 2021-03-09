package com.liuqi.rabbit.api;

import com.liuqi.rabbit.api.exception.MessageException;

import java.util.List;

public interface MessageProducer {
    /**
     * 消息的发送，附带回调函数
     * @param message
     * @param sendCallBack
     * @throws MessageException
     */
    void send(Message message,SendCallBack sendCallBack) throws MessageException;

    /**
     * 消息发送
     * @param message
     * @throws MessageException
     */
    void send(Message message) throws MessageException;

    /**
     * 消息批量发送
     * @param messages
     * @throws MessageException
     */
    void send(List<Message> messages) throws MessageException;
}
