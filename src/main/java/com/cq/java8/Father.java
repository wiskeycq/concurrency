package com.cq.java8;

/**
 * @author caoqiang
 * @date 2020/3/11下午4:27
 */
public class Father {
    public void doing(){
        talking();
    }

    public void talking(){
        System.out.println("father is talking!");
    }

    public static void main(String[] args) {
        Integer i = null;
        System.out.println(i * 60);
    }
}
