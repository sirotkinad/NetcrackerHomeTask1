package com.mycompany;

import java.util.Arrays;

public class MyPolynomial {

    private double[] coeffs;

    public MyPolynomial(double ... coeffs) {
        this.coeffs = new double[coeffs.length];
        for(int i = 0; i < this.coeffs.length; i++)
            this.coeffs[i] = coeffs[i];
    }

    int getDegree(){
        for(int i = coeffs.length - 1; i > 0; i--){
            if(coeffs[i] != 0)
                return i;
        }
        return 0;
    }


    @Override
    public String toString() {
        if(getDegree() == 0)
            return "" + coeffs[0];
        else if(getDegree() == 1 && coeffs[0] > 0)
            return coeffs[1] + "x" + "+" + coeffs[0];
        else if(getDegree() == 1 && coeffs[0] < 0)
            return coeffs[1] + "x" + "-" + coeffs[0];
        else if(getDegree() == 1 && coeffs[0] == 0)
            return coeffs[1] + "x";
        else {
            String polynomialStr = coeffs[getDegree()] + "x^" + getDegree();
            for (int i = getDegree() - 1; i > 0; i--) {
                if(coeffs[i] == 0)
                    continue;
                else if(i == 1 && coeffs[i] > 0)
                    polynomialStr += coeffs[i] + "x";
                else if(i == 1 && coeffs[i] < 0)
                    polynomialStr += coeffs[i] +"x";
                else if(coeffs[i] < 0)
                    polynomialStr += "-" + (-1*coeffs[i]) + "x^" + i;
                else
                    polynomialStr += "+" + coeffs[i] + "x^" + i;
            }
            if(coeffs[0] != 0 && coeffs[0] > 0)
                polynomialStr += "+" + coeffs[0];
            else if(coeffs[0] != 0 && coeffs[0] < 0)
                polynomialStr += "" + coeffs[0];
            return polynomialStr;
        }
    }

    public double evaluate(double x){
        double res = 0;
        for(int i = coeffs.length - 1; i >= 0;  i--){
           res += coeffs[i] * Math.pow(x, i);
        }
        return res;
    }

    public MyPolynomial add(MyPolynomial right){
        int resDegree = Math.max(getDegree(), right.getDegree());
        double[] sumCoeffs = new double[resDegree + 1];
        for(int i = right.getDegree(); i >=0; i--)
            sumCoeffs[i] += right.coeffs[i];
        for(int i = getDegree(); i >=0; i--)
            sumCoeffs[i] += coeffs[i];
        return new MyPolynomial(sumCoeffs);
    }

    public MyPolynomial multiply(MyPolynomial right){
        int resDegree = getDegree() + right.getDegree();
        double[] resCoeffs = new double[resDegree + 1];
        for(int i = getDegree(); i >= 0;  i--)
            for(int j = right.getDegree(); j >= 0; j--)
                resCoeffs[i + j] += coeffs[i] * right.coeffs[j];
        return new MyPolynomial(resCoeffs);
    }


}
