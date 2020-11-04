package com.liuqi.test;

import java.util.concurrent.locks.Lock;

public class ThreadLocalNUll {

   ThreadLocal<Long> threadLocal= new ThreadLocal<>();

   public void set (){
       threadLocal.set(Thread.currentThread().getId());
   }

   public Long get(){
       Long aLong = threadLocal.get();
       return aLong;
   }

    public static void main(String[] args) {
        ThreadLocalNUll localNUll=new ThreadLocalNUll();
        System.out.println(localNUll.get());
        new Thread(new Runnable() {
            @Override
            public void run() {
                localNUll.set();
                System.out.println(localNUll.get());
            }
        }).start();

    }
}
