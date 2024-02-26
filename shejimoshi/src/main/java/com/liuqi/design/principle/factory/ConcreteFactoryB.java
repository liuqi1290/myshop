package com.liuqi.design.principle.factory;

public class ConcreteFactoryB extends AbstractFactory {
    //使用单例模式实例化ConcreteFactoryB
    private ConcreteFactoryB() {
    }

    public static ConcreteFactoryB getInstance() {
        return Holder.INSTANCE;
    }
    //在这个例子中，我们定义了一个静态内部类Holder，它被声明为私有静态类，这意味着它只能从外部类ConcreteFactoryB访问。Holder类包含一个静态常量INSTANCE，它是ConcreteFactoryB类型的对象，它是通过new关键字创建的。这个静态常量INSTANCE表示ConcreteFactoryB的单例对象，它是通过ConcreteFactoryB()构造函数创建的。
    //这个实现方式使用了静态内部类来保存单例对象，这种方式可以确保在整个程序运行过程中，只有一个实例被创建。当程序第一次访问Holder.INSTANCE时，它会创建一个新的ConcreteFactoryB对象，并将其保存在INSTANCE常量中。从那以后，每次访问Holder.INSTANCE时，都会返回相同的ConcreteFactoryB对象，而不是创建新的对象。这种实现方式可以避免内存泄漏和提高性能，因为它确保了单例对象只被创建一次。同时，这种实现方式也符合单例模式的创建原则，即在程序运行过程中，只创建一个实例。
    private static class Holder {
        private static final ConcreteFactoryB INSTANCE = new ConcreteFactoryB();
    }

    @Override
    public Product createProduct() {
        return new ConcreteProductB();
    }
}
