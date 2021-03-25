package com.concur.zk.algorithm.linear;

import com.concur.zk.algorithm.linear.seqlist.SequenceList;

import java.util.ArrayList;

public class Test {


    public static void main(String[] args) {

        SequenceList<Integer> seq=new SequenceList<>(3);

        seq.insert(1);
        seq.insert(2);
        seq.insert(3);
        seq.insert(4);

        System.out.println(seq.indexOf(2));

        seq.forEach(p->{
            System.out.println(p);
        });
        ArrayList arrayList=new ArrayList();
    }
}
