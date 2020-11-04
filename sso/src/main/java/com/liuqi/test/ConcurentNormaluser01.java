package com.liuqi.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurentNormaluser01 {
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);
    public String date(int seconds) {
        Date date = new Date(1000 * seconds);
        SimpleDateFormat simpleDateFormat = ThreadSafeDateFormat.formatThreadLocal.get();
        System.out.println(simpleDateFormat.toString());
        return simpleDateFormat.format(date);
    }

    //10个线程打印日期
    public static void main(String[] args) {
        String  ggh="cehskak";
        char c1 = ggh.charAt(1);
        int i = ggh.codePointAt(1);
        System.out.println(ggh.codePointAt(1));
        String replace = ggh.replace("kak", "aaa");
        System.out.println(replace);
        String join = String.join("++","ksjfks" ,"lsklwer", "ieuriuriw");
        System.out.println(join);
    }


}

class ThreadSafeDateFormat {
    public static ThreadLocal<SimpleDateFormat> formatThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            System.out.println("formatThreadLocal=="+simpleDateFormat.toString());
            return simpleDateFormat;
        }
    };
}

class ThreadSafeDateFormat1 {
    public static ThreadLocal<SimpleDateFormat> formatThreadLocal2 = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
}


