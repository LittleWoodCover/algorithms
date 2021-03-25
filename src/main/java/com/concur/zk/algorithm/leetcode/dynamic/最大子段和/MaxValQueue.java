package com.concur.zk.algorithm.leetcode.dynamic.最大子段和;


import java.util.Arrays;

/**
 * 获取子数组中最大子序列的和
 *
 * 算法分析：
 * dp[i]存储从0-i的最大连续子序列和
 * max存储最大子序列和。如果当前子序列的和大于max，就把Max替换掉
 *
 */
public class MaxValQueue {


    public static void main(String[] args) {
        int[] arr={-2,1,-3,4,-1,2,1,-5};
        System.out.println(getMax(arr));
    }

    public static int getMax(int[] arr){

        int[] dp=new int[arr.length];
        dp[0]=arr[0];
        int max=dp[0];

        for(int i=1;i<arr.length;i++){

            if(dp[i-1]>0){
                dp[i]=dp[i-1]+arr[i];
                if(max<dp[i]){
                    max=dp[i];
                }
            }else{
                max=arr[i];
                dp[i]=arr[i];
            }
        }

        System.out.println(Arrays.toString(dp));
        return max;

    }
}
