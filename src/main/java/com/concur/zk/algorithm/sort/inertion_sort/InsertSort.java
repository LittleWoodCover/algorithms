package com.concur.zk.algorithm.sort.inertion_sort;


import com.concur.zk.algorithm.SortUtils;

import java.util.Arrays;

/**
 * 插入排序：
 *      把所有元素分为俩组，已排序的和未排序的
 *      找到为排序中的一个元素，向已排序的组中进行插入
 *      倒叙遍历已排序组，依次和已排序组进行比较，直到找到一个元素比这个元素小或者等于，把这个从这个位置的数组一次向后移动，把这个元素放在这个位置.交换
 * 时间复杂度
 *      O(n^2)
 */
public class InsertSort {


    public static void main(String[] args) {

//        int[] arr=new int[]{6,5,4,7,8,9,10,3,2};
        int[] arr=new int[100000];
        for(int i=100000;i>0;i--){
            arr[100000-i]=i;
        }
        long start=System.currentTimeMillis();
        insertSort(arr);
        long end=System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(Arrays.toString(arr));
//        insertSort(arr);
//        System.out.println(Arrays.toString(arr));
    }


    public static int[] insertSort(int[] arr){

        for(int i=1;i<arr.length;i++){

            for(int j=i;j>0;j--){
                if(arr[j-1]>arr[j]){
                    SortUtils.exchange(arr,j-1,j);
                }else{
                    break;
                }
            }
        }
        return arr;
    }
}
