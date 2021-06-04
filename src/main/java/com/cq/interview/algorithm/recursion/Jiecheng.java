package com.cq.interview.algorithm.recursion;

/**
 * @author caoqiang
 * @date 2021/3/11上午11:48
 * 阶乘(递归)
 * https://www.cnblogs.com/yanggb/p/11138049.html
 */
public class Jiecheng {

    /**
     * 阶乘的公式 f(n)=(n-1)! * n
     * @param n
     * @return
     */
    public static int f(int n) {
        if (n<=2) {
            return n;
        }
        return f(n-1) * n;
    }

    public static void main(String[] args) {
        System.out.println(f(3));
    }
}
