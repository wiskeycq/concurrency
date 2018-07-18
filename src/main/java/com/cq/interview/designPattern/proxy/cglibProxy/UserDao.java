package com.cq.interview.designPattern.proxy.cglibProxy;

/**
 * @Auther: caoqsq
 * @Date: 2018/7/18 16:05
 * @Description: 目标对象,没有实现任何接口
 */
public class UserDao {
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}
