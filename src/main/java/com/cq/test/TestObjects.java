package com.cq.test;

import java.util.EnumSet;
import java.util.Objects;

/**
 * @author caoqiang
 * @Description:
 * @date 2019/5/13上午11:00
 */
public class TestObjects {
    public static void main(String[] args) {
//        System.out.println(Objects.equals("",""));
//        System.out.println(Objects.equals(null,null));
//        System.out.println(null==null);
        EnumSet<Gfg> set1 = EnumSet.of(Gfg.CODE,Gfg.LEARN,Gfg.MCQ);
        EnumSet set2 = EnumSet.complementOf(set1);
        EnumSet set3 = EnumSet.allOf(Gfg.class);
        EnumSet set4 = EnumSet.range(Gfg.LEARN,Gfg.QUIZ);
        System.out.println(set1);
        System.out.println(set2);
        System.out.println(set3);
        System.out.println(set4);
    }
    enum Gfg
    {
        CODE, LEARN, CONTRIBUTE, QUIZ, MCQ
    }
}
