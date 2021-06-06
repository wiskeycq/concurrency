package com.cq.interview.algorithm.finalTest;

/**
 * @author caoqiang
 * @date 2021/6/5下午10:05
 */
public class Prime1 {

    public static void main(String[] args) {
        int n = 100;
        System.out.println(countPrime(n));
    }

    public static int countPrime(int n) {
        int count = 0 ;
        for (int i =2; i<=n; i++) {
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }

    public static boolean isPrime(int x) {
        for (int i =2; i<x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
