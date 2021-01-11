package com.mycompany.figures;

import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0 &&
                color.equalsIgnoreCase(circle.color);
    }

    @Override
    public int hashCode() {
        int result = 17;
        long val = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (val ^ (val >>> 32));;
        result = 31 * result + color.hashCode();
        return result;
    }
}
