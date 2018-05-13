package com.cq.example.testCode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: caosq
 * @Date: 2018/05/12 11:25
 * @Description:
 */
public class CountTest {
    private static int count=0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        executorService.execute(()->{
            System.out.println(countSum());
        });

    }

    public static int countSum() {
        return count+1;
    }
}
