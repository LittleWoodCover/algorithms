package com.concur.zk.algorithm.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {


    public static void main(String[] args) {

        Test2 test2=new Test2();
        int[] a={1,2,4,5,6,3};
        int[] b={5,4,6,2,1,3};
        System.out.println(Arrays.toString(test2.solve(a,b)));
    }
    public int[] solve (int[] xianxu, int[] zhongxu) {
        // write code here
        Node root=construct(xianxu,zhongxu);


        return getRight(root);
    }

    public int[] getRight(Node root){
        List<Integer> list=new ArrayList();
        ArrayDeque<Node> queue=new ArrayDeque();

        queue.add(root);
        list.add(root.value);

        while(!queue.isEmpty()){
            Node node=queue.poll();
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
                list.add(node.right.value);
            }
        }

        int[] result=new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result;
    }

    public Node construct(int[] pre,int[] in){

        if(pre==null||pre.length==0){
            return null;
        }

        Node root=new Node(pre[0]);
        int index=indexOf(in,pre[0]);

        root.left=construct(Arrays.copyOfRange(pre,1,index+1),
                Arrays.copyOfRange(in,0,index));
        root.right=construct(Arrays.copyOfRange(pre,1+index,pre.length),
                Arrays.copyOfRange(in,index+1,in.length));
        return root;

    }

    public int indexOf(int[] pre,int val){

        for(int i=0;i<pre.length;i++){
            if(val==pre[i]){
                return i;
            }
        }
        return -1;
    }

    public class Node{

        public int value;
        public Node left;
        public Node right;

        Node(int val){
            this.value=val;
        }
    }
}
