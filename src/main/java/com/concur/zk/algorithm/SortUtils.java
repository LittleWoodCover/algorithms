package com.concur.zk.algorithm;

import java.util.Arrays;

public class SortUtils {

    public static int[] exchange(int[] arr,int i,int j){

        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return arr;
    }

    public static Object[] exchangeObj(Object[] arr,int i,int j){

        Object temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return arr;
    }

    public static int[] generate(int val){

        int[] arr=new int[val];
        for(int i=val;i>0;i--){
            arr[val-i]=i;
        }
        return arr;
    }

    public static void show(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void showArr(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            show(arr[i]);
        }
    }

    public static void showObj(Object[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void exch(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
