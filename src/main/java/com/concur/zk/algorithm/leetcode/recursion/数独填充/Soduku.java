package com.concur.zk.algorithm.leetcode.recursion.数独填充;

import java.util.Scanner;

public class Soduku {


    public static void main(String[] args){

        int[][] arr=new int[9][9];

        String str="123";

        Scanner input =new Scanner(System.in);
//        while(input.hasNext()){

            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr.length;j++){

                    arr[i][j]=input.nextInt();
                }
            }
//        }

        place(0,0,arr);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(j==8){
                    System.out.print(arr[i][j]);
                }else{
                    System.out.print(arr[i][j]+" ");
                }

            }
            System.out.println();
        }

    }

    public static boolean place(int row,int col,int[][] arr){
        if(row>=arr.length||col>arr.length){
            return true;
        }

        if(arr[row][col]==0){
            for(int k=1;k<=9;k++){
                if(isValid(arr,row,col,k)){
                    arr[row][col]=k;
                    if(place(col==8?row+1:row,col==8?0:col+1,arr)){
                        return true;
                    }
                }
            }
            arr[row][col]=0;
            return false;
        }else{
            return place(col==8?row+1:row,col==8?0:col+1,arr);
        }

    }

    public static boolean isValid(int[][] arr,int row,int col,int val){

        int[] rows=arr[row];
        for(int i=0;i<rows.length;i++){
            if(val==rows[i]){
                return false;
            }
            if(arr[i][col]==val){
                return false;
            }
        }

        int r=row/3*3;
        int c=col/3*3;
        for(int i=r;i<=r+2;i++ ){
            for(int j=c;j<=c+2;j++){
                if(arr[i][j]==val){
                    return false;
                }
            }
        }


        return true;

    }

}
