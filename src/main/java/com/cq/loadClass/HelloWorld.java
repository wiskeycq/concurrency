package com.cq.loadClass;

/**
 * @Auther: caoqsq
 * @Date: 2018/7/16 17:18
 * @Description:
 */
public class HelloWorld {
    public static final String s = "静态变量";
    static {
        System.out.println(s);
        System.out.println("静态初始化块执行了！");
    }
}
