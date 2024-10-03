package com.example.task1_1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {
    private double side;
    private Color colorBorder;
    private double borderWidth;

    public Rectangle(
            Color color,
            Color colorBorder,
            double side,
            double borderWidth,
            double x,
            double y) {
        super(color);
        this.side = side;
        this.colorBorder = colorBorder;
        this.borderWidth = borderWidth;
        this.x = x;
        this.y = y;
    }

    @Override
    double area() {
        return side * side;
    }

    @Override
    void draw(GraphicsContext gr) {
        gr.setFill(color);
        gr.fillRect(x, y, side, side);
        gr.setStroke(colorBorder);
        gr.setLineWidth(borderWidth);
        gr.strokeRect(x, y, side, side);
    }

    @Override
    public String toString() {
        return "Rectangle color is " + super.color + " and area is : " + area();
    }

}
