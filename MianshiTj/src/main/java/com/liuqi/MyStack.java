package com.liuqi;

public interface MyStack<T> {
    // 入栈操作
    void push(T value);

    // 出栈操作
    T pop();

    // 判断栈是否为空
    boolean isEmpty();

    // 获取栈的大小
    int size();

}
