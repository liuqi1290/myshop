package com.liuqi.design.principle.simple;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 这个实现方式使用了静态内部类，当第一次调用getInstance()方法时，会创建Holder类并初始化INSTANCE变量，后续再次调用getInstance()方法时，直接返回INSTANCE变量，避免了多线程环境下的数据竞争问题。
 * 同时，由于使用了静态内部类，保证了线程安全，并且保证了实例的唯一性。这种实现方式在性能方面比使用synchronized关键字实现同步处理要好一些，因为静态内部类的实例被声明为静态的，不会涉及到锁的竞争，因此在多线程环境下，性能可能会受到影响。
 */
public class SimpleDemo2 {
    private static class Holder {
        private static final SimpleDemo2 INSTANCE = new SimpleDemo2();
    }

    public static SimpleDemo2 getInstance() {
        return Holder.INSTANCE;
    }

    private SimpleDemo2() {

    }

    public static void main(String[] args) {
        SimpleDemo2 s1 = SimpleDemo2.getInstance();
        SimpleDemo2 s2 = SimpleDemo2.getInstance();
        System.out.println(s1 == s2); //true
        ArrayList<String> list = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();

    }

}
