package com.kagura.desgin.责任链模式;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/7/26 15:05
 * @since 1.0.0
 */
public class ZZClient {
    public static void main(String[] args) {
        JobChain jobChain = new JobChain(new Wash(), new JobChain(new Play(), null));
        jobChain.doChain();
    }
}
