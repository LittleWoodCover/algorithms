package com.concur.zk.algorithm.uf;

public class Traffic_Project {

    public static void main(String[] args) {

        UF_TREE_WEIGHT tree=new UF_TREE_WEIGHT(20);

        tree.union(0,1);
        tree.union(6,9);
        tree.union(3,8);
        tree.union(5,11);
        tree.union(2,12);
        tree.union(6,10);
        tree.union(4,8);

        System.out.println(tree.length-1);
    }
}
