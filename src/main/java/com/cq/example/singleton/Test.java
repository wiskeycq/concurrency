package com.cq.example.singleton;

import sun.misc.BASE64Decoder;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: caoqsq
 * @Date: 2018/5/7 16:07
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        //SingletonExample1 singletonExample1 = new SingletonExample1();//私有的构造函数不能new出来
        SingletonExample1.getInstance();
        BASE64Decoder base64Decoder = new BASE64Decoder();
        m.put(1,3);

    }

    public static final int a = 1;
    public static final Map<Integer,Integer> m = new HashMap<>();

    static {
        m.put(1,2);
    }
}
