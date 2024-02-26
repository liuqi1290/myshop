package com.liuqi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeConverter {

    public static String convertTime(String str) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");

        // 设置输入和输出时区
        inputFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        outputFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));

        try {
            // 解析输入字符串为日期对象
            Date date = inputFormat.parse(str);

            // 格式化输出日期为字符串
            return outputFormat.format(date).replace("GMT", "BJT");
        } catch (ParseException e) {
            e.printStackTrace();
            return "Invalid Date Format";
        }
    }

    public static void main(String[] args) {
        String utcTime = "2019-05-30 13:00:00 UTC";
        String bjtTime = convertTime(utcTime);
        System.out.println("UTC Time: " + utcTime);
        System.out.println("BJT Time: " + bjtTime);
        System.out.println(4%8);


    }
}