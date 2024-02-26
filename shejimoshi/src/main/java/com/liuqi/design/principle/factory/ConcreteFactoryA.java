package com.liuqi.design.principle.factory;
// 这段代码定义了一个单例的工厂类 ConcreteFactoryA，它继承了抽象工厂类 AbstractFactory，并实现了工厂方法。在工厂类中，我们使用了静态内部类 Holder 来保存单例，这样就可以确保在整个程序运行过程中，只有一个实例被创建。
//通过这种方式，我们可以确保同一个产品类型的工厂只被创建一次，从而避免内存泄漏和提高性能。同时，这种实现方式也符合单例模式的创建原则，即在程序运行过程中，只创建一个实例。
public class ConcreteFactoryA extends AbstractFactory {
    private ConcreteFactoryA() {
    }

    public static ConcreteFactoryA getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final ConcreteFactoryA INSTANCE = new ConcreteFactoryA();
    }

    @Override
    public Product createProduct() {
        return new ConcreteProductA();
    }
}
