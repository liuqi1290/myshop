package com.liuqi.design.principle.observer;

import java.util.Observable;

public class Topic extends Observable {
    private String name;
     Topic(String name) {
         this.name = name;
     }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void publish(String message) {
        System.out.println("发布新消息：" + message);
        // 消息更新，通知所有观察者
        setChanged();
        notifyObservers(message);
        clearChanged();
    }

}
