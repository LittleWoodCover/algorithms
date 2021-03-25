package com.concur.zk.algorithm.leetcode.dynamic.二位数组最短路径;


import java.util.Arrays;

/**
 *  1   3   1
 *  1   5   1
 *  4   2   1
 *
 *  思想通倒三角最短路径
 *
 *  ?   i-1,j  ?
 * i,j-1 i,j   ?
 *  ?    ?     ?
 */
public class MinArrPath {

    public static void main(String[] args) {

        int[][] arr={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPath(arr));
    }


    public static int minPath(int[][] arr){
        int[][] dp=new int[arr.length][arr[0].length];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                dp[i][j]=-1;
            }
        }

        dp[0][0]=arr[0][0];
        for(int i=1;i<arr.length;i++){
            for(int j=1;j<arr[i].length;j++){
                //top
               if(dp[i-1][j]==-1){
                   dp[i-1][j]=dp[i-1][j-1]+arr[i-1][j];

               }
               if(dp[i][j-1]==-1){
                   dp[i][j-1]=dp[i-1][j-1]+arr[i][j-1];

               }

               dp[i][j]=arr[i][j]+(dp[i][j-1]>dp[i-1][j]?dp[i-1][j]:dp[i][j-1]);
            }
        }

        System.out.println(Arrays.toString(dp[0]));
        System.out.println(Arrays.toString(dp[1]));
        System.out.println(Arrays.toString(dp[2]));
        return dp[2][2];
    }


}
