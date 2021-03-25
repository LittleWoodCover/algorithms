package com.concur.zk.algorithm.uf;



public class UF_TREE_WEIGHT {

    int[] values;

    int[] sz;

    int length;

    public UF_TREE_WEIGHT(int length) {
        this.length = length;
        values=new int[length];
        sz=new int[length];
        for(int i=0;i<length;i++){
            values[i]=i;
            sz[i]=1;
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

        if(sz[pGroup]<sz[qGroup]){

            //合并只需要让p的父节点未qGroup就行。
            values[pGroup]=qGroup;
            sz[qGroup]+=sz[pGroup];
        }else{
            //合并只需要让p的父节点未qGroup就行。
            values[qGroup]=pGroup;
            sz[pGroup]+=sz[qGroup];
        }
        length--;
    }
}
