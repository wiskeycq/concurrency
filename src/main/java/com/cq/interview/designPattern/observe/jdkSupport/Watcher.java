package com.cq.interview.designPattern.observe.jdkSupport;

import java.util.Observable;
import java.util.Observer;

/**
 * @Auther: caoqsq
 * @Date: 2018/7/19 09:49
 * @Description: 观察者
 */
public class Watcher implements Observer {

    public Watcher(Observable o){
        o.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("状态发生改变：" + ((Watched)o).getData());
    }
}
