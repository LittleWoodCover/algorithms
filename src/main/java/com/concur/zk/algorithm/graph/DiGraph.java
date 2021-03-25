package com.concur.zk.algorithm.graph;

import com.concur.zk.algorithm.linear.queue.Queue;

public class DiGraph {

    private int V;

    private int E;

    private Queue<Integer>[] adj;

    public DiGraph(int v) {
        this.V=v;
        this.E=0;
        this.adj=new Queue[v];

        for(int i=0;i<v;i++){
            adj[i]=new Queue<>();
        }
    }

    public int V(){
        return V;
    }
    public int E(){
        return E;
    }

    //向v的邻接表添加w
   public void addEgde(int v,int w){

        adj[v].enqueue(w);
        E++;
    }

    public Queue<Integer> adj(int v){
        return adj[v];
    }

    /**
     * 反向图。
     * @return
     */
    public DiGraph reverse(){

        DiGraph reverse=new DiGraph(V);

        for(int v=0;v<V;v++){

            for (Integer w : adj[v]) {
                reverse.addEgde(w,v);
            }
        }
        return reverse;
    }
}
