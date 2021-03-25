package com.concur.zk.algorithm.leetcode.recursion.求所有子序列;


import java.util.Vector;

/**
 * 采用位运算的方式来求取子序列
 *
 */
public class BinarySeq {


    public static void main(String[] args) {

        String[] arr={"A","B","C"};

        Vector<Vector<String>> vectors = subQueue(arr);
        vectors.forEach(p->{
            System.out.println(p);
        });


    }

    public static Vector<Vector<String>> subQueue(String[] arr){

        Vector<Vector<String>> result =new Vector<>();
        int[] brr=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            brr[i]=1<<(arr.length-i-1);
        }

        int length=1<<arr.length;
        for(int i=0;i<length;i++){
            Vector<String> item=new Vector<>();
            for(int j=0;j<arr.length;j++){
                if((brr[j]&i)==brr[j]){
                    item.add(arr[j]);
                }
            }
            result.add(item);
        }
        return result;
    }
}
