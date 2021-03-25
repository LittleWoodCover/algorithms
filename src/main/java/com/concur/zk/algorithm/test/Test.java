package com.concur.zk.algorithm.test;

import java.util.Scanner;

public class Test {

    public static void main(String[] args){

        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            String str=scan.nextLine();
            String[] arr=new String[str.length()];
            for(int i=0;i<arr.length;i++){
                arr[i]=str.charAt(i)+"";
            }

            sort(arr);

            for (String s : arr) {
                System.out.print(s);
            }
            System.out.println();
        }


    }


    public static void sort(String[] arr){



        for(int i=arr.length-1;i>0;i--){
            if(!isChar(arr[i])){
                continue;
            }
            int index=-1;
            for(int j=0;j<=i;j++){
                String s=arr[j];
                if(!isChar(s)){
                    continue;
                }else{
                    if(index==-1){
                        index=j;
                    }
                    if(cmp(arr[index],s)){
                        exch(arr,index,j);
                        index=j;
                    }else{
                        index=j;
                    }
                }
            }

        }
    }

    public static boolean cmp(String a,String b){

        return a.compareToIgnoreCase(b)>0;
    }

    public static boolean isChar(String a){
        char val=a.charAt(0);
        if((val>='a'&&val<='z')||(val>='A'&&val<='Z')){
            return true;
        }
        return false;
    }

    public static void exch(String[] arr, int j,int k){

        String temp=arr[j];
        arr[j]=arr[k];
        arr[k]=temp;
    }

}
