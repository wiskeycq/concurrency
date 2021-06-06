package com.cq.interview.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author caoqiang
 * @date 2020/12/10下午5:21
 */
public class RemoveRepeatChar {
    /**
     * 字符串去重
     * @param str
     * @return
     */
    public static String removeRepeatChar(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i ++) {
            char charWord = str.charAt(i);
            int firstPosition = str.indexOf(charWord);
            int lastPosition = str.lastIndexOf(charWord);
            if (firstPosition  == lastPosition || firstPosition == i) {
                sb.append(charWord);
            }
        }
        return sb.toString();
    }

    /**
     * 压缩字符串，并输出第一次的下标
     * @param str
     * @return
     */
    public static Map<String,Integer> pressChar(String str) {
        StringBuffer sb = new StringBuffer();
        Map<String,Integer> map = new HashMap<>();
        int spacePosition = 0;
        for (int i = 0; i < str.length(); i ++) {
            char charWord = str.charAt(i);
            int firstPosition = str.indexOf(charWord);
            int lastPosition = str.lastIndexOf(charWord);
            if (firstPosition  == lastPosition || firstPosition == i) {
                if (!String.valueOf(charWord).equals(" ")) {
                    sb.append(charWord);
                    map.put(String.valueOf(charWord), firstPosition);
                } else {
                    spacePosition = firstPosition;
                }
            }
        }
        if (str.contains(" ")) {
            sb.append(" ");
            map.put(" ", spacePosition);
        }
        return map;
    }

    public static void main(String[] args) {
        String str = removeRepeatChar("adc ddb");
        Map<String,Integer> map = pressChar("adc ddb");
        System.out.println(JSON.toJSONString(map));
        System.out.println(str);
    }
}
