package com.liuqi.lock;

import net.hasor.web.annotation.Get;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock 不会像synchronized一样遇到异常主动是封锁，需要在finally中显示的释放锁
 */
public class MustLock {
   private static Lock lock=new ReentrantLock();
    int i=0;
    public static void main(String[] args) {
        lock.lock();

        try{
            System.out.println(Thread.currentThread().getName());
        }finally {
            lock.unlock();
        }
    }
}
