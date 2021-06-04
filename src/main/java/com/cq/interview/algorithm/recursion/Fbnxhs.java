package com.cq.interview.algorithm.recursion;

/**
 * @author caoqiang
 * @date 2021/3/11下午2:16
 * 斐波那契数列的是这样一个数列：1、1、2、3、5、8、13、21、34、….，即第一项 f(1) = 1、第二项 f(2) = 1、…..、
 * 第 n 项目为 f(n)=f(n-1)+f(n-2)，求第 n 项的值是多少。
 */
public class Fbnxhs {

    public static int fun(int n) {
        // 先写递归结束条件
        if (n<=2) {
            return 1;
        }
        // 写等价关系式
        return fun(n-1) + fun(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fun(7));
    }
}
