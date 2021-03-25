package com.concur.zk.algorithm.leetcode.dynamic.倒三角最短路径;


import java.util.Arrays;

public class Triangle {

    public static void main(String[] args) {

        int[][] arr={{2},{3,4},{6,5,7},{4,1,8,3}};
        System.out.println(getMinTrace(arr));
    }


    public static int getMinTrace(int[][] arr){

        int dp[][] =new int[arr.length][];
        for(int i=0;i<arr.length;i++){
            dp[i]=new int[arr[i].length];
        }

        dp[dp.length-1]=arr[arr.length-1];

        for(int i=arr.length-2;i>=0;i--){

            for(int j=0;j<arr[i].length;j++){
                if(dp[i+1][j]>dp[i+1][j+1]){
                    dp[i][j]=arr[i][j]+dp[i+1][j+1];
                }else{
                    dp[i][j]=arr[i][j]+dp[i+1][j];
                }

            }
            System.out.println(Arrays.toString(dp[i+1]));
        }

        return dp[0][0];
    }
}
