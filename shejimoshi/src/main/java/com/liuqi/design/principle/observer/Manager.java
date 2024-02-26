package com.liuqi.design.principle.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察着
 */
public class Manager implements Observer  {
    private String name;
    public Manager(String name){
        this.name=name;
    }
    @Override
    public void update(Observable o, Object arg) {
        Topic to= (Topic) o;
        System.out.println("观察者("+name+")收到被观察者("+to.getName()+")发来的消息："+arg);
    }
}
