package com.concur.zk.algorithm.graph;


import com.concur.zk.algorithm.linear.stack.Stack;

/**
 * 路径查找
 */
public class DepthFirstPath {

    private boolean[] marked;

    private int start;

    //起点和所有顶点相连的请况
    private int[] edgeTo;


    public DepthFirstPath(Graph graph, int start) {

        marked=new boolean[graph.V()];
        this.start=start;
        edgeTo=new int[graph.V()];
    }


    public void dfs(Graph graph, int v){

        marked[v]=true;
        for (Integer w : graph.adj(v)) {
            if(!marked[w]){
                //到达这个顶点的上一个节点是v
                edgeTo[w]=v;
                dfs(graph,w);
            }
        }
    }

    public boolean hasPathTo(int v){

        return  marked[v];
    }

    public Stack<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }

        Stack<Integer> path=new Stack<>();

        //从顶点v开始一直往前找。找到顶点
        for(int x=v;x!=start;x=edgeTo[x]){

            path.push(x);
        }

        path.push(start);

        return path;
    }
}
