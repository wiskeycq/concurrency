package com.cq.effectiveJava.test;

import java.util.Date;
import java.util.Map;

/**
 * @author caoqiang
 * @Description:
 * @date 2019/4/14上午11:29
 */
public class TestOrder {
    public static void main(String[] args) {
        OrderList newOrder = new OrderList();
        newOrder.setId(new Long(1));
        newOrder.setName("cq");
        newOrder.setDate(new Date());
        OrderList oldOrder = new OrderList();
        oldOrder.setId(new Long(1));
        oldOrder.setName("cq1");
        oldOrder.setDate(DateTimeUtil.getByString("2019-09-04 12:00:00"));
        Map<String, String> mapMap = ClassCompareUtil.compareFields(newOrder, oldOrder);
        System.out.println(mapMap.size());
        System.out.println(mapMap);
    }
}
