package com.cq.effectiveJava.test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author caoqiang
 * @Description:
 * @date 2019/4/15下午11:15
 */
public class fastJsonDiff {
    private static Map<String,String> errorMap = new HashMap<>();
    @SuppressWarnings("unchecked")
    public static Map<String, String> compareJson(JSONObject json1, JSONObject json2, String key) {
        Iterator<String> i = json1.keySet().iterator();
        while (i.hasNext()) {
            key = i.next();
            Map<String, String> map = Maps.newHashMap();
            map = compareJson(json1.get(key), json2.get(key), key);
            errorMap.putAll(map);
        }
        return errorMap;
    }

    public static Map<String, String> compareJson(Object json1, Object json2, String key) {
        Map<String, String> map = Maps.newHashMap();
        if (json1 instanceof JSONObject) {
            map = compareJson((JSONObject) json1, (JSONObject) json2, key);
        } else if (json1 instanceof JSONArray) {
            map = compareJson((JSONArray) json1, (JSONArray) json2, key);
        } else if (json1 instanceof String) {
            try {
                String json1ToStr = json1 == null ? null : json1.toString();
                String json2ToStr = json2 == null ? null : json2.toString();
                map = compareJson(json1ToStr, json2ToStr, key);
            } catch (Exception e) {
                System.out.println("转换发生异常 key:" + key);
                e.printStackTrace();
            }

        } else {
            String json1ToStr = json1 == null ? null : json1.toString();
            String json2ToStr = json2 == null ? null : json2.toString();
            map = compareJson(json1ToStr, json2ToStr, key);
        }
        return map;
    }

    public static Map<String, String> compareJson(String str1, String str2, String key) {
        Map<String, String> map = Maps.newHashMap();
        if (str1 == null && str1 == null) {

        } else if (str1 == null) {
            Map<String, String> valueMap = Maps.newHashMap();
            valueMap.put("phpValue", null);
            valueMap.put("javaValue", str2);
            map.put(key, valueMap.toString());

        } else if (!str1.equals(str2)) {
            Map<String, String> valueMap = Maps.newHashMap();
            valueMap.put("phpValue", str1);
            valueMap.put("javaValue", str2);
            map.put(key, valueMap.toString());
        }
        return map;
    }

    public static Map<String, String> compareJson(JSONArray json1, JSONArray json2, String key) {
        Map<String, String> map = Maps.newHashMap();

        if (json1 != null && json2 != null) {
            Iterator i1 = json1.iterator();
            Iterator i2 = json2.iterator();
//            System.out.println("json1"+);
//            System.out.println("json2"+json2.size());
            while (i1.hasNext()) {
                Object o1 = i1.next();
                Object o2 = i2.next();

                if  (o1 != null && o2 != null) {
                    map = compareJson(o1, o2, key);
                }
            }

        } else {

            if (json1 == null && json2 == null) {
                System.err.println("不一致：key:" + key + "  在json1和json2中均不存在");
            } else if (json1 == null) {
                Map<String, String> valueMap = Maps.newHashMap();
                valueMap.put("phpValue", null);
                valueMap.put("javaValue", json2.toString());
                map.put(key, valueMap.toString());
                System.err.println("不一致：key:" + key + "  在json1中不存在");
            } else if (json2 == null) {
                Map<String, String> valueMap = Maps.newHashMap();
                valueMap.put("phpValue", json1.toString());
                valueMap.put("javaValue", null);
                map.put(key, valueMap.toString());
               // System.err.println("不一致：key:" + key + "  在json2中不存在");
            } else {
                //System.err.println("不一致：key:" + key + "  未知原因");
            }
        }
        return map;
    }

    private final static String st1 = "{\n" +
            "\t\"username\": \"tom\",\n" +
            "\t\"age\": 18,\n" +
            "\t\"address\": [{\n" +
            "\t\t\"province\": \"上海市\"\n" +
            "\t}, {\n" +
            "\t\t\"city\": \"上海市\"\n" +
            "\t}, {\n" +
            "\t\t\"disrtict\": \"静安区\"\n" +
            "\t}]\n" +
            "}";
    //private final static String st2 = "{username:\"tom\",age:18}";
    private final static String st2 =  "{\n" +
            "\t\"username\": \"tom\",\n" +
            "\t\"age\": 18,\n" +
            "\t\"address\": [{\n" +
            "\t\t\"province\": \"上海市\"\n" +
            "\t},  {\n" +
            "\t\t\"disrtict\": null\n" +
            "\t}]\n" +
            "}";

    public static void main(String[] args) {
        //System.out.println(st1);
        JSONObject jsonObject1 = JSONObject.parseObject(st1);
        JSONObject jsonObject2 = JSONObject.parseObject(st2);
        Map<String, String> map = compareJson(jsonObject1, jsonObject2, null);
        System.out.println(map);

//        String str3 ="{username:\"tom\",age:18}";
//        JSONObject jsonObject3 = JSONObject.parseObject(str3);
//        Iterator<String> i = jsonObject3.keySet().iterator();
//
//        while (i.hasNext()) {
//            String key = i.next();
//            System.out.println(jsonObject3.get(key));
//            if (jsonObject3.get(key) instanceof String) {
//                System.out.println("tom....");
//            } else {
//                System.out.println("18>>>>>");
//            }
//
//            if (null instanceof String) {
//                System.out.println("null...");
//            }
//        }



    }
}
