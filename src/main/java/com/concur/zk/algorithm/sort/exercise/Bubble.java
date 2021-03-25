package com.concur.zk.algorithm.sort.exercise;

import com.concur.zk.algorithm.SortUtils;

import java.util.Arrays;

public class Bubble {

    public static void main(String[] args) {

        int[] arr=new int[]{6,5,4,7,8,9,10,3,2,1};
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static int[] sort(int[] arr){

        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    SortUtils.exchange(arr,j,j+1);
                }
            }
        }
        return arr;
    }
}
