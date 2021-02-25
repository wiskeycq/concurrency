package com.cq.interview.algorithm.testAlgirithm;

/**
 * @author caoqiang
 * @date 2020/12/6上午8:59
 */
public class TestArr {
    public static void main(String[] args) {
        int arr[] = {1,2,4,5};
        System.out.println(arr.length);
        for (int i=0;i<arr.length; i++){
            System.out.println(arr[i]);
        }
        for (int m:arr) {
            System.out.println(m);
        }
    }
}
