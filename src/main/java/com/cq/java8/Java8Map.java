package com.cq.java8;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Auther: caoqsq
 * @Date: 2018/5/17 16:24
 * @Description:
 */
public class Java8Map {

    public static Map<String, Object> initData() {
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", 4);
        map.put("key5", 5);
        map.put("key5", 'h');
        return map;
    }

    /**
     * 遍历Map的方式一
     * 通过Map.keySet遍历key和value
     */
    public static void  test1() {
        Map<String, Object> map = initData();
        System.out.println("---------------------Before JAVA8 ------------------------------");
        for (String key : map.keySet()) {
            System.out.println("map.get(" + key + ") = " + map.get(key));
        }
        System.out.println("---------------------JAVA8 ------------------------------");
        map.keySet().forEach(key -> System.out.println("map.get(" + key + ") = " + map.get(key)));
    }

    /**
     * 遍历Map第二种
     * 通过Map.entrySet使用Iterator遍历key和value
     */
    public static void  test2() {
        Map<String, Object> map = initData();
        System.out.println("---------------------Before JAVA8 ------------------------------");
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            System.out.println("key:value = " + entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("---------------------JAVA8 ------------------------------");
        map.entrySet().iterator().forEachRemaining(item -> System.out.println("key:value=" + item.getKey() + ":" + item.getValue()));
    }

    /**
     * 遍历Map第三种
     * 通过Map.entrySet遍历key和value，在大容量时推荐使用
     */
    public static void test3() {
        Map<String, Object> map = initData();
        System.out.println("---------------------Before JAVA8 ------------------------------");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("key:value = " + entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("---------------------JAVA8 ------------------------------");
        map.entrySet().forEach(entry -> System.out.println("key:value = " + entry.getKey() + ":" + entry.getValue()));
    }

    /**
     * 遍历Map第四种
     * 通过Map.values()遍历所有的value，但不能遍历key
     */
    public static void test4() {
        Map<String, Object> map = initData();
        System.out.println("---------------------Before JAVA8 ------------------------------");
        for (Object value : map.values()) {
            System.out.println("map.value = " + value);
        }
        System.out.println("---------------------JAVA8 ------------------------------");
        map.values().forEach(System.out::println); // 等价于map.values().forEach(value -> System.out.println(value));
    }

    /**
     * 遍历Map第五种
     * 通过k,v遍历，Java8独有的
     */
    public static void test5() {
        Map<String, Object> map = initData();
        System.out.println("---------------------Only JAVA8 ------------------------------");
        map.forEach((k, v) -> System.out.println("key:value = " + k + ":" + v));
    }

    public static void main(String[] args) {
        //System.out.println(Optional.ofNullable(1).orElse(2));
//        System.out.println(0 << 32);
//        System.out.println(Objects.equals(1, null));
//        System.out.println((String) null);

//        String mm = "1,2,3,4";
//
//        List<String> ss = Arrays.asList(mm.split(","))
//                .stream().map(s -> s.trim()).collect(Collectors.toList());
//        System.out.println(ss);
//
//        Map<String, String> map = Maps.newHashMap();
//       // System.out.println(MapUt);
//        System.out.println(Objects.equals(null, null));
//
////        boolean a=null;
////        if (a.equals(true)) {
////            System.out.println(1);
////        }
////        if (a.equals(false)) {
////            System.out.println(2);
////        }
//
//        Integer a = 604;
//        Integer b = 603;
//        if (b.compareTo(a) >= 0) {
//            System.out.println("超距");
//        }
//
//        long mm1 = 0;
//        System.out.println(BigDecimal.valueOf(mm1));
//        List<String> list = Lists.newArrayList();
//        list.add(null);
//        System.out.println(list);
//        //System.out.println(Lists.newArrayList(null));
//        //System.out.println(Arrays.asList(null));
//
//        System.out.println(Optional.ofNullable("0.0").map(BigDecimal::new).orElse(null));
//        System.out.println("1".equals(null));
        Integer a = 1;
        System.out.println(a.equals(null));
        System.out.println(Objects.equals(a, null));
    }
}
