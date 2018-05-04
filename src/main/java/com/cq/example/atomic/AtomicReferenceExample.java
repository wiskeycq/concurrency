package com.cq.example.atomic;

import com.cq.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Auther: caoqsq
 * @Date: 2018/5/3 17:17
 * @Description:
 */
@Slf4j
@ThreadSafe
public class AtomicReferenceExample {

    public static AtomicReference<Integer> count = new AtomicReference(0);

    public static void main(String[] args) {
        count.compareAndSet(0,2);//2
        count.compareAndSet(0,1);//no(不执行)
        count.compareAndSet(1,3);//no
        count.compareAndSet(2,4);//4
        count.compareAndSet(3,5);//no
        log.info("count:{}",count.get());
    }
}
