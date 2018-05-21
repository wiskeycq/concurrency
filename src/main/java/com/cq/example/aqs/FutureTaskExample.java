package com.cq.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Auther: caosq
 * @Date: 2018/05/21 20:08
 * @Description:
 */
@Slf4j
public class FutureTaskExample {
    public static void main(String[] args) throws Exception {
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("do something in callable");
                Thread.sleep(5000);
                return "Done";
            }
        });
        new Thread(futureTask).start();
        Thread.sleep(1000);
        log.info("do something in main");
        String result = futureTask.get();//获取线程执行的结果。如果上面的call方法没执行完，这个地方将一直阻塞，直到完成。
        log.info("result : {}",result);
    }
}
