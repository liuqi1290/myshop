package com.liuqi;

/*
 编写一个双向链表的Java代码实现。
 */
public class BidirectionalList {
    // 双向链表节点类
    private static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    // 构造函数
    public BidirectionalList() {
        head = null;
        tail = null;
    }

    // 在链表末尾添加节点
    public void add(int data) {
        Node newNode = new Node(data);
        tail.next= newNode;
        newNode.prev = tail;
    }
    // 在链表开头添加节点
    public void addFirst(int data) {
        Node newNode = new Node(data);
        head.prev=newNode;
        newNode.next=head;
        head=newNode;
    }
    // 在链表指定位置插入节点
    public void insert(int data, int position) {
        Node newNode = new Node(data);
        if(head== null){
            head=newNode;
            tail=newNode;
            return;
        }
        Node current = head;
        for (int i = 0; i < position-1; i++) {
            current=current.next;
        }
        newNode.next=current.next;
        newNode.prev=current;
        current.next.prev=newNode;
        current.next=newNode;
    }

    // 删除指定值的节点
    public void remove(int data) {
        Node curr=head;
        while(curr.data!=data){
            curr=curr.next;
        }
        curr.prev.next=curr.next;
        curr.next.prev=curr.prev;
        curr.next=null;
        curr.prev=null;
        curr=null;

    }
    // 删除链表第一个节点
    public void removeFirst() {
        head=head.next;
        head.prev=null;
    }
    // 删除链表最后一个节点
    public void removeLast() {
        tail=tail.prev;
        tail.next=null;
    }
    // 获取链表长度
    public int size() {
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    // 打印链表
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
    // 清空链表
    public void clear() {
        head = null;
        tail = null;
    }
    // 判断链表是否为空
    public boolean isEmpty() {
        return head == null;
    }
    // 获取链表第一个节点
    public Node getFirst() {
        return head;
    }
    // 获取链表最后一个节点
    public Node getLast() {
        return tail;
    }
    // 获取指定位置的节点
    public Node get(int position) {
        Node current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current;
    }
    //
}

