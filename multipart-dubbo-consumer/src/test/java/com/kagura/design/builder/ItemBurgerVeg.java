package com.kagura.design.builder;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/9/4 13:45
 * @since 1.0.0
 */
public class ItemBurgerVeg extends ItemBurger{
    @Override
    public String name() {
        return "Veg Burger ";
    }
    @Override
    public float price() {
        return 0.5F;
    }
}
