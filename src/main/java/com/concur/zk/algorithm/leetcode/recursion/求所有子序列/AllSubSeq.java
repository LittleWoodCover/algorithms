package com.concur.zk.algorithm.leetcode.recursion.求所有子序列;

import java.util.Vector;

public class AllSubSeq {

    public static void main(String[] args) {

        int[] arr={1,2,3};
        Vector<Vector<Integer>> vectors = subSeq(arr);
        vectors.forEach(p->{

            System.out.println(p);
        });

    }


    public static Vector<Vector<Integer>> subSeq(int[] arr){

        Vector<Vector<Integer>> result=new Vector<>();

        Vector<Integer> item=new Vector();

        subSeq(0,result,item,arr);

        return result;
    }


    public static void subSeq(int i,Vector<Vector<Integer>> result,Vector it,int[] arr){

        if(i>=arr.length){
            return;
        }
        Vector item=new Vector<>(it);
        item.add(arr[i]);
        result.add(new Vector<>(item));
        subSeq(i+1,result,new Vector(item),arr);
        item.remove(item.size()-1);
        subSeq(i+1,result,new Vector(item),arr);
    }
}
