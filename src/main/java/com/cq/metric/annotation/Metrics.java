package com.cq.metric.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * kcj
 * 2016年12月1日 下午6:56:32
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Metrics {

	/**
	 * metric名称，默认：包名.类名$方法名
	 * 业务异常:metric名称_bus_fail_count
	 * 系统异常:metric名称_sys_fail_count
	 * 成功数量:metric名称_success_count
	 * @return
	 */
	public String name() default "";

	/**
	 * 方法描述，默认：包名.类名$方法名
	 * @return
	 */
	public String desc() default "";

	/**
	 * 是否记录方法执行时间metric，默认记录
	 * @return
	 */
	public boolean recordTime() default true;

	/**
	 * 是否记录方法执行成功数量metric，默认记录
	 * @return
	 */
	public boolean recordSuccessCount() default true;

	/**
	 * 是否记录方法执行次数metric，默认记录
	 * @return
	 */
	public boolean recordInvokeCount() default true;

	/**
	 * 是否log打印方法入参(json格式，业务/系统异常强制打印)，默认不打印
	 * @return
	 */
	public boolean logInput() default false;

	/**
	 * 是否log打印方法返回值(json格式，业务/系统异常强制打印)，默认不打印
	 * @return
	 */
	public boolean logOutput() default false;

	/**
	 * 是否忽略业务异常，如果为true则业务异常将不抛出，默认抛出
	 * @return
	 */
	public boolean ignoreBusError() default false;

	/**
	 * 是否忽略系统异常，如果为true则系统异常将不抛出，默认抛出
	 * @return
	 */
	public boolean ignoreSysError() default false;

	/**
	 * 是否忽略所有异常，如果为true则任何异常都不抛出，默认抛出
	 * @return
	 */
	public boolean ignoreError() default false;

	/**
	 * 是否使用etrace的transaction
	 * @return
	 */
	EtraceTransaction[] trans() default {};
}
