package com.liuqi.test;

import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

public class Emploee {
    private String name;
    private Date curranteDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCurranteDate() {
        return (Date)curranteDate.clone();
    }

    public void setCurranteDate(Date curranteDate) {
        this.curranteDate = curranteDate;
    }

/*
    public long re(long n) {
        if(n==1){
            return  1;
        }else {
            System.out.println("本次递归n=：" + n);
            long i = n * re(n - 1);
            System.out.println("本次递归结束的值：" + i);

            return i;
        }
    }
*/

    public int feibonaqieshulie(int n){
        if(n<2){
            return n;
        }else{
            return feibonaqieshulie(n - 1) + feibonaqieshulie(n - 2) ;

        }
    }

    public void recserse(char[] s){
      int l=0;
      int r=s.length;
      s[l]=s[r];
      char temnp=s[l];
      s[r]=temnp;
      l++;r--;

    }
    public static void main(String[] args) {

        Emploee emploee = new Emploee();
        int feibonaqieshulie = emploee.feibonaqieshulie(6);
        System.out.println(feibonaqieshulie);

    }


}
