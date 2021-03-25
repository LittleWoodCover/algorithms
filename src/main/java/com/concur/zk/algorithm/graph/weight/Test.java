package com.concur.zk.algorithm.graph.weight;

import com.concur.zk.algorithm.linear.queue.Queue;

public class Test {

    public static void main(String[] args) {

        //准备一个加权无向图
        EdgeWeightGraph graph=new EdgeWeightGraph(8);


        graph.addEdge(4,5,0.35);
        graph.addEdge(4,7,0.37);
        graph.addEdge(5,7,0.28);
        graph.addEdge(0,7,0.16);
        graph.addEdge(1,5,0.32);
        graph.addEdge(0,4,0.38);
        graph.addEdge(2,3,0.17);
        graph.addEdge(1,7,0.19);
        graph.addEdge(0,2,0.26);
        graph.addEdge(1,2,0.36);
        graph.addEdge(1,3,0.29);
        graph.addEdge(2,7,0.34);
        graph.addEdge(6,2,0.40);
        graph.addEdge(4,6,0.52);
        graph.addEdge(6,0,0.58);
        graph.addEdge(6,4,0.93);


        //创建一个PrimMST对象，计算加权无向图中的最小生成树

        PrimMST primMST=new PrimMST(graph);
        //获取所有的边
        Queue<Edge> edges = primMST.edges();
        //打印所有的边
        for (Edge edge : edges) {

            int v= edge.either();
            int w= edge.other(v);
            double weight = edge.weight();
            System.out.println(v+"-"+w+":"+weight);
        }
    }
}
