package com.liuqi.design.principle.decorator;

public class ClientDeconrator {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        //组合装饰
        component = new ConcreteDecoratorA(component);
        //组合装饰
        component = new ConcreteDecoratorB(component);
        //执行组建的方法
        component.performOperation();
    }
}
