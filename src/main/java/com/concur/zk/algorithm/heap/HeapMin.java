package com.concur.zk.algorithm.heap;

public class HeapMin {

    int[] values;

    int length;

    public HeapMin(int cap){
        values=new int[cap+1];
    }

    public void add(int val){

        values[++length]=val;
        if(length>1){
            swim(length);
        }
    }
    public int delMin(){

        int val=values[1];
        exch(values,1,length);
        length--;
        sink(1);
        return val;

    }

    public void swim(int index){

        while(index>1){
            if(values[index]<values[index/2]){
                exch(values,index,index/2);
                index/=2;
            }else{
                return;
            }
        }
    }
    public void sink(int k){


    }

    public void exch(int[] arr,int i,int j){
        int temp=values[i];
        values[i]=values[j];
        values[j]=temp;
    }

    public boolean min(int i,int j){
        return values[i]<values[j];
    }
}
