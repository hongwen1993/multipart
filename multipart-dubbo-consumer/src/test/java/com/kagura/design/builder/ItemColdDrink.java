package com.kagura.design.builder;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/9/4 13:38
 * @since 1.0.0
 */
public abstract class ItemColdDrink implements Item{

    @Override
    public Packing packing() {
        return new PackingBottle();
    }
}
