package com.concur.zk.algorithm.leetcode.greedy.移除K个数字;


import java.util.Vector;

public class RMKdigit {

    public static void main(String[] args) {
        String arr = "2000122191";
        Vector<String> vector = new Vector(arr.length());
        for (int i = 0; i < arr.length(); i++) {
            vector.add(arr.charAt(i) + "");
        }
        System.out.println(removeKdi(vector, 3));

    }

    public static Vector<String> removeKdi(Vector<String> arr, int n) {


        for (int i = 1; i <= n; i++) {
            if(i==1&&arr.get(i).equals("0")){
                continue;
            }
            if (arr.get(i).compareTo(arr.get(i - 1)) > 0) {
                arr.remove(i);
            } else {
                arr.remove(i - 1);
            }
        }
        return arr;
    }
}
