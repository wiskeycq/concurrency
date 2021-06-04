package com.cq.interview.algorithm;

import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @Auther: caoqsq
 * @Date: 2018/8/15 10:54
 * @Description: 二分查找法
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 6, 12, 33, 87, 90, 97, 108, 561 };
        System.out.println("循环查找：" + (binarySearch(arr, 87) + 1));
    }

    public static int binarySearch(int arr[],int x) {
        int low = 0;
        int high = arr.length-1;
        while (low <= high) {
            int middle = (low+high)/2;
            if (x == arr[middle]) {
                return middle;
            } else if (x < arr[middle]) {
                high = middle-1;
            } else {
                low = middle +1;
                Collections.sort(null);
            }
        }
        return -1;
    }
}
