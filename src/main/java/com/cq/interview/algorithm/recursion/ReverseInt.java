package com.cq.interview.algorithm.recursion;

/**
 * @author caoqiang
 * @date 2021/3/11下午3:26
 *
 * 例如给出正整数 n=12345，希望以各位数的逆序形式输出，即输出54321。
 */
public class ReverseInt {

    /**
     * 123%10 = 3
     * 12%10 = 2
     * 1%10 = 1
     * @param n
     */
    public static void fun(int n) {
        System.out.print(n%10);
        if (n >= 10) {
            fun(n/10);
        }
    }

    public static void main(String[] args) {
        fun(123);
    }
}
