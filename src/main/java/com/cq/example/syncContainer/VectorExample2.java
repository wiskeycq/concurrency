package com.cq.example.syncContainer;

import com.cq.annoations.NotThreadSafe;
import jdk.internal.dynalink.beans.StaticClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Vector;

/**
 * @Auther: Administrator
 * @Date: 2018/5/10 22:30
 * @Description: 同步的方法操作顺序差异也会导致线程不安全的问题
 */
@Slf4j
@NotThreadSafe
public class VectorExample2 {

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread thread1 = new Thread() {
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            };

            Thread thread2 = new Thread() {
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.get(i);
                    }
                }
            };

            thread1.start();
            thread2.start();
        }
    }
}
