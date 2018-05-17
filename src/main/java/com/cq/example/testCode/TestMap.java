package com.cq.example.testCode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Auther: caoqsq
 * @Date: 2018/5/14 15:13
 * @Description:
 */
public class TestMap {
    public static void main(String[] args) {
        Map<String, String> req = new LinkedHashMap<String, String>();
        req.put("ResultCode","1");
        req.put("ResultCode","2");
        for (String v : req.values()) {
            System.out.println(v);
        }

        for (Map.Entry<String,String> map1 :req.entrySet()) {
            System.out.println(map1.getKey());
            System.out.println(map1.getValue());
        }

        System.out.println("p1".substring(1));

        int a=3;
        int b=2;
        int c=3;
        if(a==1 && b==3) {
            System.out.println("11111111111");
        } else {
            System.out.println("22222222222");
        }
    }
}
