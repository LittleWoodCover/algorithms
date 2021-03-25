package com.concur.zk.algorithm.sort.exercise;

import java.util.Arrays;

public class Merge {

    public static void main(String[] args) {

        int[] arr=new int[]{6,5,4,7,8,9,10,3,2,1};
        System.out.println(Arrays.toString(sort(arr,0,arr.length-1)));
    }


    public static int[] sort(int[] arr,int start,int end){

        if(start>=end){
            return arr;
        }

        int mid=(end+start)/2;

        sort(arr,start,mid);
        sort(arr,mid+1,end);

        merge(arr,start,mid,end);
        return arr;
    }


    public static int[] merge(int[] arr,int start,int mid,int end){

        int[] temp=new int[end-start+1];

        int left=start;
        int right=mid+1;
        for(int i=0;i<temp.length;i++){
            if(left<=mid&&right<=end){
                if(arr[left]<arr[right]){
                    temp[i]=arr[left++];
                }else{
                    temp[i]=arr[right++];
                }
            }else if(left<=mid){
                temp[i]=arr[left++];

            }else{
                temp[i]=arr[right++];
            }
        }

        for(int i=0;i<temp.length;i++){
            arr[start+i]=temp[i];
        }
        return arr;
    }
}
