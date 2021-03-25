package com.concur.zk.algorithm.linear.queue;

public class Test {

    public static void main(String[] args) {

        Queue<Integer> queue=new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println( "dequeue:"+queue.dequeue());
        System.out.println(queue.getFirst().value);
        queue.forEach(p->{
            System.out.println("p = " + p);
        });
    }
}
