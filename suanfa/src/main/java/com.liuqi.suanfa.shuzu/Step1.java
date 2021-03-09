package com.liuqi.suanfa.shuzu;

;

/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字
 *
 * @auther liuqi
 * @create 2020-12-18  10:02
 */


public class Step1 {
    public static void main(String[] args) {
        int[] data={2, 1, 3, 0, 2, 5};
        //要求时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。
        //使用数值对应位标的方式，即将数值移动到对应的索引下，例如2移动到下标位2的数组位置。如果高i位置已存在同样的值，说明是一组重复的值。
        int ivalue;
        for (int i=0; i < data.length; i++) {
            ivalue=data[i];
            if (i == ivalue) {
                i++;
                continue;
            }
            if (ivalue == data[ivalue]) {
                System.out.println("已经找到一组重复数据为：" + ivalue);
                break;
            }
            data[i]=data[ivalue];
            data[ivalue]=ivalue;
        }
    }
}
 class Setep1_1{
    //1、给定一个字符串，找出不含有重复字符的最长子串的长度。
     public static void main(String[] args) {
         String str="devdt";
         int n =str.length(); int num=0;

     }
 }