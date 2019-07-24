package com.kagura.desgin.装饰模式;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/7/24 18:47
 * @since 1.0.0
 */
public abstract class D implements Coffee {
    private Coffee coffee;

    public D(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }

    @Override
    public String getIngredients() {
        return null;
    }
}
