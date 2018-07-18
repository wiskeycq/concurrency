package com.cq.interview.designPattern.observe.pushPattern;

/**
 * @Auther: caoqsq
 * @Date: 2018/7/18 17:29
 * @Description:
 */
public class ConcreteSubject extends Subject {
    private String state;

    public String getState() {
        return state;
    }

    public void change(String newState){
        state = newState;
        System.out.println("主题状态为：" + state);
        //状态发生改变，通知各个观察者
        this.nodifyObservers(state);
    }
}
