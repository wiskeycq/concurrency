package com.cq.interview.algorithm.finalTest;

import java.util.Arrays;

/**
 * @author caoqiang
 * @date 2021/6/6上午11:00
 *
 * 求一个数组中三个数的乘积最大
 */
public class ThreeArrary {
    public static void main(String[] args) {
        int[] arr = {1,2,-5,9,3,-6};
        System.out.println(sort(arr));
    }

    public static int sort(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        return Math.max(arr[0] * arr[1] * arr[n-1], arr[n-1]*arr[n-2]*arr[n-3]);
    }
}
