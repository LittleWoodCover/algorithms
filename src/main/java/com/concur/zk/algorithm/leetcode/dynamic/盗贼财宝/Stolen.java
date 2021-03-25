package com.concur.zk.algorithm.leetcode.dynamic.盗贼财宝;

public class Stolen {


    public static void main(String[] args) {

        int[] arr={5,2,6,3,1,7};
        System.out.println(stolen(arr));
    }

    public static int stolen(int[] arr){

        int[] res=new int[arr.length];

        res[0]=arr[0];
        res[1]=max(arr[0],arr[1]);

        for(int i=2;i<arr.length;i++){

            //问题的最小规模就是盗取三个房间中的俩个和一个的问题
            //盗取1/3房间和2房间看那个房间钱多
            res[i]=max(res[i-1],(arr[i]+res[i-2]));
        }
        return res[arr.length-1];
    }

    public static int max(int i,int j){
        return i>j?i:j;
    }
}
