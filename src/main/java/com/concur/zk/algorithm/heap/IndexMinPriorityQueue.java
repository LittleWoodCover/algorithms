package com.concur.zk.algorithm.heap;


/**
 * 索引最小优先队列
 * @param <T>
 */
public class IndexMinPriorityQueue<T extends Comparable<T>> {

    private T[] values;
    private int[] pq;
    private int[] qp;
    private int length;

    public IndexMinPriorityQueue(int cap) {

        values= (T[]) new Comparable[cap+1];
        pq=new int[cap+1];
        qp=new int[cap+1];
        length=0;
        for(int i=0;i<qp.length;i++){
            qp[i]=-1;
        }
    }

    public boolean isEmpty(){
        return length==0;
    }

    public int size(){
        return length;
    }

    public boolean gt(int i,int j){

        //判断堆中索引i处的值是否大于索引j处的值
        return values[pq[i]].compareTo(values[pq[j]])>0;
    }

    private void exch(int i,int j){

        //更新pq中的数据。
        int temp=pq[i];
        pq[i]=pq[j];
        pq[j]=temp;
        //更新qp中的数据
        //此时由于pq[i]和pq[j]的值已经发生了变化所以这么写
        qp[pq[i]]=i;
        qp[pq[j]]=j;

    }

    public void insert(int t,T val){

        if(contains(t)){
            return;
        }
        //如果不村子就是新插入元素。所有的数组大小加一
        length++;
        //在数组t处插入元素val
        values[t]=val;
        //pq末尾插入索引值
        //qp索引位置，pq和qp是一对连体婴儿
        pq[length]=t;
        qp[t]=length;
        swim(length);
    }

    public boolean contains(int k){

        return qp[k]!=-1;
    }



    public int delMin(){
        if(length<=0){
            return -1;
        }
        //找到最小元素在原数组中的的索引位置
        int minIndex=pq[1];

        //删除pq中的元素，pq中的元素，source中的元素
        exch(1,length);
        //删除qp就让qo出的索引为-1
        qp[pq[length]]=-1;
        pq[length]=-1;
        //删除原数组中的内容就置为空
        values[minIndex]=null;
        length--;
        sink(1);
        return minIndex;
    }

    public void change(int i,T t){

        values[i]=t;
        int k=qp[i];

        //更改之后破坏了堆的结构。
        // 应为是在中间操作的需要先进行下沉然后在进行上浮操作。
        sink(k);
        swim(k);
    }

    public void swim(int k){
        while (k>1){
            if(gt(k/2,k)){
                exch(k/2,k);
            }
            k/=2;
        }
    }

    public void sink(int k){

        while(2*k<=length){
            int min;
            if(2*k+1<=length){
                if(gt(2*k,2*k+1)){
                    min=2*k+1;
                }else{
                    min=2*k;
                }
            }else{
                min=2*k;
            }
            if(gt(min,k)){
                return;
            }
            exch(k,min);
            k=min;
        }
    }
}
