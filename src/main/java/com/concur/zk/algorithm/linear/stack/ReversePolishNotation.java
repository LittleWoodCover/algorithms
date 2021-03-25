package com.concur.zk.algorithm.linear.stack;


/**
 * 逆波兰表达式计算
 *
 *
 */
public class ReversePolishNotation {

    public static void main(String[] args) {

        String[] notation={"3","17","15","-","*","18","6","/","+"};
        System.out.println(calculate(notation));

    }

    public static int calculate(String[] notation){



        Stack<String> stack=new Stack<>();

        for(int i=0;i<notation.length;i++){

            if(isCal(notation[i])){
                String v2=stack.pop();
                String v1=stack.pop();
                stack.push(cal(v1,v2,notation[i])+"");
            }else{
                stack.push(notation[i]);
            }
        }
       return Integer.valueOf(stack.pop());

    }

    public static boolean isCal(String sign){
        if(sign.equals("+")||sign.equals("-")||sign.equals("*")||sign.equals("/")){
            return true;
        }
        return false;
    }

    public static int cal(String v1,String v2,String sign){

        if(sign.equals("+")){
            return Integer.valueOf(v1)+Integer.valueOf(v2);
        }else if(sign.equals("-")){
            return Integer.valueOf(v1)-Integer.valueOf(v2);
        }else if(sign.equals("*")){
            return Integer.valueOf(v1)*Integer.valueOf(v2);
        }else if(sign.equals("/")){
            return Integer.valueOf(v1)/Integer.valueOf(v2);
        }
        return 0;
    }
}
