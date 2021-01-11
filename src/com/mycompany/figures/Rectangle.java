package com.mycompany.figures;

import java.util.Objects;

public class Rectangle {

    private float length = 1.0f;
    private float width = 1.0f;

    public Rectangle(){
    }

    public Rectangle(float length, float width) {
        if(length > 0 && width > 0) {
            this.length = length;
            this.width = width;
        }
       throw new IllegalArgumentException("Sides can't be negative");
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        if(length > 0)
            this.length = length;
        else
            throw new IllegalArgumentException("Length can't be negative");

    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        if(width > 0)
           this.width = width;
        else
            throw new IllegalArgumentException("Length can't be negative");
    }

    public double getArea(){
        return getLength() * getWidth();
    }

    public double getPerimeter(){
        return 2 * (getLength() + getWidth());
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length = " + length +
                ", width = " + width +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Float.compare(rectangle.length, length) == 0 &&
                Float.compare(rectangle.width, width) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Float.floatToIntBits(length);
        result = 31 * result + Float.floatToIntBits(width);
        return result;
    }
}
