package com.cq.effectiveJava.Retry;

/**
 * @author caoqiang
 * @date 2019/12/26下午4:05
 */
@FunctionalInterface
public interface RetryFun<T> {
    T execute() throws Exception;
}
