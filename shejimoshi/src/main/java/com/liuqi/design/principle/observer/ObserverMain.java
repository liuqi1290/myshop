package com.liuqi.design.principle.observer;

public class ObserverMain {
    public static void main(String[] args) {
        Topic topic1 = new Topic("topic");
        Manager manager1 = new Manager("里斯");
        Manager manager2 = new Manager("张三");
        Manager manager3 = new Manager("王五");
        topic1.addObserver(manager1);
        topic1.addObserver(manager2);
        topic1.addObserver(manager3);
        //发布消息
        topic1.publish("新消息1");
        topic1.publish("新消息2");
        topic1.publish("新消息3");
    }
}
