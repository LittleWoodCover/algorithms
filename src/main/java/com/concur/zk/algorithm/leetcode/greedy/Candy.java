package com.concur.zk.algorithm.leetcode.greedy;


import java.util.Arrays;

/**
 * 糖果问题的求解。
 * 有需求因子数组为{5,10,2,9,15,9}
 * 糖果包为：{6,1,20,3,8}最多可以满足几个孩子。
 */
public class Candy {


    public static void main(String[] args) {

        int[] require={5,10,2,9,15,9};
        int[] solution={6,1,20,3,8};
        int count=0;
        Arrays.sort(require);
        Arrays.sort(solution);
        System.out.println(Arrays.toString(require));
        int i=0,j=0;
        while(i<=require.length-1&&j<=solution.length-1){

            if(require[i]<=solution[j]){
                count++;
                i++;j++;
            }else if(require[i]>solution[j]){
                j++;
            }
        }
        System.out.println(count);
    }
}
