package com.concur.zk.algorithm.linear.linkedlist;

import java.util.Iterator;

public class LinkList<T> implements Iterable<T>{

    private Node head;

    private int len;

    public LinkList(){
        this.head=new Node(null,null);
        this.len=0;
    }

    public Node getHead(){
        return head;
    }


    public static class Node<T>{

        public T val;
        public Node next;
        public Node(T value, Node next) {
            this.val = value;
            this.next = next;
        }

        public void setNext(Node node){
            this.next=node;
        }

        public boolean hasNext(){
            return this.next!=null;
        }

        public T value(){
            return val;
        }

        public Node getNext(){
            return next;
        }
    }

    public Node getFirst(){
        return head.next;
    }

    public void add(T val){
        Node n=new Node(val,null);
        Node pos=head;
        while(pos.hasNext()){
            pos=pos.next;
        }
        pos.next=n;
        len++;
    }

    public void add(Node val){
//        Node n=new Node(val,null);
        Node pos=head;
        while(pos.hasNext()){
            pos=pos.next;
        }
        pos.next=val;
        len++;
    }

    public void insert(int index,T val){

        Node pre=head;
        while(index>0){
            pre=pre.next;
            index--;
        }
        Node current=pre.next;

        Node newNode=new Node(val,current);
        pre.next=newNode;
        len++;
    }

    public void remove(int index){

        Node pre=head;
        while(index>0){
            pre=pre.next;
            index--;
        }
        Node current=pre.next;
        pre.next=current.next;
        len--;
    }

    public void remoeNode(Node val){

        Node pre=head.next;
        while(pre.hasNext()){
            if(pre.next==val){
                Node current=pre.next;
                pre.next=current.next;
                len--;
                return;
            }
            pre=pre.next;
        }
    }

    public void clear(){

        this.head.next=null;
        this.len=0;
    }

    public boolean isEmpty(){
        return len==0;
    }
    public int length(){
        return len;
    }

    public T get(int index){
        Node n=head.next;
        for(int i=0;i<index;i++){
            n=n.next;
        }
        return (T) n.val;
    }


    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator<T>{

        Node node;
        public LIterator(){
            this.node=head;
        }
        @Override
        public boolean hasNext() {
            return node.hasNext();
        }

        @Override
        public T next() {
            node=node.next;
            return (T) node.val;
        }
    }

}
