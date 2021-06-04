package com.cq.interview.algorithm.recursion;

/**
 * @author caoqiang
 * @date 2021/5/23下午2:38
 *
 * 求出给定的一个数，有多少个素数，素数是能被一或者自身整除的数
 */
public class Prime {

    public static void main(String[] args) {
        System.out.println(bf(100));
    }

    //这个方法循环次数过于多，时间复杂度为O(n2)，属于暴力算法
    public static int bf(int n) {
        int count = 0;
        for (int i=2; i< n; i++) {
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }

    public static boolean isPrime(int x) {
        for (int i=2; i<x; i++) {
            if (x % i == 0 && x % 1 == 0) {
                return false;
            }
        }
        return true;
    }

    //--------------
}
