package com.cq.example.singleton;

/**
 * @author caoqiang
 * @Description:
 * @date 2019/8/11上午8:24
 */
public class Something {
    private static volatile Something instance = null;

    private Something() {}

    public Something getInstance() {
        if (instance == null) {
            synchronized (new Object()) {
                if (instance == null) {
                    instance = new Something();
                }
            }
        }
        return instance;
    }
}
