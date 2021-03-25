package com.concur.zk.algorithm.sort;

import com.concur.zk.concurrent.forkjoin.MakeArray;

import java.util.Arrays;

/**
 * 快速排序指针交换法
 */
public class FastSort2 {

    /**
     * 找到排序的中间位置
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int part(int[] arr, int start, int end) {

        int key = arr[start];
        int s = start;
        int e = end;
        int temp, index = s;

        while (e >=s) {

            while (e > s && arr[e] > key) {
                e--;
            }
            while (e > s && arr[s] <= key) {
                s++;
            }
            if(e>s){
                temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
            }else{
                arr[start]=arr[s];
                arr[s]=key;
                break;
            }
        }
       return s;
    }

    public static void quickSort(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }
        int index = part(arr, start, end);

        quickSort(arr, start, index - 1);
        quickSort(arr, index + 1, end);
    }


    public static void main(String[] args) {

        int[] intArray = MakeArray.createRandomIntArray(20);
        quickSort(intArray, 0, intArray.length - 1);
        Arrays.stream(intArray).forEach(i -> System.out.print(i + " "));
    }
}
