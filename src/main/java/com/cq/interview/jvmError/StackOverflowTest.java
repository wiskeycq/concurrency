package com.cq.interview.jvmError;

/**
 * @Auther: caoqsq
 * @Date: 2018/7/20 10:39
 * @Description:
 */
public class StackOverflowTest {

    public static void main(String[] args){
        method();
    }
    private static void method() {
        method();
    }
    /*抛出这个错误是因为递归太深.其实真正的原因是因为Java线程操作是基于栈的，当调用方法内部方法也就是进行一次递归的时候
    就会把当前方法压入栈直到方法内部的方法执行完全之后，就会返回上一个方法，也就是出栈操作执行上一个方法。*/
}
