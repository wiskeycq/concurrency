package com.cq.interview.algorithm;

/**
 * @Auther: caoqsq
 * @Date: 2018/8/15 11:26
 * @Description: 冒泡排序 时间复杂度o(n2)  n的平方
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={12,45,89,2,10,9};
        bubbleSort(arr);
        for (int e: arr) {
            System.out.print(e+" ");
        }
    }

    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
                    //不引入第三个变量，进行数据交换
                    arr[j] = arr[j]+arr[j+1];
                    arr[j+1] = arr[j]-arr[j+1];
                    arr[j] = arr[j] - arr[j+1];
                }
            }
        }
    }
}
