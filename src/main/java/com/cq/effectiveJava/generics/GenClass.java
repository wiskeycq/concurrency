package com.cq.effectiveJava.generics;

/**
 * @author caoqiang
 * @Description: 范型类
 * @date 2019/4/4上午11:57
 */
public class GenClass<T> {
    public T key;

    public GenClass(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public <T> void str(T... args) {

    }

}
