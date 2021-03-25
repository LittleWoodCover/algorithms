package com.concur.zk.algorithm.heap;

import com.concur.zk.algorithm.SortUtils;

public class MaxPriorityQueue<T extends Comparable<T>> {

    public T[] values;

    private int length;

    public MaxPriorityQueue(int length) {

        values= (T[]) new Comparable[length+1];
        length=0;
    }

    public boolean gt(int i,int j){

        return values[i].compareTo(values[j])>0;
    }

    public void insert(T t){

        values[++length]=t;

        swim(length);
    }

    public void swim(int k){

        while(k>1){
            if(gt(k,k/2)){
                SortUtils.exchangeObj(values,k,k/2);
                k/=2;
            }
        }
    }

    public void sink(int k){

        while(2*k<=length){
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
            if(gt(max,k)){
                SortUtils.exchangeObj(values,k,max);
            }
            k=max;
        }
    }

    public T delMax(){
        if(length==0){
            return null;
        }
        T max=values[1];
        SortUtils.exchangeObj(values,1,length);
        length--;
        sink(1);
        return max;
    }
}
