package com.cq.effectiveJava.generics;


import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caoqiang
 * @Description:
 * @date 2019/4/4上午11:42
 */
public class Test {
    public static void main(String[] args) {
//        List arrayList = new ArrayList();
//        //arrayList.add("1");
//        arrayList.add(1000);
//        arrayList.add("sss");
//
//        for(int i = 0; i< arrayList.size();i++){
//            String item = (String)arrayList.get(i);
//            System.out.println(item);
//        }

//        List<String> stringArrayList = new ArrayList<String>();
//        List<Integer> integerArrayList = new ArrayList<Integer>();
//
//        Class classStringArrayList = stringArrayList.getClass();
//        Class classIntegerArrayList = integerArrayList.getClass();
//
//        if(classStringArrayList.equals(classIntegerArrayList)){
//            System.out.println("泛型测试类型相同");
//        }
        long m=2;
        Long mm = (Long)m;
        System.out.println(mm);


    }
}
