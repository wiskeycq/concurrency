package com.cq.interview.algorithm.finalTest;

/**
 * @author caoqiang
 * @date 2021/6/6上午10:35
 *
 * 二分法就平方根
 */
public class SqrtX {
    public static void main(String[] args) {
        System.out.println(getSqrtX(25));
    }

    public static int getSqrtX(int x) {
        int index=-1;
        int low = 0;
        int high = x;
        while (low <= high) {
            int mid = (high+low)/2;
            if (mid * mid <= x) {
                index = mid;
                low= mid+1;
            } else {
                high = mid-1;
            }
        }
        return index;
    }

}
