package com.concur.zk.algorithm.leetcode.dynamic.最长上升子序列;

public class MaxIncrease {

    public static void main(String[] args) {

        int[] arr={1,3,2,3,2,4,1};
        System.out.println(cal(arr));

    }

    public static int cal(int[] arr){

        int[] dp=new int[arr.length];

        dp[0]=1;
        int max=1;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]&&dp[i]<=dp[j]){
                    dp[i]=dp[j]+1;
                    if(dp[i]>max){
                        max=dp[i];
                    }
                }
            }

        }
        return max;
    }



}
