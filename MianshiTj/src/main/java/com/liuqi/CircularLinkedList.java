package com.liuqi;

import java.util.HashMap;

/*
创建一个循环链表
 */
public class CircularLinkedList {
    public class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    //循环链表insert
    public void insert(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
    }

    //循环链表delete
    public void delete(int data) {
        if (isEmpty()) {
            System.out.println("链表为空");
            return;
        }
        Node current = head;
        Node previous = null;
        while (current.data != data) {
            if (current.next == head) {
                System.out.println("未找到要删除的节点");
                return;
            }
            //将前一个节点指向当前节点，当前节点指向下一个节点
            previous = current;
            current = current.next;

        }
        if (current == head && current == tail) {
            head = null;
            tail = null;
        }
        else if (current == head) {
            head = head.next;
            tail.next = head;
        }
        else if (current == tail) {
            tail = previous;
            tail.next = head;
        }
        else {
            previous.next = current.next;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("链表为空");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();

    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insert(1);
        cll.insert(2);
        cll.insert(3);
        cll.insert(4);
        cll.display(); // 输出：1 2 3 4
        cll.delete(3);
        cll.display(); // 输出：1 2 4

    }

}



