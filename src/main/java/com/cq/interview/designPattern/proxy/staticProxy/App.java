package com.cq.interview.designPattern.proxy.staticProxy;

/**
 * @Auther: caoqsq
 * @Date: 2018/7/18 14:11
 * @Description: 测试类
 */
public class App {
    public static void main(String[] args) {

        //目标对象
        UserDao userDao = new UserDao();

        //代理对象,把目标对象传给代理对象,建立代理关系
        UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);

        //执行的是代理的方法
        userDaoProxy.save();
    }
}
