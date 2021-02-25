package com.cq.java8;

/**
 * @author caoqiang
 * @date 2020/3/11下午4:28
 */
public class Son extends Father {
//    @Override
//    public void talking() {
//
//        //System.out.println("Son is talking!");
//    }

    public static void main(String[] args) {
        Father father=new Son();
        father.doing();
    }
}
