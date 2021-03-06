package com.cq.interview.designPattern.observe.pullPattern;

/**
 * @Auther: caoqsq
 * @Date: 2018/7/18 17:32
 * @Description: 拉模式
 */
public class App {

    public static void main(String[] args) {
        //创建主题对象
       ConcreteSubject subject = new ConcreteSubject();
        //创建观察者对象
        Observer observer = new ConcreteObserver();
        //将观察者对象登记到主题对象上
        subject.attach(observer);
        //改变主题对象的状态
        subject.change("new state");
    }
}
