package com.cq.interview.algorithm.finalTest;

/**
 * @author caoqiang
 * @date 2021/6/6上午10:10
 *
 * 获取数组中心下标
 */
public class ArrayCenterIndex {
    public static void main(String[] args) {
        int[] arr= {1,2,4,-1,10,1,9,0,6,1};
        System.out.println(getArrayCenterIndex(arr));
    }

    public static int getArrayCenterIndex(int[] arr) {
        int sum = 0;
        if (arr.length == 0) {
            return -1;
        }
        for (int i=0;i<arr.length;i++) {
            sum += arr[i];
        }

        int total = 0;

        for (int j=0;j<arr.length;j++) {
            total += arr[j];
            if (total == sum) {
                return j;
            }
            sum = sum-arr[j];

        }
        return -1;
    }
}
