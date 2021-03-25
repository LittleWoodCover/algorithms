package com.concur.zk.algorithm.sort.exercise;

import com.concur.zk.algorithm.SortUtils;

import java.util.Arrays;

public class Shell {

    public static void main(String[] args) {

        int[] arr=new int[]{6,5,4,7,8,9,10,3,2,1};
        System.out.println(Arrays.toString(sort(arr)));
    }


    public static int[] sort(int[] arr){


        int k=1;
        while(k<arr.length/2){
            k=2*k+1;
        }

       while(k>0){
           for(int i=k;i<arr.length;i++){

               for(int j=i;j>=k;j-=k){
                   if(arr[j]<arr[j-k]){
                       SortUtils.exchange(arr,j,j-k);
                   }else{
                       break;
                   }
               }
           }
           k/=2;
       }

        return arr;
    }
}
