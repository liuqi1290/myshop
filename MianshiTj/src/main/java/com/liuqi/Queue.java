package com.liuqi;
/*
 模拟实现一个队列
 */
public class Queue {
    private  int[] arr;
    private int maxSize;
    //队列的插入指针
    private int head;
    //队列的删除指针
    private int tail;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.head = 0;
        this.tail = 0;
    }

    //判断队列是否满了
    public boolean isFull(){
        return head == maxSize- 1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return head == tail;
    }

    //入队
    public void addQueue(int n){
        if(isFull()){
           //将队列中元素向前移动
            for (int i = 0; i < tail; i++) {
                arr[i] = arr[i+1];
            }
            tail--;
        }
        arr[tail] = n;
        tail++;
    }

    //出队
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        int value = arr[head];
        head++;
        return value;
    }

    //显示队列
    public void showQueue(){
        if(isEmpty()){
        }

    }


}
