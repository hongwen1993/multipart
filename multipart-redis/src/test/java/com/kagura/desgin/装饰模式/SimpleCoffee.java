package com.kagura.desgin.装饰模式;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/7/24 17:55
 * @since 1.0.0
 */
public class SimpleCoffee implements Coffee{

    @Override
    public double getCost() {
        return 1;
    }

    @Override
    public String getIngredients() {
        return "Coffee";
    }
}
