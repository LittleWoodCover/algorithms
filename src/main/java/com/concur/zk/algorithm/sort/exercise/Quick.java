package com.concur.zk.algorithm.sort.exercise;

import java.util.Arrays;

public class Quick {


    public static void main(String[] args) {

        int[] arr=new int[]{6,5,4,7,8,9,10,3,2,1};
        System.out.println(Arrays.toString(sort(arr,0,arr.length-1)));
    }


    public static int[] sort(int[] arr,int start,int end){

        if(start>=end) return arr;

        int index=part(arr,start,end);

        sort(arr,start,index);
        sort(arr,index+1,end);
        return arr;
    }

    //挖坑法：
    public static int part(int[] arr,int start,int end){

        int index=start;
        int base=arr[index];
        int s=start;
        int e=end;
        while(e>=s){
            while(e>=s){
                if(base>arr[e]){
                    arr[index]=arr[e];
                    index=e;
                    s++;
                    break;
                }
                e--;
            }
            while(e>=s){
                if(base<arr[s]){
                    arr[index]=arr[s];
                    index=s;
                    e--;
                    break;
                }
                s++;
            }
            if(e==s) break;
        }

        arr[index]=base;

        return index;
    }
}
