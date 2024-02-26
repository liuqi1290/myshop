package com.liuqi;

public class LocalInnerClassExample {
    public void doSomething() {
        final int[] localVariable = {10};
        // 局部内部类
        class LocalInnerClass {
            public void printLocalVariable() {
                localVariable[0] =20;
                System.out.println("局部变量 localVariable 的值为：" + localVariable[0]);
            }
        }
        //匿名内部类
        Runnable runnable = () -> {
            System.out.println("这是一个匿名内部类");
            System.out.println("匿名内部类局部变量 localVariable 的值为：" + localVariable[0]);
        };
        new Thread(runnable).start();
        new LocalInnerClass().printLocalVariable();
    }

    public static void main(String[] args) {
        new LocalInnerClassExample().doSomething();
    }
}
