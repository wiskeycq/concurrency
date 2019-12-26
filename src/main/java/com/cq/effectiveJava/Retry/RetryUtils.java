package com.cq.effectiveJava.Retry;

import lombok.extern.slf4j.Slf4j;

/**
 * @author caoqiang
 * @date 2019/12/26下午4:04
 */
@Slf4j
public class RetryUtils {
    //private static final Log logger = LogFactory.getLog(RetryUtils.class);

    public RetryUtils() {
    }

    public static <T> T retry(RetryFun<T> fun, int count, Class<?> clazz, String methodName) throws Exception {
        return retry(fun, count, clazz, methodName, false);
    }

    public static <T> T retry(RetryFun<T> fun, int count, Class<?> clazz, String methodName, boolean recordBusFailMetric) throws Exception {
        return retry(fun, count, clazz, methodName, false, recordBusFailMetric);
    }

    public static <T> T retry(RetryFun<T> fun, int count, Class<?> clazz, String methodName, boolean recordTimeMetric, boolean recordBusFailMetric) throws Exception {
        String logStr = clazz.getName() + "-" + methodName;
        int i = 1;
        int j=1;

        while(true) {
            long start = System.currentTimeMillis();

            try {
                T result = fun.execute();
//                if (recordTimeMetric) {
//                    EtraceMetricUtils.recordTimeMetric(clazz, methodName, start);
//                }

                return result;
            } catch (Exception var11) {
                if (var11 instanceof InterruptedException) {
                    if (recordBusFailMetric) {
                        //EtraceMetricUtils.recordBizFailCountMetric(clazz, methodName);
                    }

                    log.error("第【{}】次执行【{}】重试任务时【业务异常】msg={}不需重试", new Object[]{i, logStr, var11.getMessage()});
                    throw var11;
                }

               // EtraceMetricUtils.recordSysFailCountMetric(clazz, methodName);
                if (i >= count) {
                    log.error(String.format("第【%s】次执行【%s】重试任务时【其它异常】不再重试", i, logStr), var11);
                    throw var11;
                }

                log.error(String.format("第【%s】" + "次执行【%s】重试任务时【其它异常】继续重试", i, logStr), var11);
                System.out.println(i++);
                System.out.println(++j);
                if (i++ >= count) {
                    log.error(String.format("执行【%s】重试任务时出现严重错误！！！", logStr));
                    throw new RuntimeException();
                }
            }
        }
    }
}
