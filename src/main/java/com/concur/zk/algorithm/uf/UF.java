package com.concur.zk.algorithm.uf;

public class UF {

    int[] values;

    int length;

    public UF(int length) {
        this.length = length;
        values=new int[length];
        for(int i=0;i<length;i++){
            values[i]=i;
        }
    }

    public int size(){
        return length;
    }

    public int find(int p){

        if(length==0){
            return -1;
        }
        return values[p];
    }

    public boolean connected(int p,int q){
        return find(p)==find(q);
    }

    public void union(int p,int q){

        if(connected(p,q)){
            return;
        }
        int pGroup=find(p);
        int qGroup=find(q);

        for(int i=0;i<length;i++){
            if(pGroup==values[i]){
                values[i]=qGroup;
                length--;
            }
        }
    }
}
