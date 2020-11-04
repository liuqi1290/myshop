package com.liuqi.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConcurentNormaluser00 {


    public String date(int seconds){
        Date date=new Date(1000*seconds);
        SimpleDateFormat formart     = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return formart.format(date);
    }


    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
              String date=  new ConcurentNormaluser00().date(1101);
                System.out.println(date);
            }
        }).start();
    }
}
