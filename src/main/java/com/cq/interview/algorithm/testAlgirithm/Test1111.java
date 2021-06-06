package com.cq.interview.algorithm.testAlgirithm;

/**
 * @author caoqiang
 * @date 2021/6/4下午4:07
 */
public class Test1111 {
    public static void main(String arg[]) {
//        StringBuffer sb = new StringBuffer();
//        sb.append(1);
//        String str1[] = new String[6];
//        Integer a[] = new Integer[7];
//        Integer b[] = {1,2};
//        String str = "&mcdn";
//        String arr[] = str.split("");
//        for (int i=0;i<arr.length;i++) {
//            System.out.println(arr[i]);
//        }
       // System.out.println(arr);
//        for (int i=0; i< str.length(); i++) {
//            char c = str.charAt(i);
//            String sss = String.valueOf(c);
//            Integer m = Integer.valueOf(c);
//            System.out.println(c);
//        }

        int arr1[] = {1,10,20,90,100,101,790};
        System.out.println(binarySearch(arr1, 90));
    }

    public static int binarySearch(int arr1[], int x) {
        int low = 0;
        int high = arr1.length-1;
        System.out.println(high);
        while (low <= high) {
            int middle = low+high/2;
            if (x == arr1[middle]) {
                return middle;
            } else if (x < arr1[middle]) {
                high = middle -1;
            } else {
                low = middle +1;
            }
        }
        return -1;
    }
}
