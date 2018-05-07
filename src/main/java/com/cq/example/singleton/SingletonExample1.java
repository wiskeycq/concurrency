package com.cq.example.singleton;

import com.cq.annoations.NotThreadSafe;

/**
 * @Auther: caoqsq
 * @Date: 2018/5/7 16:06
 * @Description: 懒汉模式：单例实例在第一次使用时进行创建
 */
@NotThreadSafe
public class SingletonExample1 {

    //私有的构造函数
    private SingletonExample1() {
    }
    //单例对象
    private static SingletonExample1 instance = null;
    //静态工厂方法
    public static SingletonExample1 getInstance() {
        if (instance != null) {
           instance= new SingletonExample1();
        }
        return instance;
    }
}
