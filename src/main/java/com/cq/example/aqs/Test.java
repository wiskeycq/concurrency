package com.cq.example.aqs;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author caoqiang
 * @date 2021/4/27下午6:21
 */
public class Test {
    public static void main(String[] args) throws InterruptedException{
        List<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.contains(1));
        System.out.println(list.contains(4));
        System.out.println(list.contains(null));
    }
}
