package com.cq.interview.designPattern.observe.jdkSupport;

import java.util.Observer;

/**
 * @Auther: caoqsq
 * @Date: 2018/7/19 09:50
 * @Description: 实现java对观察者模式的支持
 */
public class App {
    public static void main(String[] args) {

        //创建被观察者对象
        Watched watched = new Watched();
        //创建观察者对象，并将被观察者对象登记
        Observer watcher = new Watcher(watched);
        //给被观察者状态赋值
        watched.setData("start");
        watched.setData("run");
        watched.setData("stop");

    }
}
