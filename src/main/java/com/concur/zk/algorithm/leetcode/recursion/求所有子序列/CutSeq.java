package com.concur.zk.algorithm.leetcode.recursion.求所有子序列;

import javax.swing.text.html.parser.Entity;
import java.util.PriorityQueue;
import java.util.Vector;

public class CutSeq {


    public static void main(String[] args) {

        Vector<String> put = put(3);
        for (String s : put) {
            System.out.println(s);
        }
        PriorityQueue<Entity> queue=new PriorityQueue(3);

    }

    public static Vector<String> put(int i) {

        Vector<String> result = new Vector<>();

        put("",i,i,result);
        return result;
    }

    public static void put(String item,int left,int right,Vector result){

        if(left==right&left==0){

            result.add(item);
            return;
        }

        if(left>0){
            put(item+"(",left-1,right,result);
        }
        if(left<right){
            put(item+")",left,right-1,result);
        }
    }

}
