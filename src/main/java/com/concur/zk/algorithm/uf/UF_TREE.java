package com.concur.zk.algorithm.uf;

public class UF_TREE {
    int[] values;

    int length;

    public UF_TREE(int length) {
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

        while(true){
            if(p==values[p]){
                return p;
            }
            p=values[p];
        }
    }

    public boolean connected(int p,int q){
        return find(p)==find(q);
    }

    public void union(int p,int q){

        int pGroup = find(p);
        int qGroup=find(q);
        if(pGroup==qGroup){
            return;
        }
        //合并只需要让p的父节点未qGroup就行。
        values[p]=qGroup;
        length--;
    }

}
