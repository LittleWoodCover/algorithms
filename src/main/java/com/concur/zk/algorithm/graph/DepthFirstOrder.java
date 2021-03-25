package com.concur.zk.algorithm.graph;

import com.concur.zk.algorithm.linear.stack.Stack;

public class DepthFirstOrder {

    private boolean[] marked;

    private Stack<Integer> reversePost;


    public DepthFirstOrder(DiGraph diGraph) {

        marked=new boolean[diGraph.V()];
        reversePost=new Stack<>();

        for(int v=0;v<diGraph.V();v++){
           if(!marked[v]){
               dfs(diGraph,v);
           }
        }
    }

    public void dfs(DiGraph diGraph, int v){
        marked[v]=true;

        for(Integer w:diGraph.adj(v)){
            if(!marked[w]){

                dfs(diGraph,w);
            }
        }

        reversePost.push(v);
    }

    public Stack<Integer> setReversePost(){
        return reversePost;
    }
}
