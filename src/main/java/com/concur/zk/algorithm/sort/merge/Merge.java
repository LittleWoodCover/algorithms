package com.concur.zk.algorithm.sort.merge;


import com.concur.zk.algorithm.SortUtils;

import java.util.Arrays;

/**
 * 归并排序
 */
public class Merge {

    public static void main(String[] args) {
        int[] arr=new int[]{6,5,4,7,8,9,10,3,2,1};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));


        int[] arrs = SortUtils.generate(100000);
        long start = System.currentTimeMillis();

        sort(arrs,0,arrs.length-1);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(Arrays.toString(arrs));
    }

    public static void sort(int[] arr,int start,int end){

        if(end-start<0) return ;
        if(end-start==1||end-start==0){
            if(arr[start]>arr[end]){
                SortUtils.exchange(arr,start,end);
            }
            return ;
        }
        int mid=(end+start)/2;

        sort(arr,start,mid);
        sort(arr,mid+1,end);

        merge(arr,start,mid,end);
    }

    public static int[] merge(int[] arr,int start,int mid,int end){

        int[] temp=new int[end-start+1];
        int left=start;
        int right=mid+1;

        for(int i=0;i<=end-start;i++){
            if(left!=mid+1&&right!=end+1){
                if(arr[left]>arr[right]){
                    temp[i]=arr[right++];
                }else {
                    temp[i]=arr[left++];
                }
            }else if(left!=mid+1){
                temp[i]=arr[left++];
            }else{
                temp[i]=arr[right++];
            }
        }

        for(int i=0;i<=end-start;i++){
            arr[start+i]=temp[i];
        }
        return arr;
    }
}
