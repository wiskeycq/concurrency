package com.cq.interview.designPattern.proxy.cglibProxy;

/**
 * @Auther: caoqsq
 * @Date: 2018/7/18 16:07
 * @Description: 测试类
 */
public class App {
    public static void main(String[] args) {
        //目标对象
        UserDao target = new UserDao();

        //代理对象
        UserDao proxy = (UserDao)new ProxyFactory(target).getProxyInstance();

        //执行代理对象的方法
        proxy.save();
    }
}
