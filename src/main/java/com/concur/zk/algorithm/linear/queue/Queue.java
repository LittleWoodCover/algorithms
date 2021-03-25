package com.concur.zk.algorithm.linear.queue;

import java.util.Iterator;

public class Queue<T> implements Iterable<T>{


    private Node head;

    private Node tail;

    private int length;

    public Queue() {

        head=new Node(null,null);
        tail=null;
        length=0;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public int size(){
        return length;
    }


    public void enqueue(T t){

        Node node=new Node(t,null);

        if(tail==null){
            tail=node;
            head.next=node;
            length++;
        }else{
            tail.next=node;
            tail=node;
            length++;
        }

    }

    public T dequeue(){

        if(isEmpty()){
            return null;
        }else{
            Node node=getFirst();
            head.next=node.next;
            length--;
            if(isEmpty()){
                tail=null;
            }
            return node.value;
        }
    }

    public Node getFirst(){
        return head.next;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }


    public class Node{

        public T value;
        public Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private class QIterator implements Iterator<T>{

        private Node node;

        public QIterator() {
            this.node = head;
        }

        @Override
        public boolean hasNext() {
            return node.next!=null;
        }

        @Override
        public T next() {
            node=node.next;
            return node.value;
        }
    }
}
