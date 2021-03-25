package com.concur.zk.algorithm.linear.seqlist;

import java.util.Iterator;

public class SequenceList<T> implements Iterable<T> {


    private T[] elements;

    private int len;

    public SequenceList (int length){

        elements= (T[]) new Object[length];
        this.len=0;
    }

    public boolean isEmpty(){
        return len==0;
    }

    public void clear(){

        this.len=0;
    }

    public int length(){
        return len;
    }

    public void insert(int index,T val){

        if(index>len){
            return ;
        }
        for(int i=len-1;i>=index;i--){
            elements[i]=elements[i-1];
        }
        elements[index]=val;
        len++;
    }

    public void insert(T val){

        if(len==elements.length){
            resize(2*len);
        }
        elements[len++]=val;
    }

    public T remove(int index){
        T current=elements[index];
        if(index>0&&index<len-1){
            for(int i=index;i<len-2;i++){
                elements[i]=elements[+1];
            }
            len--;
        }
        if(len<elements.length/4){
            resize(elements.length/2);
        }
        return current;
    }

    public void resize(int size){

        T[] temp=elements;
        elements= (T[]) new Object[size];
        for(int i=0;i<=len-1;i++){
            elements[i]=temp[i];
        }
    }

    public int indexOf(T t){

        for(int i=0;i<=len-1;i++){

            if(elements[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new It(0);
    }

    private class It implements Iterator{

        private int cursor;
        public It(int cursor){
            this.cursor=cursor;
        }
        @Override
        public boolean hasNext() {
            return cursor<len;
        }

        @Override
        public Object next() {
            return elements[cursor++];
        }
    }

}
