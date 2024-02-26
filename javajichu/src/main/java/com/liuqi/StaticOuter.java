package com.liuqi;
/*
 * 静态内部类示例

 */
public class StaticOuter {
    private static int outerNum = 10;

    public static int getOuterNum() {
        return outerNum;
    }
    public  void print1(){
        System.out.println("外部类的输出："+outerNum);
        StaticInner.print();
    }



public static class StaticInner{
        private  int outerNum = 20;
        public static void print(){
            System.out.println("静态内部类的输出："+StaticOuter.outerNum);
        }
    }
    public static void main(String[] args) {
        String t = "hello";
        String s = "hello";
        char c[] = {'h', 'e', 'l', 'l', 'o'} ;
        System.out.println(t==s);
        System.out.println(t.equals(s));
        System.out.println(t.equals(new String ("hello")));


    }
}