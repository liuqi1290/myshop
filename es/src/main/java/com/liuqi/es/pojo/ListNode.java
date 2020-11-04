package com.liuqi.es.pojo;

public class ListNode {
     int val;
     public ListNode next;

    public ListNode(int  x) {
        this.val = x;
        this.next = null;
    }

    public void add(int newval){
        ListNode newNode = new ListNode(newval);
        if(this.next==null){
            this.next=newNode;
        }else{
            this.next.add(newval);
        }
    }

    public void print(){
        System.out.print(this.val);
        if(this.next!=null){
            System.out.print("->");
            this.next.print();
        }
    }
}
