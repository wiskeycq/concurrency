package com.cq.interview.algorithm;

/**
 * @author caoqiang 判断一个数是不是2的倍数
 * @date 2021/5/22下午4:00
 */
public class Test {

    /**
     * 普通实现
     * @param n
     * @return
     */
    public static boolean test(int n) {
        if (n>0) {
            while (n>0) {
                int t = n % 2;
                if (t != 0) {
                    return false;
                }
                n = n/2;
            }
            return true;
        }
        return false;
    }

    /**
     * 二进制的按位与运算
     * @param n
     * @return
     */
    public static boolean test1(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(test1(1));
        System.out.println(test1(3));
        System.out.println(test1(4));
        System.out.println(test1(11));
        System.out.println(test1(32));
    }

}
