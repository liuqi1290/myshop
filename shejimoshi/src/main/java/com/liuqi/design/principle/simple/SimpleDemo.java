package com.liuqi.design.principle.simple;

/**
 * 这个实现方式使用了双重检查，首先判断实例是否为空，如果不为空则直接返回，避免了多线程环境下的数据竞争问题。同时，由于使用了同步处理，保证了线程安全，并且保证了实例的唯一性。但是，
 * 这里使用了synchronized关键字来实现同步处理，可能会导致性能下降，因为synchronized关键字会涉及到锁的等待和竞争，因此在多线程环境下，性能可能会受到影响
 */
public class SimpleDemo {
    private static volatile SimpleDemo instance = null;

    private SimpleDemo() {
    }

    //提供一个公有的静态方法，加入同步处理的代码，解决线程安全问题
    public static  SimpleDemo getInstance() {
        if (instance == null) {
            synchronized(SimpleDemo.class) {
                instance = new SimpleDemo();
            }
        }
        return instance;
    }

}
