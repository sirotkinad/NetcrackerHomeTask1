package com.mycompany.figures;

public class Circle {

    private double radius = 1.0;
    private String color = "red";

    public Circle(){

    }

    public Circle(double radius) {
        if (radius > 0)
            this.radius = radius;
        else
            throw new IllegalArgumentException("Radius can't be negative");
    }

    public Circle(double radius, String color) {
        this(radius);
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if(radius > 0)
            this.radius = radius;
        else
            throw new IllegalArgumentException("Radius can't be negative");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius = " + radius +
                ", color = '" + color + '\'' +
                '}';
    }

    public double getArea(){
        return Math.PI * getRadius() * getRadius();
    }
}
