package com.concur.zk.algorithm.sort.recursion;

public class Recursion {

    public static void main(String[] args) {


        System.out.println(cal(5));
    }


    public static int cal(int i){

        if(i==1){
            return i;
        }
        return i*cal(i-1);
    }
}
