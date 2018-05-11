package com.cq.example.syncContainer;

import java.util.Iterator;
import java.util.Vector;

/**
 * @Auther: caoqsq
 * @Date: 2018/5/11 15:20
 * @Description: 对于foreach或者迭代器循环操作集合的时候尽量不要做remove或者add等更新操作时；如果需要更新操作，
 * 则遍历的时候不要更新，把遍历的数据做标记，等遍历完再更新；单线程会报错，多线程更会报错；增删操作的遍历推荐使用for循环进行操作
 */
public class VectorLoopExample {

    // java.util.ConcurrentModificationException
    private static void test1(Vector<Integer> v1) { // foreach
        for(Integer i : v1) {
            if (i.equals(3)) {
                v1.remove(i);
                //v1.add(4);
            }
        }
    }

    // java.util.ConcurrentModificationException
    private static void test2(Vector<Integer> v1) { // iterator
        Iterator<Integer> iterator = v1.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i.equals(3)) {
                v1.remove(i);
            }
        }
    }

    // success
    private static void test3(Vector<Integer> v1) { // for
        for (int i = 0; i < v1.size(); i++) {
            if (v1.get(i).equals(3)) {
                v1.remove(i);
                //v1.add(4);
            }
        }
    }

    public static void main(String[] args) {

        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        test1(vector);
    }
}
