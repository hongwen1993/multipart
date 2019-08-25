package com.consumer.event.impl;

import com.consumer.event.Notify;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/24 12:04
 * @since 1.0.0
 */
public class NotifyImpl implements Notify {
    @Override
    public void onreturn(String msg, Long id) {
        System.err.println(String.format("msg : %s; id : %d", msg, id));
    }

    @Override
    public void onthrow(Throwable ex, Long id) {
        System.err.println(ex);
        System.err.println(id);
    }

}
