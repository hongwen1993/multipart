package com.kagura.design.builder;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/9/4 13:51
 * @since 1.0.0
 */
public class MealBuilder {

    public static Meal builderVegCoffee() {
        Meal meal = new Meal();
        meal.addItem(new ItemBurgerVeg());
        meal.addItem(new ItemColdDrinkCoffee());
        return meal;
    }

    public static Meal builderChickenCoffee() {
        Meal meal = new Meal();
        meal.addItem(new ItemBurgerChicken());
        meal.addItem(new ItemColdDrinkCoffee());
        return meal;
    }


    public static void main(String[] args) {
        Meal vegCoffeeMeal = MealBuilder.builderVegCoffee();
        System.err.println(String.format("VegCoffee Cost %f", vegCoffeeMeal.getCost()));
        Meal chickenCoffeeMeal = MealBuilder.builderChickenCoffee();
        System.err.println(String.format("chickenCoffee Cost %f", chickenCoffeeMeal.getCost()));
    }

}
