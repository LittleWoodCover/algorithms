package com.concur.zk.algorithm.linear.stack;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {


    public Node head;

    public int length;


    public Stack() {

        head=new Node(null,null);
        length=0;
    }

    public void clear(){

        head.next=null;
        length=0;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public void push(T val){

        Node node=new Node(val,null);
        if(isEmpty()){
            head.next=node;
            length++;
            return;
        }
        node.next=getFirst();
        head.next=node;
        length++;
    }

    public T pop(){

        if(isEmpty()){
            return null;
        }
        Node node=getFirst();
        head.next=node.next;
        length--;
        return (T) node.value;
    }

    public boolean hasNext(){

        return head.next!=null;
    }


    public Node getFirst(){

        return head.next;
    }

    @Override
    public Iterator<T> iterator() {
        return new ItStack();
    }


    private class ItStack implements Iterator<T>{

        private Node node;

        public ItStack() {
            this.node = head;
        }

        @Override
        public boolean hasNext() {
            return node.next!=null;
        }

        @Override
        public T next() {
            node=node.next;
            return (T) node.value;
        }
    }

    public static class Node<T>{

        public T value;
        public Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
