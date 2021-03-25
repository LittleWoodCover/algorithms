package com.concur.zk.algorithm.linear.linkedlist;

import java.util.Iterator;

public class TwoWayLinkList<T> implements Iterable<T>{


    private Node head;
    private Node tail;
    private int len;

    public TwoWayLinkList(){

        this.head=new Node(null,null,null);

        this.tail=head;
        this.tail=null;
        this.len=0;
    }

    public boolean isEmpty(){
        return len==0;
    }

    public T getFirst(){
        return isEmpty()?null:(T) head.next.value;
    }

    public T getLast(){

        return isEmpty()?null: (T) tail.value;
    }

    public int length(){
        return len;
    }

    public void add(T val){
        Node node =new Node(val,null, null);
        add(node);
    }

    public void add(Node node){
        if(isEmpty()){
            head.next=node;
            node.pre=head;
            tail=node;
        }else{
            tail.next=node;
            node.pre=tail;
            tail=node;
        }
        len++;
    }


    public T get(int i){

        Node pre=head;
        while(i-->0){
            pre=pre.next;
        }

        return (T) pre.next.value;
    }

    public int indexOf(T val){

        Node pre=head;
        int i=0;
        while( i<len){
            if(pre.next.value.equals(val)){
                return i;
            }
            i++;
        }
        return -1;
    }
    public void insert(int index,T val){

        if(index>len){
            return;
        }
        if(isEmpty()){
            add(val);
        }else{
            Node pre=head;
            while(index>0){
                pre=pre.next;
                index--;
            }
            Node current=pre.next;
            Node node=new Node(val,null,null);

            node.next=current;
            current.pre=node;

            node.pre=pre;
            pre.next=node;
            len++;
        }
    }


    public class Node<T>{

        T value;
        Node pre;
        Node next;

        public Node(T value, Node pre, Node next) {
            this.value = value;
            this.pre = pre;
            this.next = next;
        }

        public boolean hasNext(){
            return this.next!=null;
        }

    }



    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }


    private class TIterator implements Iterator<T>{

        Node node;

        public TIterator() {
            this.node=head;
        }

        @Override
        public boolean hasNext() {
            return node.hasNext();
        }

        @Override
        public T next() {
            node=node.next;
            return (T) node.value;
        }
    }

    public void reverse(){

        if(isEmpty()){
            return;
        }

        reverse(head.next);
    }

    private Node reverse0(Node cur){

        if(cur.next==null){
            return cur;
        }
        //返回尾节点
        Node pre=reverse0(cur.next);
        pre.next=cur;
        cur.next=null;
        return cur;
    }

    private Node reverse(Node curr){

        if(curr.next==null){
            head.next= curr;
            return curr;
        }
        //pre=cur.next;
        Node pre=reverse(curr.next); //->reverse(curr.next),
        pre.next=curr;
        curr.next=null;
        return curr;
    }


    public T getMid(){

        Node fast=head;
        Node slow=head;
        while(fast!=null&&fast.next!=null){

            fast=fast.next.next;
            slow=slow.next;
        }

        return (T) slow.value;
    }

    public boolean hasCircle(){
        Node fast=head;
        Node slow=head;

        while(fast!=null&&fast.next!=null){

            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        TwoWayLinkList linkList=new TwoWayLinkList();
    }
}
