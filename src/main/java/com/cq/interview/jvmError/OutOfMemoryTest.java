package com.cq.interview.jvmError;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: caoqsq
 * @Date: 2018/7/20 10:41
 * @Description: https://blog.csdn.net/u012410733/article/details/53464295
 */
public class OutOfMemoryTest {
    public static void main(String[] args){
        List<Object> list = new ArrayList<Object>();
        while(true){
     /*       int[] index = new int[1000000];
            list.add(index);*/
        }
    }

    /*因为内存溢出,JVM不能分配给对象的创建空间.并且GC也不能够回收足够的空间.
    当你创建对象的速度快于JVM回收空间的时候就会发生空间不足这个问题：
    主要有三种情况：本身资源不够,申请的太多内存,资源耗尽
    解决办法：确认是不是内存本身就分配过小，找到最耗内存的对象，确认是否是资源耗尽*/

    /*只要我们知道错误发生的原因了。当出现相就的问题就可以快速定位问题，迅速解决问题。
    StackOverflowError：递归过深，递归没有出口。
    OutOfMemoryError：JVM空间溢出，创建对象速度高于GC回收速度。*/
}
