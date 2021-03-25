package com.concur.zk.algorithm.linear.stack;

public class Test {

    public static void main(String[] args) {

        String str="ss";

        System.out.println(str.charAt(0)=='s');

        Stack<String> stack=new Stack<>();

        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        stack.push("f");

        stack.forEach(p->{
            System.out.print(p+",");
        });
        stack.pop();
        stack.pop();
        System.out.println("出栈后：");
        stack.forEach(p->{
            System.out.print(p+",");
        });

    }
}
