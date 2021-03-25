package com.concur.zk.algorithm.tree;

import com.concur.zk.algorithm.linear.queue.Queue;

import java.util.Arrays;

public class FoldingPage {


    public Node root;

    public static void main(String[] args) {

        FoldingPage folding = new FoldingPage();
        System.out.println(Arrays.toString(getValues(5)));

        folding.folding(5);

        printTree(folding.root);

        System.out.println();
        Node node=createTree(5);
        printTree(node);
    }

    public void folding(int count) {

        int[] values = getValues(count);
        if(values.length>=1){
            root=new Node("down",null,null);

            Node right=root;
            for(int i=values.length/2+1;i<values.length;i++){
                if(i==values.length/2+1){
                    root.right=new Node(values[i]>0?"up":"down",null,null);
                    right=root.right;
                    continue;
                }
                Node node;
                if(values[i]>0){
                    node=new Node("up",null,null);
                    right.right=node;
                }else{
                    node=new Node("down",null,null);
                    right.left=node;
                }
                right=node;
            }
            Node left=root;
            for(int i=values.length/2;i>0;i--){

                if(i==values.length/2+1){
                    root.left=new Node(values[i]>0?"up":"down",null,null);
                    continue;
                }
                Node node;
                if(values[i]>0){
                    node=new Node("up",null,null);
                    left.right=node;
                }else{
                    node=new Node("down",null,null);
                    left.left=node;
                }
                left=node;
            }
        }

    }


    public static Node<String> createTree(int count){

        Node<String> root=null;

        for(int i=0;i<count;i++){

            if(i==0){
                root=new Node<>("down",null,null);
                continue;
            }
            Queue<Node> queue=new Queue<>();
            queue.enqueue(root);
            while(!queue.isEmpty()){
                Node temp=queue.dequeue();
                if(temp.left!=null){
                    queue.enqueue(temp.left);
                }
                if(temp.right!=null){
                    queue.enqueue(temp.right);
                }
                if(temp.left==null&&temp.right==null){
                    temp.left=new Node("down",null,null);
                    temp.right=new Node("up",null,null);
                }
            }
        }
        return root;
    }

    public static int[] getValues(int count){
        /**
         * 0代表凹陷，1代表突出，得到列表
         * 折纸次数     结果
         * 0            []
         * 1            0
         * 2            001
         * 3            0010011
         * 4            001001100011011
         */

        int[] values={0};
        if(count==0){
            return null;
        }else if(count==1){
            return values;
        }
        for(int i=2;i<=count;i++){
                int[] seq=values;
                int length=seq.length;
                values=new int[length*2+1];
                values[seq.length]=0;
                for(int j=0;j<seq.length;j++){
                    values[j]=seq[j];
                    values[j+length+1]=1-seq[length-j-1];
                }
        }
        return values;
    }

    public static class Node<T> {

        public T value;
        public Node left;
        public Node right;

        public Node(T value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void printTree(Node node){

        if(node==null){
            return;
        }
        if(node.left!=null){
            printTree(node.left);
        }
        System.out.print(node.value+" ");
        if(node.right!=null){
            printTree(node.right);
        }
    }
}
