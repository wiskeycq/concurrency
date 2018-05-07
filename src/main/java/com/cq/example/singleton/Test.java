package com.cq.example.singleton;

/**
 * @Auther: caoqsq
 * @Date: 2018/5/7 16:07
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        //SingletonExample1 singletonExample1 = new SingletonExample1();//私有的构造函数不能new出来
        SingletonExample1.getInstance();
    }
}
