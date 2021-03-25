package com.concur.zk.algorithm.graph;

import com.concur.zk.algorithm.linear.queue.Queue;

public class Graph {

    public int V;

    private int E;

    public Queue<Integer>[] adj;


    public Graph(int v){
        this.V=v;
        this.E=0;

        this.adj=new Queue[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i]=new Queue<Integer>();

        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    /**
     * 由于无向图没有方向。所以添加一个边，在俩个节点对应的queue里都需要加入元素
     * @param v
     * @param w
     */
    public void addEdge(int v,int w){
        adj[v].enqueue(w);
        adj[w].enqueue(v);
        E++;
    }

    public Queue<Integer> adj(int v){
        return adj[v];
    }
}
