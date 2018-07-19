package com.cq.interview.designPattern.observe.jdkSupport;

import java.util.Observable;

/**
 * @Auther: caoqsq
 * @Date: 2018/7/19 09:48
 * @Description: 被观察者
 */
public class Watched extends Observable {
    private String data = "";

    public String getData() {
        return data;
    }

    public void setData(String data) {

        if(!this.data.equals(data)){
            this.data = data;
            setChanged();
        }
        notifyObservers();
    }
}
