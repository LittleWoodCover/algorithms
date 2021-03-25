package com.concur.zk.algorithm.linear.linkedlist;

public class Test {

    public static void main(String[] args) {

//        LinkList linkList=new LinkList();

//
//        linkList.add(1);
//        linkList.add(2);
//        linkList.remove(0);
//
//        linkList.forEach(p->{
//            System.out.println(p);
//        });

        TwoWayLinkList twoWayLinkList=new TwoWayLinkList();

        twoWayLinkList.add(1);

        twoWayLinkList.add(2);
        twoWayLinkList.add(3);
        twoWayLinkList.add(4);
        twoWayLinkList.add(5);


        twoWayLinkList.reverse();
        System.out.println(twoWayLinkList.getMid());
////        twoWayLinkList.insert(1,0);
//        twoWayLinkList.forEach(p->{
//            System.out.println(p);
//        });
//
//        twoWayLinkList.reverse();
//
//        twoWayLinkList.forEach(p->{
//            System.out.print(p);
//        });

        TwoWayLinkList linkList=new TwoWayLinkList();


    }
}
