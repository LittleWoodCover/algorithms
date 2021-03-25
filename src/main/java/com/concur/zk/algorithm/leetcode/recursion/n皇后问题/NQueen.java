package com.concur.zk.algorithm.leetcode.recursion.n皇后问题;

public class NQueen {


    public static int[] cols;
    public static int ways=0;
    public static void main(String[] args) {

        int row=8;
        cols=new int[row];
        place(0);
        System.out.println(ways);
    }

    public static void place(int row){

        if(row==cols.length){
            ways++;
            return ;
        }

        //循环往row行上某一个横向位置放，
        for(int i=0;i<cols.length;i++){
            //判断往第row行，第i个位置能放下不
            if(isValid(row,i)){//利用剪枝操作把一些不必要的操作去除掉
                cols[row]=i;
                //递归往下一行放，纵向往下
                place(row+1);
            }
        }
    }

    public static boolean isValid(int row,int col){

        for(int i=0;i<row;i++){
            if(cols[i]==col) return false;
            if(row-i==Math.abs(col-cols[i])) return false;
        }
        return true;
    }



}
