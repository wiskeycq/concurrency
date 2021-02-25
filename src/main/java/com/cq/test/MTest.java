package com.cq.test;

/**
 * @author caoqiang
 * @date 2020/8/27下午3:02
 */
public class MTest extends TAbstarct<String> {

    @Override
    protected void specialValidate(String param, boolean skipValidate) {
        System.out.println("specialValidate "+param);
    }

    @Override
    protected void handleShippingOrder(String param) {
        System.out.println("handleShippingOrder "+param);
    }

    @Override
    protected void sendMessage(String param) {
        System.out.println("sendMessage "+param);
    }

    public static void main(String[] args) {
        MTest mTest = new MTest();
        Boolean b = mTest.process("cq");
        System.out.println(b);
    }
}
