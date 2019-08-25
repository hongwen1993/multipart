package com.consumer.event;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/24 12:03
 * @since 1.0.0
 */
public interface Notify {

    public void onreturn(String msg, Long id);
    public void onthrow(Throwable ex, Long id);

}
