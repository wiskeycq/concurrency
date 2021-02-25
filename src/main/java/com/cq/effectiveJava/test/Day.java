package com.cq.effectiveJava.test;

/**
 * @author caoqiang
 * @date 2019/12/2上午10:42
 */
public enum Day{
    MONDAY(1, "星期一"),
    TUESDAY(2, "星期二"),
    WEDNESDAY(3, "星期三");

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    Day(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
