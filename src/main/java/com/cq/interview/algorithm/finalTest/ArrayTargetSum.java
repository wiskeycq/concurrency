package com.cq.interview.algorithm.finalTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author caoqiang
 * @date 2021/6/6上午11:15
 *
 * 求数组中两个元素的和等于目标target，然后返回这两个元素下标
 */
public class ArrayTargetSum {
    public static void main(String[] args) {
        int[] arr={1,2,5,8,10,19};
        int[] result = getTargetIndex(arr,18);
        int[] result1 = getTargetIndex1(arr,18);
        System.out.println(result);

    }

    //暴力算法,时间复杂度的n的平方
    public static int[] getTargetIndex(int[] arr, int target) {
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (arr[i]+arr[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    //时间复杂度n，用map标记的做法
    public static int[] getTargetIndex1(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                return new int[]{map.get(target - arr[i]), i};
            }
            map.put(arr[i], i);
        }
        return new int[0];
    }
}
