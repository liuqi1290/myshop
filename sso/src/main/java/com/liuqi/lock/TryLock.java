package com.liuqi.lock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用tryLock避免死锁
 */
public class TryLock implements Runnable {

    private static Lock lock= new ReentrantLock();
    private static Lock lock1= new ReentrantLock();
    int flag=1;
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {

            if (flag == 1) {
                try {
                    if (lock.tryLock(1000, TimeUnit.MICROSECONDS)) {
                        try {
                            System.out.println("线程1获取锁1成功");
                            Thread.sleep(new Random().nextInt(1000));
                            if (lock1.tryLock(1000, TimeUnit.MICROSECONDS)) {
                                try{
                                    System.out.println("线程1获取锁2成功");
                                    System.out.println("线程1获取2把锁");
                                     break;
                                }finally {

                                }
                            }else {
                                System.out.println("线程1获取锁2失败，请重试！");
                            }


                        } finally {
                            lock.unlock();
                            Thread.sleep(new Random().nextInt(1000));
                        }

                    } else {
                        System.out.println("线程1获取锁1失败，请重试！");
                    }


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            if (flag == 2) {
                try {
                    if (lock1.tryLock(2000, TimeUnit.MICROSECONDS)) {
                        try {
                            System.out.println("线程2获取锁2成功");
                            Thread.sleep(new Random().nextInt(2000));
                            if (lock.tryLock(2000, TimeUnit.MICROSECONDS)) {
                                try{
                                    System.out.println("线程2获取锁1成功");
                                    System.out.println("线程2获取2把锁");
                                    break;
                                }finally {
                                    lock.unlock();
                                }
                            }else {
                                System.out.println("线程2获取锁1失败，请重试！");
                            }


                        } finally {
                            lock1.unlock();
                            Thread.sleep(new Random().nextInt(1000));
                        }

                    } else {
                        System.out.println("线程2获取锁2失败，请重试！");
                    }


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        TryLock r1 = new TryLock();
        TryLock r2 = new TryLock();
        r1.flag=1;
        r2.flag=2;
        new Thread(r1).start();
        new Thread(r2).start();
    }
}
