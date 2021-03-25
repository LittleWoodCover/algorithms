package com.concur.zk.algorithm.sort.sort1;

import com.concur.zk.algorithm.SortUtils;

import java.util.Arrays;

public class Shell {

    public static void main(String[] args) {

        int[] arr=new int[]{6,5,4,7,8,9,10,3,2,1};
        System.out.println(Arrays.toString(Shell.sort(arr)));



//        int[] temp=SortUtils.generate(100000);
//        long start=System.currentTimeMillis();
//        sort(temp);
//        long end=System.currentTimeMillis();
//        System.out.println(end-start);
//        System.out.println(Arrays.toString(temp));
    }

    public static int[] sort(int[] arr){
        int length=arr.length;
        int h=1;
        while(h<length/2){
            h=2*h+1;
        }
        while(h>=1){
//            int[] arr=new int[]{6,5,4,7,8,9,10,3,2,1};
            for(int i=h;i<arr.length;i++){
                for(int j=i;j>=h;j-=h){
                    if(arr[j]<arr[j-h]){
                        SortUtils.exchange(arr,j,j-h);
                    }
                }
            }
            h/=2;
        }
        return arr;
    }

    public static int[] sort1(int[] arr){
        int length=arr.length;
        int h=1;
        while(h<length/2){
            h=2*h+1;
        }
        while(h>=1){

            for(int i=0;i<length-h;i++){

            }
        }

        return arr;

    }
}
