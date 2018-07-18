package com.cq.interview.designPattern.proxy.staticProxy;

/**
 * @Auther: caoqsq
 * @Date: 2018/7/18 14:03
 * @Description: 接口实现 目标对象
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}
