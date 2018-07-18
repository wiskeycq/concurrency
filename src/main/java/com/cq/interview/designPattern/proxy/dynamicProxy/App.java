package com.cq.interview.designPattern.proxy.dynamicProxy;

/**
 * @Auther: caoqsq
 * @Date: 2018/7/18 14:39
 * @Description:
 */
public class App {
    public static void main(String[] args) {
        // 目标对象
        IUserDao target = new UserDao();
        // 【原始的类型 class cn.itcast.b_dynamic.UserDao】
        System.out.println(target.getClass());
        //System.out.println(target.getClass().getClassLoader());
        //System.out.println(target.getClass().getInterfaces());

        // 给目标对象，创建代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());

        // 执行方法   【代理对象】
        proxy.save();
    }
}
