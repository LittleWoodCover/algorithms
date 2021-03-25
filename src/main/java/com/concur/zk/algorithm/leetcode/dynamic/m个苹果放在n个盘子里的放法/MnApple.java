package com.concur.zk.algorithm.leetcode.dynamic.m个苹果放在n个盘子里的放法;

import java.util.Arrays;
import java.util.Scanner;

public class MnApple {

    public static void main(String[] args){

        Scanner input =new Scanner(System.in);

        while(input.hasNext()){
            int m=input.nextInt();
            int n=input.nextInt();

            int[][] dp=new int[n+1][m+1];
            for(int i=1;i<=m;i++){
                dp[1][i]=1;
                dp[0][i]=1;
            }
            for(int i=1;i<=n;i++){
                dp[i][1]=1;
                dp[i][0]=1;
            }

            for(int i=2;i<=n;i++){
                for(int j=2;j<=m;j++){
                    dp[i][j]=dp[i-1][j]+((j-i<0)?0:dp[i][j-i]);
                }
            }

            for(int i=0;i<=n;i++){
                System.out.println(Arrays.toString(dp[i]));
            }
            System.out.println(dp[n][m]);
        }
    }
}
