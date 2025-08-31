package assignment3_1.three;

import java.util.ArrayList;
import java.util.Arrays;

class Shape {

    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public double calculateArea() {
        return 0;
    }


    public String getColor() {
        return this.color;
    }
}

class Circle extends Shape {

    private double radius;

    public Circle(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public String toString() {
        return String.format("Area of Circle with radius %.1f: %f, Color: %s", this.radius, this.calculateArea(), getColor());
    }

    public double getRadius() {
        return radius;
    }
}

class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(double width, double height, String color) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("Area of Rectangle with width %.1f and height %.1f: %f, Color: %s",  this.width, this.height, this.calculateArea(), getColor());
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}

class Triangle extends Shape {

    private double base;
    private double height;

    public Triangle(double base, double height, String color) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("Area of Triangle with base %.1f and height %.1f: %f, Color: %s", this.base, this.height, this.calculateArea(), getColor());
    }

    @Override
    public double calculateArea() {
        return base * height * 0.5;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }
}

public class ShapeCalculator {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>(Arrays.asList(new Shape[]{new Circle(5, "Red"), new Rectangle(4, 6, "Green"), new Triangle(3, 8,  "Blue")}));

        System.out.println("Shape Calculator\n");

        for (Shape shape: shapes) {
            System.out.println(shape);
        }
    }
}


