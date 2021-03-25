package com.concur.zk.algorithm.leetcode.recursion;

import java.util.Scanner;

public class Test {


    public static void main(String[] args){

        Scanner input =new Scanner(System.in);

        while(input.hasNext()){
            String str=input.next();
            int[] dp=new int[str.length()];
            getUp(str,dp);
            int max=0;

            for(int i=1;i<dp.length;i++){
                if(dp[i]>max){
                    max=dp[i];
                }
            }
            System.out.println(max*2);

        }
    }

    public static void getUp(String str,int[] dp){

        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)==str.charAt(i+1)){
                dp[i]=1;
                dp[i+1]=1;
                int left=i;
                int right=i+1;
                while(--left>=0&&++right<str.length()){
                    if(str.charAt(left)==str.charAt(right)){
                        dp[i]+=1;
                        dp[i+1]+=1;
                    }else{
                        break;
                    }
                }
            }
        }

    }
}
