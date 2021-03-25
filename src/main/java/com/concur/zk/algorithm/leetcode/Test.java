package com.concur.zk.algorithm.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class Test {


    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        while(input.hasNext()){

            String s1=input.next();
            String s2=input.next();

            System.out.println(dp(s1,s2));
        }

    }

    public static int dp(String s1,String s2){

        int[][] dp=new int[s1.length()][s2.length()];
        int length=0;
        if(s1.charAt(0)!=s2.charAt(0)){
            dp[0][0]=1;
        }
        boolean f1=false;
        boolean f2=false;
        for(int i=1;i<s1.length();i++){
            dp[i][0]=dp[i-1][0]+1;
            if(s1.charAt(i)==s2.charAt(0)&&!f1){
                f1=true;
                dp[i][0]-=1;
            }
        }
        for(int i=1;i<s2.length();i++){
            dp[0][i]=dp[0][i-1]+1;
            if(s2.charAt(i)==s1.charAt(0)&&!f2){
                f2=true;
                dp[0][i]-=1;
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }

        for(int i=1;i<s1.length();i++){

            for(int j=1;j<s2.length();j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j]=min(min(dp[i-1][j-1],dp[i-1][j]+1),dp[i][j-1]+1);
                }else{
                    dp[i][j]=min(min(dp[i-1][j-1]+1,dp[i-1][j]+1),dp[i][j-1]+1);
                }
            }
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }

        if(s1.length()>s2.length()){
            return s1.length()-length;
        }else{
            return s2.length()-length;
        }
    }

    public static int min(int a,int b){
        return a>b?b:a;
    }

}
