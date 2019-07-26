package com.kagura.desgin;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/7/25 18:02
 * @since 1.0.0
 */
public class Circle implements Shape{
    private Color color;

    public Circle(Color color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.err.println("Circle : " + color.getRed());
    }
}
