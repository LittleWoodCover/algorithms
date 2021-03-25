package com.concur.zk.algorithm.leetcode.greedy.摇摆序列;

public class WaveSequence {

    public static void main(String[] args) {
        int[] arr={1,17,5,10,13,15,10,5,16,8};

        System.out.println(wiggleMaxLength(arr));
    }

    public static int wiggleMaxLength(int[] arr){

        final  int START=0;
        final int UP=1;
        final int DOWM=2;
        int state=START;
        int length=1;
        if(arr.length<=2){
            return arr.length;
        }
        for(int i=1;i<arr.length;i++){

            switch (state){
                case START: {
                    if(arr[i]-arr[i-1]<0){
                        state=DOWM;
                        length++;
                    }else if(arr[i]-arr[i-1]>0){
                        state=UP;
                        length++;
                    }

                }break;
                case UP:{
                    if(arr[i]-arr[i-1]<0){
                        state=DOWM;
                        length++;
                    }
                }break;
                case DOWM:{
                    if(arr[i]-arr[i-1]>0){
                        state=UP;
                        length++;
                    }
                }break;
            }
        }
        return length;
    }
}
