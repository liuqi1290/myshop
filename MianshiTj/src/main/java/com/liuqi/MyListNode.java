package com.liuqi;


public class MyListNode {
    private NodeList head;
    private int size;

    // 构造函数
    public MyListNode() {
        head = null;
        size = 0;
    }

    public void add(int val) {
        NodeList newNode = new NodeList(val);
        if (head == null) {
            head = newNode;
        } else {
            head.next = newNode;
        }
    }

    public void insert(int val, int index) {
        NodeList newNode = new NodeList(val);
        if (index == 0) {
            insertHeader(val);
        } else {
            NodeList current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            // 在当前节点的下一个节点插入新节点，先将新的节点指向下一个节点
            // 然后将当前节点的下一个节点指向新的节点
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void delete(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            NodeList current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }

    }
    public int get(int data){
        NodeList curr = this.head;
        while (curr != null){
            if (curr.val == data){
                return curr.val;
            }
            curr = curr.next;
        }
       return  -1;
    }
public void insertHeader(int val) {
    NodeList newNode = new NodeList(val);
    newNode.next = head;
    head = newNode;
 }
}

class NodeList {
    int val;
    NodeList next;

    NodeList(int x) {
        val = x;
        next = null;
    }
}