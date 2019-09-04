package com.kagura.design.builder;

/**
 * 物品 - 食物/食物包装/食物价格/食物描述
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/9/4 11:46
 * @since 1.0.0
 */
public interface Item {
    String name();
    // 使用桥接模式分离Packing
    Packing packing();
    float price();
}
