package com.cq.interview.designPattern.templateMethod;

/**
 * @Auther: caoqsq
 * @Date: 2018/7/18 16:16
 * @Description:
 */
public abstract class AbstractClass {

    protected abstract void doAnything();//模板方法

    protected abstract void doSomething();//模板方法

    public final void templateMethod(){
        /*
         * 调用基本方法，完成相关的逻辑
         */
        this.doAnything();
        this.doSomething();
    }
}
