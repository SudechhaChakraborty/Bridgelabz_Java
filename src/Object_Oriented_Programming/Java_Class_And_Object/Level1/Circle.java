package Object_Oriented_Programming.Java_Class_And_Object.Level1;
/*
Program to Compute Area of a Circle
Problem Statement: Write a program to create a Circle class with an attribute radius. Add methods to calculate and display the area and circumference of the circle.
*/

import java.util.Scanner;

class Circle {

    double radius;

    void calculateAndDisplay() {
        double area = 3.14 * radius * radius;
        double circumference = 2 * 3.14 * radius;

        System.out.println("\nCircle Details:");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + area);
        System.out.println("Circumference: " + circumference);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Circle c = new Circle();

        System.out.print("Enter radius of the circle: ");
        c.radius = sc.nextDouble();

        c.calculateAndDisplay();
    }
}
