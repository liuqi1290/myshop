package com.liuqi;

import java.util.Scanner;

/*
 * 数组模拟栈
 */
public class ArrayStack<T> implements MyStack<T> {
    private T[] arr;

    private int maxSize;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        arr = (T[]) new Object[maxSize];
    }

    // 入栈
    public void push(T value) {
        checkSize();
        top++;
        arr[top] = value;
    }

    //判断栈是否需要扩容或者缩容
    public void checkSize() {
        if (top == maxSize / 2) {
            resize(maxSize / 2);
        }
        if (top >= maxSize) {
            resize(maxSize * 2);
        }

    }

    //栈扩容
    public void resize(int size) {
        T[] temp = (T[]) new Object[size];
        for (int i = 0; i <= top; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
        maxSize = size;
    }


    // 出栈
    public T pop() {
        if (top == -1) {
            System.out.println("栈已空，无法出栈");
            return null;
        }
        T value = arr[top];
        top--;
        return value;
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return top == -1;
    }


    //获取栈顶元素
    public T getTop() {
        if (top == -1) {
            System.out.println("栈已空，无法获取栈顶元素");
            return null;
        }
        return arr[top];
    }

    //栈大小
    public int size() {
        return top + 1;
    }

    private static int calculate(int num1, int num2, char op) {

        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        //模拟四则运算
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个四则运算表达式：");
        String expression = scanner.nextLine();
        ArrayStack<Integer> integerArrayStack = new ArrayStack<>(20);
        ArrayStack<Character> characterArrayStack = new ArrayStack<>(20);
        //使用栈计算
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c >= '0' && c <= '9') {
                integerArrayStack.push(c - '0');
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                characterArrayStack.push(c);
            }


        }
    }
}


