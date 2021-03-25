package com.concur.zk.algorithm.sort.exercise;

import com.concur.zk.algorithm.SortUtils;

import java.util.Arrays;

public class Selection {

    public static void main(String[] args) {

        int[] arr=new int[]{6,5,4,7,8,9,10,3,2,1};
        System.out.println(Arrays.toString(sort(arr)));
    }


    public static int[] sort(int[] arr){

        for(int i=0;i<arr.length;i++){
            int index=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[index]){
                    index=j;
                }
            }
            if(index!=i){
                SortUtils.exchange(arr,i,index);
            }
        }


        return arr;
    }
}
