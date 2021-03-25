package com.concur.zk.algorithm.sort;//package com.concur.zk.algorithm.sort;
//
//
//import com.concur.zk.concurrent.forkjoin.MakeArray;
//
//import java.util.Arrays;
//
///**
// * 快速排序
// * 以arr[i] 为基准。挖个坑出来，比arr[i]小的放在坑里。
// *
// */
//public class FastSort1 {
//
//    public static int part(int[] arr,int start,int end){
//        int key = arr[start];
//        int s=start;
//        int e=end;
//        int index=start;
//
//        while(e>=s){
//            while(e>=s){//从右向左移动
//                if(arr[e]<key){
//                    arr[s]=arr[e];//把右边的坑让出来
//                    index=e;
//                    s++;
//                    break;
//                }
//                e--;
//            }
//            while (e>=s){
//                if(arr[s]>key){
//                    arr[index]=arr[s];
//                    index=s;
//                    e--;
//                    break;
//                }
//                s++;
//            }
//            if(e==s) break;
//        }
//        arr[index]=key;
//        return index;
//    }
//
//    public static void sort(int[] arr, int start, int end) {
//        if(start>=end){
//            return;
//        }
//        int index=part(arr,start,end);
//        sort(arr,start,index);
//        sort(arr,index+1,end);
//
//    }
//
//    public static void main(String[] args) {
//
//
//        int[] randomIntArray = MakeArray.createRandomIntArray(20);
//        Arrays.stream(randomIntArray).forEach(i -> System.out.print(i+ " "));
//        System.out.println();
//         FastSort1.sort(randomIntArray, 0, randomIntArray.length-1);
//        Arrays.stream(randomIntArray).forEach(i -> System.out.print(i+" "));
//
//    }
//}
