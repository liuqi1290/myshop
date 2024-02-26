package zifuchuan;

import java.util.Set;

public class Demo {
    public String i="22";
    public static String j="33";
    private String k="44";
    static class  D1{
       public static void ddd(){
           System.out.println(j);
       }
    }

     class  D2{
        public  void ddd(){
            System.out.println(k);
            Object o = new Object();

        }
    }
}
