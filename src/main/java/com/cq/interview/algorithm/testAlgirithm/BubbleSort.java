package com.cq.interview.algorithm.testAlgirithm;

/**
 * @author caoqiang
 * @date 2020/12/3下午4:28
 *
 * O(n2)
 */
public class BubbleSort {

    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j< arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,8,0,9,10,6};
        bubbleSort(arr);
        for (int i=0; i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
}
