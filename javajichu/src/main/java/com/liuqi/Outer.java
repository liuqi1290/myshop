package com.liuqi;

/**
 * 成员内部类示例
 */
public class Outer {
    private String name = "Outer";
    private int age = 44;
    public static final int sex = 1;

    public void show() {
        System.out.println("name:" + name + ", age:" + age + ", sex:" + sex);
    }

    private class Inner {
        private String name = "Inner";
        private int age = 22;
        private static final int sex = 0;

        public void display() {
            System.out.println("name:" + name + ", age:" + age + ", sex:" + sex);
            System.out.println("Outer name:" + Outer.this.name + ", Outer age:" + Outer.this.age +
                    ", Outer sex:" + Outer.sex);
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.show();
        Outer.Inner inner = outer.new Inner();
        inner.display();

    }
}