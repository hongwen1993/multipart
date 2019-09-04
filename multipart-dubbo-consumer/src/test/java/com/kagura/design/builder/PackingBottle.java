package com.kagura.design.builder;

/**
 * 瓶子
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/9/4 11:50
 * @since 1.0.0
 */
public class PackingBottle implements Packing {
    @Override
    public String pack() {
        return "Bottle Packing";
    }
}
