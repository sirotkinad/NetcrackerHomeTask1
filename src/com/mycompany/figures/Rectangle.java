package com.mycompany.figures;

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
}
