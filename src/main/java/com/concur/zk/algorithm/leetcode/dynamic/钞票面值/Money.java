package com.concur.zk.algorithm.leetcode.dynamic.钞票面值;

public class Money {

    public static void main(String[] args) {

        int sum=14;
        int[] money={1,2,5,7,10};
        int[] arr=new int[sum+1];
        for(int i=0;i<money.length;i++){
            arr[money[i]]=1;
        }
        int i = calSum(money, arr);
        System.out.println(i);
    }

    public static int calSum(int[] money,int[] arr){


        for(int i=3;i<arr.length;i++){
            if(arr[i]!=0){
                continue;
            }
            for(int j=0;j<money.length;j++){
                if(i<money[j]){
                    break;
                }
                int val=arr[i-money[j]]+1;
                if(arr[i]!=0){
                    arr[i]=val<arr[i]?val:arr[i];
                }else{
                    arr[i]=val;
                }
            }
        }

        return arr[arr.length-1];

    }
}
