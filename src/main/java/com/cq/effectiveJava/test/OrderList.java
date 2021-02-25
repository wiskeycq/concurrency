package com.cq.effectiveJava.test;

import lombok.Data;

import java.util.Date;

/**
 * @author caoqiang
 * @Description:
 * @date 2019/4/14上午11:28
 */
@Data
public class OrderList {
    private Long  id;
    private String name;
    private Date date;

    public static void test (int mm) {
        switch (mm) {
            case 1 :
                System.out.println(11);

            case 2 :
                System.out.println(22);

            case 3 :
                System.out.println(33);

            default:
                break;

        }
    }

    public static void main(String[] args) {
        test(2);
    }
}
