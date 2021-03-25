package com.concur.zk.algorithm.heap;

import com.concur.zk.algorithm.SortUtils;

public class MinPriorityQueue<T extends Comparable<T>>{

    T[] values;

    int length;

    public MinPriorityQueue(int length) {

        values= (T[]) new Comparable[length+1];
        length=0;
    }


    public void insert(T val){
        values[++length]=val;
        swim(length);
    }

    public T delMin(){
        if(length==0){
            return null;
        }
        T min=values[1];
        SortUtils.exchangeObj(values,1,length);
        length--;
        sink(1,length);
        return min;
    }

    public void swim(int k){

        while(k>1){
            if(lt(k,k/2)){
                SortUtils.exchangeObj(values,k,k/2);
            }
            k/=2;
        }
    }

    public void sink(int k,int length) {

        while (2 * k <= length) {
            int min;
            if (2 * k + 1 <= length) {
                if (lt(2 * k, 2 * k + 1)) {
                    min = 2 * k;
                } else {
                    min = 2 * k + 1;
                }
            }else{
                min=2*k;
            }
            if(lt(min,k)){
                SortUtils.exchangeObj(values,k,min);
                k=min;
            }else{
                break;
            }
        }
    }

    public boolean lt(int i,int j){
        return values[i].compareTo(values[j])<0;
    }

}
