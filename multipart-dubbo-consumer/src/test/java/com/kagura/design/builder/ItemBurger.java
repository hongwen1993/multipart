package com.kagura.design.builder;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/9/4 12:01
 * @since 1.0.0
 */
public abstract class ItemBurger implements Item {

    @Override
    public Packing packing() {
        return new PackingWrapper();
    }
}
