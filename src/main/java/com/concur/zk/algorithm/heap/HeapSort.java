package com.concur.zk.algorithm.heap;

import com.concur.zk.algorithm.SortUtils;

public class HeapSort<T extends Comparable<T>> {

    public static void main(String[] args) {

        String[] arr ={"S","O","R","T","E","X","A","M","P","L","E"};

        Comparable[] source=sort(arr);

        for (Object s : source) {
            System.out.println(s);
        }

    }


    public static void createHeap(Comparable[] source, Comparable[] heap) {

        //把元数据复制到Heap中
        System.arraycopy(source, 0, heap, 1, source.length);
        for(int i=heap.length/2;i>0;i--){
            sink(heap,i,heap.length-1);
        }

    }

    public static Comparable[] sort(Comparable[] arr) {

        Comparable[] source=new Comparable[arr.length+1];
        createHeap(arr,source);

        for (int i = 1; i < source.length; i++) {
            System.out.print(source[i]+"");
        }
        System.out.println();
        for(int i=source.length-1;i>1;i--){
            SortUtils.exchangeObj(source,1,i);
            sink(source,1,i-1);
        }
        return source;
    }

    public static  boolean gt(Comparable[] heap,int i, int j) {
        return heap[i].compareTo(heap[j])>0;
    }

    private static void sink(Comparable[] heap,int index,int range) {

        while(2*index<=range){
            int max;
            if(2*index+1<range){
                if(gt(heap,2*index,2*index+1)){
                    max=2*index;
                }else{
                    max=2*index+1;
                }
            }else{
                max=2*index;
            }
            if(gt(heap,index,max)){
                break;
            }
            SortUtils.exchangeObj(heap,index,max);
            //如果下沉从中间位置开始。就不会进行第二次。第二次就超过数组的长度了
            //所以这里写break是一样的效果
            index=max;
        }
    }

//    public boolean gt()
}
