package com.concur.zk.algorithm.graph;

import com.concur.zk.algorithm.linear.stack.Stack;

public class TopoLogical {

    private Stack<Integer> order;

    public TopoLogical(DiGraph graph){

        DetectCircle detectCircle=new DetectCircle(graph);

        if(!detectCircle.hasCircle()){
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(graph);
            order = depthFirstOrder.setReversePost();
        }
    }

    public boolean hasCircle(){
        return order==null;
    }

    public Stack<Integer> getOrder(){
        return order;
    }
}
