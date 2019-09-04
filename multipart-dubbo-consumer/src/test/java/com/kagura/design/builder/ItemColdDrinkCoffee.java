package com.kagura.design.builder;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/9/4 13:47
 * @since 1.0.0
 */
public class ItemColdDrinkCoffee extends ItemColdDrink{
    @Override
    public String name() {
        return "Coffee ColdDrink ";
    }
    @Override
    public float price() {
        return 1.5F;
    }
}
