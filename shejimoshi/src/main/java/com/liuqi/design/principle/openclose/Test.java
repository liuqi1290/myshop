package com.liuqi.design.principle.openclose;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        for (int t = 0; t <5 ; t++) {


        int[] red=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
        int[] blue=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        int[] hao=new int[7];
        int anInt=-1;

        Random random = new Random();
        for (int i = 0; i <=6 ; i++) {
            anInt= random.nextInt(red.length - i);
            hao[i]=red[anInt];
            int temp=red[anInt];
            red[anInt]=red[red.length-1-i];
            red[red.length-1-i]=temp;
        }
        Arrays.sort(hao);
        int j = random.nextInt(blue.length);
        hao[hao.length-1]= blue[j];
        System.out.println(Arrays.toString(hao));
    }
    }
}
