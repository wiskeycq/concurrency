package com.cq.interview.algorithm.finalTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caoqiang
 * @date 2021/6/5下午10:25
 */
public class RemoveAarryDupicate {
    public static void main(String[] args) {
        Integer[] arr = {1,1,2,2,4,5,6,6};
        //List<Integer> removeArr = remove(arr);
        System.out.println(countElement(arr));
    }

    public static List<Integer> remove(Integer[] arr) {
        List<Integer> list =  new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            if (!list.contains(arr[i])) {
                list.add(arr[i]);
            }
        }
        return list;
    }

    public static int countElement(Integer[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i=1;i<arr.length;i++) {

            if (!arr[count].equals(arr[i])) {
                count++;
                arr[count] = arr[i];
            }
        }
        return count+1;

    }
}
