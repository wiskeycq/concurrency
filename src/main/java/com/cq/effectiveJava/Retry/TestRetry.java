package com.cq.effectiveJava.Retry;

/**
 * @author caoqiang
 * @date 2019/12/26下午4:09
 */
public class TestRetry {

    public static int  test() {
        int i=0;
        int j=1;
        return j/i;
    }

    public static void main(String[] args) throws Exception {
        int i =RetryUtils.retry(()-> test(), 3, TestRetry.class, "test");
        System.out.println(i);

    }
}
