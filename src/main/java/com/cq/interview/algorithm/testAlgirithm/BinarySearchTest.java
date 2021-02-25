package com.cq.interview.algorithm.testAlgirithm;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author caoqiang
 * @date 2020/12/3下午5:29
 */
public class BinarySearchTest {

    public static List<Integer> search(int arr[], int val) {
        int low = 0;
        int high = arr.length - 1;
        List<Integer> indexList = Lists.newArrayList();

        while (low < high) {
            int middle = (low+high)/2;
            if (arr[middle] > val) {
                high = middle -1;
            } else if(arr[middle] < val) {
                low = middle + 1;
            } else {
                int temp = middle -1;
                indexList.add(middle);
                while (true) {
                    if (temp <0 || arr[temp] != val) {
                        break;
                    }
                    indexList.add(temp);
                    temp--;
                }
                return indexList;
            }
        }
        return indexList;
    }

   public static int getIndex(List<Integer> indexList) {
       if (CollectionUtils.isEmpty(indexList)) {
           return 1;
       }
       return indexList.get(indexList.size()-1)+1;
   }

    public static void main(String[] args) {
        int[] arr = { 6, 12, 87, 87,87, 90, 97, 108, 561};
        List<Integer> indexList = search(arr, 87);
        System.out.println(getIndex(indexList));
        //System.out.println("循环查找：" + (search(arr, 87)));
    }
}
