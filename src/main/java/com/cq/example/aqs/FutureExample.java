package com.cq.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Auther: caosq
 * @Date: 2018/05/21 20:08
 * @Description:
 */
@Slf4j
public class FutureExample {

   static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            log.info("do something in callable");
            Thread.sleep(5000);
            return "Done";
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());
        log.info("do something in main");
        Thread.sleep(1000);
        String result = future.get();//获取线程执行的结果。如果上面的call方法没执行完，这个地方将一直阻塞，直到完成。
        log.info("result : {}",result);
    }
}
