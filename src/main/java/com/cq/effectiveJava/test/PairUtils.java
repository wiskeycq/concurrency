package com.cq.effectiveJava.test;

import javafx.util.Pair;

/**
 * @author caoqiang
 * @date 2019/11/22上午11:07
 */
public class PairUtils {
    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(1, "mmm");
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());
    }
}
