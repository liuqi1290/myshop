package com.liuqi.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Interrupterlock implements  Runnable {
    private static Lock lock=new ReentrantLock();
    @Override
    public void run() {
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
