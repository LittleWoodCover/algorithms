package com.concur.zk.algorithm.tree;


import java.util.Arrays;
import java.util.Queue;

/**
 * 根据前序遍历和中序遍历恢复二叉树，
 */
public class RecoverTree {

    public static void main(String[] args) {

        String[] preOrder = {"A", "B", "D", "E", "G", "C", "F", "H"};
        String[] inOrder = {"D", "B", "G", "E", "A", "C", "H", "F"};

        System.out.println(Arrays.toString(Arrays.copyOfRange(preOrder,0,2)));
        Node root= reConstructBinaryTree(preOrder,inOrder);
        Queue queue;
        System.out.println("1");
    }

    /**
     * pre：线序遍历得到的数组
     * in：中序遍历得到的数组
     */
    public static Node reConstructBinaryTree(String[] pre, String[] in) {
        if(pre.length == 0) {
            return null;
        }


        Node node = new Node(pre[0],null,null);

        //寻找根节点在in中的索引
        int i = 0;
        for( ; i<in.length; ++i) {
            if(in[i] == pre[0]) {
                break;
            }
        }

        //建立左子树
        String[] leftIn = Arrays.copyOfRange(in, 0, i);
        String[] leftPre = Arrays.copyOfRange(pre, 1, i+1);
        node.left = reConstructBinaryTree(leftPre, leftIn);

        //建立右子树
        String[] rightIn = Arrays.copyOfRange(in, i+1, in.length);
        String[] rightPre = Arrays.copyOfRange(pre, i+1, pre.length);
        node.right = reConstructBinaryTree(rightPre, rightIn);

        return node;
    }

    public static class Node {

        String value;
        Node left;
        Node right;

        public Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

}


