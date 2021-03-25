package com.concur.zk.algorithm.sort.sort1;

import java.util.Arrays;

public class Quick {

    public static void main(String[] args) {

        int[] arr=new int[]{6,5,4,7,8,9,10,3,2,1};
        Quick.sort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));

    }


    public static int[] sort(int[] arr,int start,int end){
        if(start>=end){
            return arr;
        }
        int part = part(arr, start, end);
        sort(arr,start,part);
        sort(arr,part+1,end);
        return arr;
    }

    public static int part(int[] arr,int start,int end){
        int index=start;
        int base=arr[start];
        int s=start;
        int e=end;
//        int[] arr=new int[]{6,5,4,7,8,9,10,3,2,1};
        while(e>=s){
            //左边挖矿，和右边侧边边上的数据比较。如果右边比挖出坑的数据小，就互换坑。右边为坑。切换到左边开始找坑的位置：
            while(e>=s){
                if(base>arr[e]) {
                    arr[index] = arr[e];
                    index = e;
                    s++;
                    break;
                }
                e--;
            }
            while(e>=s){
                if(base<arr[s]) {
                    arr[index] = arr[s];
                    index=s;
                    e--;
                    break;
                }
                s++;
            }
            if(e==s) {
                break;
            }

        }
        arr[index]=base;
        return index;
    }
}
