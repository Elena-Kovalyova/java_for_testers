package ru.stqa.triangle;

import static java.lang.Math.sqrt;

public record Triangle (double side1, double side2, double side3) {

    public Triangle{
        if (side1 < 0 || side2 < 0 || side3 < 0) {
            throw new IllegalArgumentException("Triangle side should be non-negative");
        }
        if (side1+side2 < side3 || side3+side2 < side1 || side3+side1 < side2) {
            throw new IllegalArgumentException("Sum of two sides of triangle should be more than the third side");
        }
    }


      public static void main(String[] args) {
        printTriangleArea(new Triangle(5.0, 6.0, 7.0));
        printTrianglePerimeter(new Triangle (5.0, 6.0, 7.0));
                  }
    public static void printTrianglePerimeter(Triangle t){
        var text=String.format("Периметр треугольника со сторонами %f, %f и %f=%f", t.side1, t.side2, t.side3, t.trianglePerimeter());
        System.out.println(text);
    }


    static void printTriangleArea(Triangle t) {
        var text1=String.format("Площадь треугольника со сторонами  %f, %f и %f=%f", t.side1, t.side2, t.side3, t.triangleArea());
        System.out.println(text1);
    }

    public double trianglePerimeter() {
        return (this.side1+this.side2+this.side3);
    }

    public double triangleArea() {
        return sqrt(((trianglePerimeter()) / 2) * (((trianglePerimeter()) / 2) - this.side1) * (((trianglePerimeter()) / 2) - this.side2) * (((trianglePerimeter()) / 2) - this.side3));
    }
}

