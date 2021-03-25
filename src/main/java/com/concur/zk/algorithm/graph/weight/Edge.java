package com.concur.zk.algorithm.graph.weight;

public class Edge implements Comparable<Edge> {

    private int v;
    private int w;

    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight(){
        return  weight;
    }

    public int either(){
        return v;
    }

    public int other(int val){

        if(this.v==val){
            return w;
        }else{
            return this.v;
        }
    }

    public int compareTo(Edge o) {

        if(this.weight()>o.weight()){
            return 1;
        }else if(this.weight()<o.weight()){
            return -1;
        }else{
            return 0;
        }

    }
}
