package com.concur.zk.algorithm.graph;

public class DetectCircle {

    private boolean[] marked;

    private boolean hasCircle;

    private boolean[] onStack;


    public DetectCircle(DiGraph G){
        marked=new boolean[G.V()];
        hasCircle=false;
        onStack=new boolean[G.V()];
        //找到图中每一个顶点。让他作为入口搜索

        for(int v=0;v<G.V();v++){
            if(!marked[v]){
                dfs(G,v);
            }
        }
    }

    public void dfs(DiGraph G, int v){

        //让当前节点标记为true.表示已经搜索过
        marked[v]=true;

        onStack[v]=true;



    }

    public boolean hasCircle(){
        return hasCircle;
    }
}
