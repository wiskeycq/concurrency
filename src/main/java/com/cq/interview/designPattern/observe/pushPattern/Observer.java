package com.cq.interview.designPattern.observe.pushPattern;

/**
 * @Auther: caoqsq
 * @Date: 2018/7/18 17:28
 * @Description:
 */
public interface Observer {
    /**
     * 更新接口
     * @param state  更新的状态
     */
     void update(String state);
}
