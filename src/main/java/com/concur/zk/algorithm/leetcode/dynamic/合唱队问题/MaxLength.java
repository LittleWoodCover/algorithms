package com.concur.zk.algorithm.leetcode.dynamic.合唱队问题;

import java.util.Scanner;

public class MaxLength {

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);

        while(scan.hasNext()){
            int length=scan.nextInt();
            int[] arr=new int[length];
            for(int i=0;i<arr.length;i++){
                arr[i]=scan.nextInt();
            }

            int[] dp=new int[arr.length];
            int[] dp1=new int[arr.length];
            maxInc(arr,dp);
            maxDec(arr,dp1);
            int max=0;
            for(int i=0;i<dp.length;i++){
                max=dp[i]+dp1[i]>max?dp[i]+dp1[i]:max;
            }
            max-=1;
            System.out.println(length-max);
        }


    }

    public static void maxInc(int[] arr,int[] dp){
        dp[0]=1;
        for(int i=1;i<arr.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]&&dp[i]<=dp[j]){
                    dp[i]=dp[j]+1;
                }
            }
        }
    }

    public static void maxDec(int[] arr,int[] dp){
        dp[0]=1;
        for(int i=1;i<arr.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(arr[i]<arr[j]&&dp[i]<=dp[j]){
                    dp[i]=dp[j]+1;
                }
            }
        }

    }


}
