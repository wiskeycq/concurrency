package com.cq.test;

import java.util.EnumMap;

/**
 * @author caoqiang
 * @date 2019/12/9下午7:44
 */
public class Test {
    //定义枚举类
    enum Season {
        SPRING,SUMMER,FALL,WINTER
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //在创建EnumMap时必须显示或隐式指定它对应的枚举类
        EnumMap enumMap = new EnumMap<>(Season.class);

        //所有的key都必须是单个枚举类的枚举值
        enumMap.put(Season.SUMMER, "夏日炎炎");
        enumMap.put(Season.SPRING, "穿暖花开");

        //EnumMap根据key的自然顺序（枚举值在枚举类的定义顺序）来维护key-value对的顺序
        System.out.println(enumMap);                //{SPRING=穿暖花开, SUMMER=夏日炎炎}

        System.out.println(System.currentTimeMillis());
    }
}
