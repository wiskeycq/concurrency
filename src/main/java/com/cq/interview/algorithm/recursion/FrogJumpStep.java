package com.cq.interview.algorithm.recursion;

/**
 * @author caoqiang
 * @date 2021/3/11下午2:21
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 1->1
 * 2->1,1 || 2
 * 3-> 1,1,1 || 1,2 || 2,1
 * 4-> 1,1,1,1 || 1,2,1|| 1,1,2 || 2,1,1 || 2,2
 * 5-> 1,1,1,1 || 1,2,1,1 || 1,2,2 || 1,1,2,1 || 1,1,1,2 || 2,1,1,1 || 2,2,1 || 2,1,2
 *
 * 得出公式: f(n) = f(n-1)+f(n-2)
 */
public class FrogJumpStep {

    public static int fun(int n) {
        if (n< 1) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        return fun(n-1) + fun(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fun(5));
    }
}
