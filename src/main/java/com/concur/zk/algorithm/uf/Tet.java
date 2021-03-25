package com.concur.zk.algorithm.uf;

import java.util.Arrays;
import java.util.Scanner;

public class Tet {


    public static void main(String[] args) {


        UF_TREE_WEIGHT uf=new UF_TREE_WEIGHT(5);
        System.out.println("默认请况下"+uf.size()+"个分组。");
        System.out.println();
        Scanner input=new Scanner(System.in);

        while(true){
            System.out.println("请输入第一个元素");
            int v1=input.nextInt();

            System.out.println("请输入第二个元素");
            int v2=input.nextInt();
            if(uf.connected(v1,v2)){
                System.out.println(v1+" ,"+v2+" 已经在同一个组了");
                continue;
            }else{
                uf.union(v1,v2);
                System.out.println("当前还有"+uf.size());

            }
            System.out.println(Arrays.toString(uf.values));
        }
    }
}
