package com.kagura.design.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/9/4 13:48
 * @since 1.0.0
 */
public class Meal {
    private List<Item> items = new ArrayList<>(16);

    public List<Item> addItem(Item item) {
        items.add(item);
        return items;
    }

    public float getCost() {
        float price = 0F;
        for (Item item : items) {
            price += item.price();
        }
        return price;
    }
}
