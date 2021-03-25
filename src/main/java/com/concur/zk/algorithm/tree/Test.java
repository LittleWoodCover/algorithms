package com.concur.zk.algorithm.tree;

public class Test {


    public static void main(String[] args) {

        RBTree<String, String> rbTree = new RBTree<>();
        rbTree.put("1", "a");
        System.out.println();
        rbTree.put("2", "b");

        rbTree.put("3", "c");


    }
}
