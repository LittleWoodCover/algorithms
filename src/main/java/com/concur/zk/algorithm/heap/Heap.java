package com.concur.zk.algorithm.heap;

import com.concur.zk.algorithm.SortUtils;

public class Heap<T extends Comparable<T>> {

    private T[] items;

    public int length;

    public Heap(int cap){

        this.items= (T[])new Comparable[cap];
        length=0;
    }

    private boolean gt(int i,int j){
        return items[i].compareTo(items[j])>0;
    }

    public void insert(T val){

        items[++length]=val;
        swim(length);
    }

    public T  delMax(){

        T max=items[1];
        SortUtils.exchangeObj(items,1,length);
        items[length]=null;
        length--;

        sink(1);
        return max;
    }



    public void swim(int k){

        while(k>1){
            if(gt(k,k/2)){
                SortUtils.exchangeObj(items,k,k/2);
                k/=2;
            }
        }
    }


    public void sink(int k){

        while(2*k<length){
            int max;
            if(2*k+1<=length){
                if(gt(2*k,2*k+1)){
                    max=2*k;
                }else{
                    max=2*k+1;
                }
            }else{
                max=2*k;
            }
            if(gt(k,max)){
                break;
            }else{
                SortUtils.exchangeObj(items,k,max);
                k=max;
            }
        }
    }

}
