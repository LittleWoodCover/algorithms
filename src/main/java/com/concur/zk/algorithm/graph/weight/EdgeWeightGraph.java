package com.concur.zk.algorithm.graph.weight;

import com.concur.zk.algorithm.linear.queue.Queue;

public class EdgeWeightGraph {

    //顶点数量
    private int V;
    //边的数量
    private int E;

    private Queue<Edge>[] adj;

    public Queue<Edge> adj(int v){
        return adj[v];
    }

    public EdgeWeightGraph(int v) {
        V = v;
        this.E=0;

        this.adj=new Queue[v];
        for (int i = 0; i < this.adj.length; i++) {
            adj[i]=new Queue<Edge>();
        }

    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(Edge e){

        int v=e.either();
        int w=e.other(v);
        adj[v].enqueue(e);
        adj[w].enqueue(e);
        E++;
    }

    public void addEdge(int v,int w,double weight){

        Edge edge=new Edge(v,w,weight);
        addEdge(edge);
    }

    public Queue<Edge> edges(){

        Queue<Edge> allEdges=new Queue<>();

        for(int v=0;v<V;v++){
            for(Edge edge:adj[v]){
                //由于每一条边都连接俩个顶点所以便利的时候会出现俩次，
                // 因此入队的时候，当前节点小于另外一个节点才入队。
                int other = edge.other(v);
                if(v<other){
                    allEdges.enqueue(edge);
                }
            }

        }

        return allEdges;
    }
}
