package com.cq.interview.algorithm.testAlgirithm;

/**
 * @author caoqiang
 * @date 2020/12/6上午9:18
 */
//平均O(nlogn),最坏O（n平方）
public class TestQuick {

    //如果枢纽元素是最后一个元素，则right遇到比枢纽元素小的元素就停下来，left遇到比枢纽元素大的元素就停下来，
    // 元素进行交换，知道left比right大未知，再进行left和枢纽元素交换
    private static int getMiddle(int[] arr,int left,int right){
        //  关键一点 选数组哪边开始作为基数点进行比较，需要从另一头开始进行判断,否则会进行错误的替换。
        int base=arr[right];
        while(left<right){
            while(left<right&&arr[left]<=base){
                left++;
            }
            arr[right]=arr[left];
            while(left<right&&arr[right]>=base){
                right--;
            }
            arr[left]=arr[right];
        }
        //因为这种方法 总是会将最初的base基准数字覆盖掉，所以 需要找到合适的地方，放入基准数字。
        arr[left]=base;
        return left;
        //System.out.println(left);
    }
    private static void quickSort(int[] a, int low, int high) {
        if(low<high){ //如果不加这个判断递归会无法退出导致堆栈溢出异常
            int middle = getMiddle(a,low,high);
            quickSort(a, 0, middle-1);
            quickSort(a, middle+1, high);
        }
    }
    public static void main(String[] args) {
        int array[] = {5,7,1,8,4};
        //int array[] = {10,5,3,1,7,2,8};
        System.out.println("排序前的元素为:");
        for (int e: array) {
            System.out.print(e+" ");
        }
        quickSort(array,0,array.length-1);
        System.out.println("\n排序之后的元素为:");
        for (int e: array) {
            System.out.print(e+" ");
        }
    }
}
