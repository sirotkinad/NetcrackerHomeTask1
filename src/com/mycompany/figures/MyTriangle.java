package com.mycompany.figures;

import java.util.Objects;

public class MyTriangle {

    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;



    public MyTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
       MyPoint point1 = new MyPoint(x1, y1);
       MyPoint point2 = new MyPoint(x2, y2);
       MyPoint point3 = new MyPoint(x3, y3);
       if(isCorrectTriangle(point1, point2, point3)) {
           v1 = point1;
           v2 = point2;
           v3 = point3;
       }
       else
           throw new IllegalArgumentException("Check points are correct to form a triangle");
    }

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        if(v1 != null && v2 != null && v3 != null && isCorrectTriangle(v1, v2, v3)) {
            this.v1 = v1;
            this.v2 = v2;
            this.v3 = v3;
        }
        else
            throw new IllegalArgumentException("Check points are not null and are correct to form a triangle");
    }



    public static boolean isCorrectTriangle(MyPoint v1, MyPoint v2, MyPoint v3){
        return (v1.distance(v2) + v1.distance(v3) > v2.distance(v3)
                && v1.distance(v2) + v2.distance(v3) > v1.distance(v3)
                && v1.distance(v3) + v2.distance(v3) > v1.distance(v2));
    }


    public double getPerimeter() {
        return v1.distance(v2) + v1.distance(v3) + v2.distance(v3);
    }

    @Override
    public String toString() {
        return "MyTriangle{" +
                "v1=" + v1.toString() +
                ", v2=" + v2.toString() +
                ", v3=" + v3.toString() +
                '}';
    }


    public TriangleType getType() {
            if (Double.compare(v1.distance(v2), v1.distance(v3)) == 0 && Double.compare(v1.distance(v3), v2.distance(v3)) == 0)
                return TriangleType.Equilateral;
            else if (Double.compare(v1.distance(v2), v1.distance(v3)) == 0 || Double.compare(v1.distance(v3), v2.distance(v3)) == 0
                    || Double.compare(v1.distance(v2), v2.distance(v3)) == 0)
                return TriangleType.Isosceles;
            else
                return TriangleType.Scalene;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTriangle that = (MyTriangle) o;
        return v1.equals(that.v1) &&
                v2.equals(that.v2) &&
                v3.equals(that.v3);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + v1.hashCode();
        result = 31 * result + v2.hashCode();
        result = 31 * result + v3.hashCode();
        return result;
    }
}
