package com.concur.zk.algorithm.linear.linkedlist;

public class Joseph {

    public static void main(String[] args) {


        LinkList<Integer> list = new LinkList<Integer>();

        for (int i = 1; i <= 41; i++) {

            LinkList.Node<Integer> node = new LinkList.Node<Integer>(i, null);
            list.add(node);
            if (list.length() == 41) {
                node.setNext(list.getFirst());
            }
        }

        int count = 0;
        LinkList.Node n= list.getFirst();
        LinkList.Node before = list.getHead();

        while (n!=n.next) {
            LinkList.Node current=before.getNext();
            count++;
            if (count>=3) {
                before.next=n.next;
                count=0;
                n=n.next;
                System.out.print(n.value()+",");
            }else{
                before=n;
                n=n.getNext();
            }
        }
        System.out.println(111);
    }
}
