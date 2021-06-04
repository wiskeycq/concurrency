package com.cq.interview.algorithm.array;

/**
 * @author caoqiang
 * @date 2020/12/18下午3:05
 */
public class
Rotate {
    /**
     * 暴力发，最后一个跟第一个交换为止，再跟第二个交换位置，直到便利所有数组
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        rotate(nums, 2);
    }
}
