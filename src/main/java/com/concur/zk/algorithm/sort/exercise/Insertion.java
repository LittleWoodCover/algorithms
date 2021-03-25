package com.concur.zk.algorithm.sort.exercise;

import com.concur.zk.algorithm.SortUtils;

import java.util.Arrays;

public class Insertion {

    public static void main(String[] args) {

        int[] arr=new int[]{6,5,4,7,8,9,10,3,2,1};
        System.out.println(Arrays.toString(sort(arr)));
    }


    public static int[] sort(int[] arr){

        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(arr[j-1]>arr[j]){
                    SortUtils.exchange(arr,j-1,j);
                }
            }
        }

        return arr;
    }
}
