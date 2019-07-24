package com.kagura.desgin.装饰模式;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/7/24 18:00
 * @since 1.0.0
 */
public class ZZClient {
    public static void main(String[] args) {
        System.out.println(new WithSprinkles(new WithMilk(new SimpleCoffee())).getCost());
    }
}
