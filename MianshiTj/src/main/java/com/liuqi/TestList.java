package com.liuqi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TestList {
   public volatile static  int LISTLENGTH = 1000;
   public static final int VALIDLENGTH = 20;
   public static final int SLEEPTIME = 1000;

   public static Boolean isValidLength(String str) {
      if (str.length() < VALIDLENGTH) {
         return true;
      } else {
         return false;
      }
   }


   public static void main(String[] args) {
       String  s = "a";
      String q = "b";
      System.out.println(s+q);
   }





}
 class Sequence {
   private static AtomicInteger value = new AtomicInteger(0);
   public static int getNext() {
      return value.incrementAndGet();
   }
}