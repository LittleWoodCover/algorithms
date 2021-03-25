package com.concur.zk.algorithm.heap;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

//        Heap<Integer> heap=new Heap<>(10);
//
//        heap.insert(1);
//        heap.insert(2);
//        heap.insert(3);
//        heap.insert(4);
//        heap.insert(5);
//        heap.insert(6);
//        heap.insert(7);
//        heap.insert(8);
//        Integer result=null;
//        while((result=heap.delMax())!=null){
//
//            System.out.println(result);
//        }

//        IndexMinPriorityQueue<String> queue=new IndexMinPriorityQueue<>(3);
//
//        queue.insert(0,"A");
//        queue.insert(1,"C");
//        queue.insert(2,"F");
//
//        queue.change(2,"B");
//        int result;
//        while((result=queue.delMin())!=-1){
//            System.out.print(result+" ");
//        }

//        Heap heap=new Heap(10);

        HeapMin heapMin=new HeapMin(10);
        for(int i=10;i>0;i--){
            heapMin.add(i);
        }

        System.out.println(Arrays.toString(heapMin.values));


        for(int i=0;i<4;i++){
            System.out.println(heapMin.delMin());
        }
    }
}
