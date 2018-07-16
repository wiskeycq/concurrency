package com.cq.loadClass;

/**
 * @Auther: caoqsq
 * @Date: 2018/7/16 17:17
 * @Description: Class.forName()和ClassLoader.loadClass()比较
 */
public class LoadClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = HelloWorld.class.getClassLoader();
        System.out.println(loader);
        //使用ClassLoader.loadClass()来加载类，不会执行初始化块
        loader.loadClass("com.cq.loadClass.HelloWorld");

        //使用Class.forName()来加载类，默认会执行初始化块
        //Class.forName("com.cq.loadClass.HelloWorld");
        //使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块
       /* ClassLoader loader = HelloWorld.class.getClassLoader();
        System.out.println(loader);
        Class.forName("com.cq.loadClass.HelloWorld", false, loader);*/
    }
}
