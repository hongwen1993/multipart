package com.kagura.desgin.责任链模式;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/7/26 15:05
 * @since 1.0.0
 */
public class Play implements Job{
    @Override
    public void process() {
        System.err.println("Play");
    }
}
