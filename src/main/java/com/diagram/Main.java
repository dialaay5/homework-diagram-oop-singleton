package com.diagram;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

     Circle circle1 = new Circle(1.0);
     System.out.println(circle1);
     System.out.println("The perimeter of the circle = " + circle1.getPerimeter());
     System.out.println("The area of the circle = " + circle1.getArea());

     Rectangle rectangle1 = new Rectangle(1.0, 1.0);
        System.out.println(rectangle1);
        System.out.println("The perimeter of the rectangle = " + rectangle1.getPerimeter());
        System.out.println("The area of the rectangle = " + rectangle1.getArea());

        Resizeable resizeableCircle = new ResizaableCircle(5.0);
        resizeableCircle.resize(20);

        Resizeable resizeableRectangle = new ResizaableRectangle(2.0, 4.0);
        resizeableRectangle.resize(50);

    }
}