package com.kagura.desgin.装饰模式;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/7/24 17:57
 * @since 1.0.0
 */
public class WithMilk extends D{

    public WithMilk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1d;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", Milk";
    }

}
