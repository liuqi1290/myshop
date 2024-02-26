package com.liuqi.design.principle.factory;

public class ClientCode {
    public static void main(String[] args) {
        ConcreteFactoryA concreteFactoryA = ConcreteFactoryA.getInstance();
        Product productA = concreteFactoryA.createProduct();
        productA.use();

        ConcreteFactoryB concreteFactoryB = ConcreteFactoryB.getInstance();
        Product productB = concreteFactoryB.createProduct();
        productB.use();

    }
}
