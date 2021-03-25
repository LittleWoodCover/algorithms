package com.concur.zk.algorithm.sort.bubble_sort;


/**
 * 冒泡排序，每一次找出最大的元素，放在队列最后面
 * 算法的时间复杂度位O(n^2)
 * 在数组规模小的时候可以使用，数组规模大的时候不太适合
 *
 */

public class BubbleSort {


    public static void main(String[] args) {

        int[] arr=new int[]{6,5,4,7,8,9,10,3,2};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static int[] sort(int[] arr){
        int temp=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }
}
