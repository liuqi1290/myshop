package com.liuqi.rabbit.api;

public interface MessageListener {
    void onMessage(Message message);
}
