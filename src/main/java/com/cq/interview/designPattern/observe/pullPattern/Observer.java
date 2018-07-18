package com.cq.interview.designPattern.observe.pullPattern;

/**
 * @Auther: caoqsq
 * @Date: 2018/7/18 17:42
 * @Description:
 */
public interface Observer {
    /**
     * 更新接口
     * @param subject 传入主题对象，方面获取相应的主题对象的状态
     */
    public void update(Subject subject);
}
