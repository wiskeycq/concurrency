package com.cq.example.testCode;

/**
 * @Auther: caoqsq
 * @Date: 2018/5/11 17:18
 * @Description:
 */
public class Test {

    //匿名的内部类
    ThreadLocal str = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return super.initialValue();
        }
    };

    class M extends ThreadLocal {
        @Override
        protected Object initialValue() {
            return super.initialValue();
        }
    }

    ThreadLocal smm = new ThreadLocal() {
        @Override
        protected Object initialValue() {
            return super.initialValue();
        }
    };

}
