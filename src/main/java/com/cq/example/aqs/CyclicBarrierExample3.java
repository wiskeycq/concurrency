package com.cq.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: caoqsq
 * @Date: 2018/5/16 17:09
 * @Description: CyclicBarrier用法之await()带有参数说明
 */
@Slf4j
public class CyclicBarrierExample3 {

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
        try {
            cyclicBarrier.await(2000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            log.error("barrierException");
        }//如果这个地方不加try catch的话，后面的continue就不执行了，直接把异常抛到外面了
        log.info("{} continue",theadNum);
    }
}
