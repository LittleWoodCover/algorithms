package com.concur.zk.algorithm.sort.selection_sort;


import com.concur.zk.algorithm.SortUtils;

import java.util.Arrays;

/**
 * 选择排序
 * 每一次遍历数组，找出数组中最小的元素下标，和当前的index所在的元素交换位置。
 * 时间复杂度也是O(n^2)
 * 算法分析：
 *      比较次数：n-1+n-2+...1=(n^2-n)/2
 *      交换次数：n-2
 *      根据大O法则，复杂度为：O(n^2)
*/
public class SelectionSort {


    public static void main(String[] args) {

        int[] arr = new int[]{2, 4, 6, 1, 5,9,8};
        arr = sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sort(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i ; j < arr.length ; j++) {
                if(arr[index]>arr[j]){
                    index=j;
                }
            }
            arr= SortUtils.exchange(arr, i, index);
        }
        return arr;
    }


}
