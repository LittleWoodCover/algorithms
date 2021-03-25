package com.concur.zk.algorithm.linear.stack;

import java.util.Scanner;

public class BracketsMatch {


    public static void main(String[] args) {

        Stack<String> stack =new Stack<>();

        Scanner scanner=new Scanner(System.in);

        String next = scanner.next();

        while(!next.equals("0")){

            System.out.println("是否匹配："+isMatch(stack,next));
            next=scanner.next();
        }
        scanner.close();
    }

    public static boolean isMatch(Stack stack, String next){


        stack.clear();
        for(int i=0;i<next.length();i++){

            String ch=next.charAt(i)+"";
            if(ch.equals("(")){
                stack.push(ch);
            }else if(ch.equals(")")){
                if(stack.pop()==null){
                    System.out.println("少一个左括号");
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            System.out.println("少一个右括号！");
            return false;
        }else{
            return true;
        }

    }
}
