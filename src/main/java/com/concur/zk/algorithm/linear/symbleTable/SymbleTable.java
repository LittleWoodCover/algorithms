package com.concur.zk.algorithm.linear.symbleTable;

import java.util.Iterator;

public class SymbleTable<K,V> implements Iterable{


    private Node head;

    private int length;

    public SymbleTable() {

        head=new Node(null,null,null);
        length=0;
    }

    public boolean isEmpty(){

        return length==0;
    }

    public int size(){
        return length;
    }

    public void put(K key,V value){

        Node node=new Node(key,value,null);
        if(isEmpty()){
            head.next=node;
            length++;
        }else{
            Node exist=exists(key);
            if(exist!=null){
                exist.value=value;
            }else{
                add(node);
            }
        }
    }

    public V get(K key){

        if(isEmpty()){
            return null;
        }else{
            Node cur=head;

            while(cur.next!=null){
                if(cur.next.key.equals(key)){
                    return (V) cur.next.value;
                }
                cur=cur.next;
            }
        }
        return null;
    }

    public Node exists(K key){

        Node cur=head;
        if(isEmpty()){
            return null;
        }else{
            while(cur.next!=null){
                if(cur.next.key.equals(key)){
                    return cur;
                }
                cur=cur.next;
            }
        }
        return null;
    }

    public void add(Node node){

        if(isEmpty()){
            head.next=node;
            length++;
        }else{
            Node cur=head;
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
            length++;
        }
    }

    public void remove(K key){
        if(isEmpty()){
            return;
        }else{
            Node pre=head;

            while(pre.next!=null){
                if(pre.next.key.equals(key)){
                    if(pre.next.next!=null){
                        pre.next=pre.next.next;

                    }else{
                        pre.next=null;
                    }
                    length--;
                    return ;
                }
                pre=pre.next;
            }
        }
    }


    private class Node<K,V>{

        public K key;

        public V value;

        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public Iterator iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{


        private Node node;

        public SIterator() {

            this.node=head;
        }

        @Override
        public boolean hasNext() {
            return node.next!=null;
        }

        @Override
        public Object next() {
            node=node.next;
            return node.value;
        }
    }

}
