package com.cq.interview.algorithm.array;

/**
 * @author caoqiang
 * @date 2020/12/18上午10:48
 *
 * 思路：第一个值和后面的比较，直到遇到不想等的为止,不想等的再和后面的比较依次比较
 * 时间复杂度O(n),空间复杂度O(1)
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
                System.out.println("j="+j+","+"i="+i+","+"nums[i]="+nums[i]+","+"nums[j]="+nums[j]);
            }
        }
        return i + 1;

    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3,4,8,9};
        System.out.println(removeDuplicates(nums));
    }
}
