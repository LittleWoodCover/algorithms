package com.concur.zk.algorithm.graph.weight;

import com.concur.zk.algorithm.heap.IndexMinPriorityQueue;
import com.concur.zk.algorithm.linear.queue.Queue;

public class PrimMST {

    //索引代表顶点，值表示当前顶点和最小生成树的最短边
    private Edge[] edgeTo;
    //索引代表顶点，值表示当前顶点和最小生成树的最短权重
    private double[] distTo;
    //索引代表当前顶点值为true表示当前顶点已经在最小生成树中
    private boolean[] marked;
    //存放当前顶点与非树顶点之间的有效横切边
    IndexMinPriorityQueue<Double> queue;


    public PrimMST(EdgeWeightGraph graph){

        this.edgeTo=new Edge[graph.V()];
        this.distTo=new double[graph.V()];

        for (int i = 0; i < this.distTo.length; i++) {
            distTo[i]=Double.POSITIVE_INFINITY;
        }
        this.marked=new boolean[graph.V()];

        queue=new IndexMinPriorityQueue<>(graph.V());
        //默认让0节点进入到树中，但是树中只有一个顶点0，因此0节点没有和其他节点相连，所以让0节点的distTo=0.0
        distTo[0]=0.0;
        queue.insert(0,0.0);
        //遍历索引优先队列，
        while(!queue.isEmpty()){
            visit(graph,queue.delMin());
        }
    }


    private void visit(EdgeWeightGraph graph,int v){

        marked[v]=true;

        for (Edge e : graph.adj(v)) {
            //获取e边的另外一个顶点（当前是v）
            int w=e.other(v);
            //如果在树中就不做处理，如果不在树中，就去更新数据（判断这条边的权重和w）
            if(marked[w]){
                continue;
            }

            if(e.weight()<distTo[w]){
                edgeTo[w]=e;
                distTo[w]=e.weight();
                if(queue.contains(w)){
                    queue.change(w,e.weight());
                }else{
                    queue.insert(w,e.weight());
                }
            }
        }
    }

    public Queue<Edge> edges(){
        Queue<Edge> allEdges=new Queue<>();

        for (Edge edge : edgeTo) {
            if(edge!=null){
                allEdges.enqueue(edge);
            }
        }
        return allEdges;
    }
}
