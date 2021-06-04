package com.cq.metric;


/**
 * kcj
 * 2015年12月15日 上午11:38:14
 */
public interface MetricConstants {

	//系统异常
	String sys_fail_suffix = "_sys_fail";
	//业务异常
	String bus_fail_suffix = "_bus_fail";
	//系统异常次数后缀
	String sys_fail_count_suffix = sys_fail_suffix + "_count";
	//异步异常次数后缀
	String bus_fail_count_suffix = bus_fail_suffix + "_count";
	//执行次数后缀
	String invoke_count_suffix = "_invoke_count";
	//延时后缀
	String time_suffix = "_time";
	//成功埋点后缀
	String success_suffix = "_success";


}
