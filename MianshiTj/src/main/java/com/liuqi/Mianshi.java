package com.liuqi;

import java.lang.reflect.Field;

public class Mianshi {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String s = new String("abc");
        // 在这中间可以添加N⾏代码，但必须保证s引⽤的指向不变，最终将输出变成abcd
        Field value = s.getClass().getDeclaredField("value");
        value.setAccessible(true);
        value.set(s, "abcd".toCharArray());
        System.out.println(s);
        Integer int1=100;
        Integer int2=100;
    }
}
