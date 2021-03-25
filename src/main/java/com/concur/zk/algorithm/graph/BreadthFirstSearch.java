package com.concur.zk.algorithm.graph;

import com.concur.zk.algorithm.linear.queue.Queue;

public class BreadthFirstSearch {

    private boolean[] marked;

    private int count;

    private Queue<Integer> waitQueue;

    public BreadthFirstSearch(Graph g, int s) {

        this.marked=new boolean[g.V()];
        this.count=0;
        waitQueue=new Queue<>();

        bfs(g,s);
    }

    public void bfs(Graph g, int s){

        waitQueue.enqueue(s);

        while(!waitQueue.isEmpty()){
            Integer val = waitQueue.dequeue();
            if(!marked[val]){
                marked[val]=true;
                count++;
                for (Integer value : g.adj(val)) {
                    if(!marked[value]){
                        waitQueue.enqueue(value);
                    }
                }
            }
        }
    }

    public boolean marked(int w){
        return marked[w];
    }

    public int count(){
        return count;
    }
}
