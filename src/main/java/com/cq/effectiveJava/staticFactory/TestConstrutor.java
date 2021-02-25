package com.cq.effectiveJava.staticFactory;

import com.cq.example.aqs.FutureExample;

/**
 * @author caoqiang
 * @Description:
 * @date 2019/3/26下午3:46
 */
public class TestConstrutor {
    public TestConstrutor() {}

    public TestConstrutor(int x, String y) {

    }

    public TestConstrutor(String y, int x) {
       // Boolean.valueOf()
    }

    //内部类(用static声明)
    static class Person  {

        public int fun() {
            return 1;
        }
    }
    // 内部类
    class Son {

        public int fun() {
            return 2;
        }
    }
}
