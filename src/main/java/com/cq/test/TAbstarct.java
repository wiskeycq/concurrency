package com.cq.test;

/**
 * @author caoqiang
 * @date 2020/8/27下午2:57
 */
public abstract class TAbstarct<T> {

    protected abstract void specialValidate(T param, boolean skipValidate);

    protected abstract void handleShippingOrder(T param);

    protected abstract void sendMessage(T param);

    public boolean process(T param)  {
        return process(param, false);
    }

    public boolean process(T param, boolean skipValidate)  {
        return doProcess(param, skipValidate);
    }


    protected void rollbackMain(T param) {

    }

    private boolean doProcess(T param, boolean skipValidate) {

        //特殊校验
        specialValidate(param, skipValidate);

        //操作运单
        handleShippingOrder(param);
        //发送消息
        sendMessage(param);
        return true;
    }


}
