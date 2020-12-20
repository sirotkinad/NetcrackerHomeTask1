package com.mycompany;

public class MyComplex {

    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex() {
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        if(this.imag == 0){
            return String.valueOf(real);
        }
        else if(real == 0){
            return imag + "i";
        }
        else if(imag < 0){
            return "(" + real + imag + "i" + ")";
        }
        else
            return "(" + real + "+" + imag + "i" + ")";
    }

    public boolean isReal() {
        return imag == 0;
    }

    public boolean isImaginary() {
        return real == 0;
    }

    public boolean equals(double real, double imag) {
        return (Double.compare(this.real, real) == 0 && Double.compare(this.imag, imag) == 0) ;
    }

    public boolean equals(MyComplex another) {
        return (Double.compare(real, another.getReal()) == 0 && Double.compare(imag, another.getImag()) == 0);
    }

    public double magnitude(){
        return Math.sqrt(real * real + imag * imag);
    }

    public double argument(){
        return Math.atan2(imag, real);
    }

    public MyComplex add (MyComplex right){
        this.setValue(real + right.getReal(), imag + right.getImag());
        return this;
    }

    public MyComplex subtract (MyComplex right){
        this.setValue(real - right.getReal(), imag - right.getImag());
        return this;
    }

    public MyComplex addNew (MyComplex right){
         return new MyComplex(real + right.getReal(), imag + right.getImag());
    }

    public MyComplex subtractNew (MyComplex right){
        return new MyComplex(real - right.getReal(), imag - right.getImag());
    }

    public MyComplex multiple (MyComplex right){
        this.setValue(real * right.getReal() - imag * right.getImag(), real * right.getImag() + imag * right.getReal());
        return this;
    }

    public MyComplex divide (MyComplex right){
        if(right.magnitude() == 0)
            throw new ArithmeticException("Error: division on zero");
        else {
            double tempReal = (real * right.getReal() + imag * right.getImag()) / (Math.pow(right.magnitude(), 2));
            double tempImag = (imag * right.getReal() - real * right.getImag()) / (Math.pow(right.magnitude(), 2));
            this.setValue(tempReal, tempImag);
            return this;
        }
    }

    public MyComplex conjugate(){
        this.setImag(-1 * imag);
        return this;
    }

}
