package com.concur.zk.algorithm.graph;

public class Test {


    public static void main(String[] args) {

        Graph graph=new Graph(13);
        graph.addEdge(0,5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,6);
        graph.addEdge(5,3);
        graph.addEdge(5,4);
        graph.addEdge(3,4);
        graph.addEdge(4,6);

        graph.addEdge(7,8);
        graph.addEdge(9,11);
        graph.addEdge(9,12);
        graph.addEdge(11,12);

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 0);

        BreadthFirstSearch breadthFirstSearch=new BreadthFirstSearch(graph,0);
        System.out.println("与起点相通的顶点数量为："+depthFirstSearch.count());
        System.out.println("5相通："+depthFirstSearch.marked(5));
        System.out.println("7相通："+depthFirstSearch.marked(7));

        System.out.println("////");

        System.out.println("与起点相通的顶点数量为："+breadthFirstSearch.count());
        System.out.println("5相通："+breadthFirstSearch.marked(5));
        System.out.println("7相通："+breadthFirstSearch.marked(7));


        DiGraph diGraph=new DiGraph(6);
        diGraph.addEgde(0,2);
        diGraph.addEgde(0,3);
        diGraph.addEgde(2,3);
        diGraph.addEgde(4,5);
        diGraph.addEgde(3,4);
        diGraph.addEgde(1,3);

        TopoLogical topoLogical=new TopoLogical(diGraph);

        topoLogical.getOrder().forEach(p->{
            System.out.print(p+" ");
        });
    }


}
