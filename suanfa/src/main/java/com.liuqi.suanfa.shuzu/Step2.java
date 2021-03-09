package com.liuqi.suanfa.shuzu;

;

/**
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 *
 * @auther liuqi
 * @create 2020-12-18  11:54
 */


public class Step2 {
    public static void main(String[] args) {
        /**
         * Consider the following matrix:
         * [
         *   [1,   4,  7, 11, 15],
         *   [2,   5,  8, 12, 19],
         *   [3,   6,  9, 16, 22],
         *   [10, 13, 14, 17, 24],
         *   [18, 21, 23, 26, 30]
         * ]
         * 要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
         * 该二维数组中，小于它的 数都在左边，大于他的数都在右边，所以我们从右上角的数开始遍历寻找，每次都可以缩小查找范围，提高查找效率。
         */
        int[][] matmix=new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,22},{18,21,23,26,30}};
        int target=135;
        int x=matmix.length ; int y=matmix[0].length;
        int r=0; int c=y-1;
        int conut=0;
        while (r<=x-1 && c>=0 ){
            conut++;
            if(target==matmix[r][c]){
                System.out.println("已找到目标数据："+target);
                System.out.println("循环次数："+conut);
                return;
            }
            if(target<matmix[r][c]){
                c--;
            }else{
                r++;
            }
        }
        System.out.println("没找到目标数据@@@"+"循环次数："+conut);
    }
}
