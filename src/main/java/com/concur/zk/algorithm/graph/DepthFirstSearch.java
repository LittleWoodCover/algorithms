package com.concur.zk.algorithm.graph;

public class DepthFirstSearch {

    private boolean[] marked;

    private int count;

    public DepthFirstSearch(Graph g, int s){

        marked=new boolean[g.V()];
        this.count=0;

        dfs(g,s);
    }

    public void dfs(Graph g, int s){


        marked[s]=true;

        for (Integer w : g.adj(s)) {
            if(!marked[w]){
                dfs(g,w);
            }
        }
        count++;
    }

    public boolean marked(int w){
        return marked[w];
    }

    public int count(){
        return count;
    }
}
