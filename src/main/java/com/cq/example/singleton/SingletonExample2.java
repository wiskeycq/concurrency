package com.cq.example.singleton;

import com.cq.annoations.NotThreadSafe;
import com.cq.annoations.ThreadSafe;

/**
 * @Auther: caoqsq
 * @Date: 2018/5/7 16:06
 * @Description: 饿汉模式：单例实例在类装载使用时进行创建
 */
@ThreadSafe
public class SingletonExample2 {

    //私有的构造函数
    private SingletonExample2() {
    }
    //单例对象
    private static SingletonExample2 instance = new SingletonExample2();
    //静态工厂方法
    public static SingletonExample2 getInstance() {
        return instance;
    }
}
