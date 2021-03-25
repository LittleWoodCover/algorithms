package com.concur.zk.algorithm.sort.search;

import com.concur.zk.concurrent.forkjoin.MakeArray;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 二分查找。
 * 适用于有序的队列查找。时间复杂度为log(2)(n),n为队列长度。
 * 主要思想还是用递归和缩小范围查找
 *
 */
public class BinarySearch {

    private static  AtomicInteger searchTime=new AtomicInteger(0);
    public static void doSearch(int value, int start, int end, int[] arr){
        System.out.println("----------searching start :"+start+", end"+end+"----------");
        searchTime.incrementAndGet();
        if((end-start)<=2){
            if(value==arr[start]){
                System.out.println("---------------------end--------------------");
                System.out.println("found at search time :"+searchTime.intValue()+", index :"+start);
            }else{
                System.out.println("---------------------end--------------------");
                System.out.println("found at search time :"+searchTime.intValue()+", index :"+end);
            }
        }else{
            int mid=(end+start)/2;
            if(value<arr[mid]){
                System.out.println("search left...");
                doSearch(value,start,mid,arr);
            }else if(value==arr[mid]){
                System.out.println("---------------------end--------------------");
                System.out.println("found at search time :"+searchTime.intValue());
            }else{
                System.out.println("search right...");
                doSearch(value,mid+1,end,arr);
            }
        }
    }

    public static void main(String[] args) {

        int[] array = MakeArray.createIntArray(20);
        doSearch(12,0,array.length-1,array);
    }

}
