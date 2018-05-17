package com.cq.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Auther: caoqsq
 * @Date: 2018/5/16 17:09
 * @Description: CyclicBarrier await()用法说明
 */
@Slf4j
public class CyclicBarrierExample1 {

    private final static int threadCount = 20;

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) throws Exception {
        //创建一个线程池
        ExecutorService executorService=Executors.newCachedThreadPool();//线程池中是不能保证哪个线程先执行的

        //将20个请求放在线程池中去执行
        for (int i=0;i<threadCount;i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            executorService.execute(()-> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    log.error("exception");
                }
            });
        }
    }

    private static void race(int theadNum) throws Exception {
        Thread.sleep(1000);
        log.info("{} is ready",theadNum);
        cyclicBarrier.await();
        log.info("{} continue",theadNum);
    }
}
