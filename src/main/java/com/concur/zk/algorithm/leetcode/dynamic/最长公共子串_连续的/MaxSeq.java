package com.concur.zk.algorithm.leetcode.dynamic.最长公共子串_连续的;

import java.util.Scanner;

public class MaxSeq {

//    最长公共子串是： dp[i][j] -- 表示以str1[i]和str2[j]为结尾的最长公共子串
//    当str1[i] == str2[j]时，dp[i][j] = dp[i-1][j-1] + 1; 否则，dp[i][j] = 0;
//    最优解为max(dp[i][j]),其中0<=i<len1, 0<=j<len2;
public static void main(String[] args){

    Scanner input =new Scanner(System.in);

    while(input.hasNext()){
        String s1=input.next();
        String s2=input.next();

        System.out.println(maxLen(s1,s2));


    }
}

    public static int maxLen(String s1,String s2){
        int max=0;
        int[][]dp=new int[s1.length()][s2.length()];

        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)==s2.charAt(0)){
                dp[i][0]=1;
                if(dp[i][0]>max){
                    max=dp[i][0];
                }
            }
        }
        for(int i=0;i<s2.length();i++){
            if(s2.charAt(i)==s1.charAt(0)){
                dp[0][i]=1;
                if(dp[0][i]>max){
                    max=dp[0][i];
                }
            }
        }

        for(int i=1;i<s1.length();i++){
            for(int j=1;j<s2.length();j++){

                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    if(dp[i][j]>max){
                        max=dp[i][j];
                    }
                }
            }
        }

        return max;

    }
}
