package com.concur.zk.algorithm.linear.symbleTable;

public class Test {

    public static void main(String[] args) {

        SymbleTable<String,String> table=new SymbleTable<>();

        table.put("a","a");
        table.put("b","b");
        table.put("c","c");

        System.out.println(table.get("c"));
        table.remove("c");
        table.forEach(p->{
            System.out.println("p = " + p);
        });

    }
}
