package Object_Oriented_Programming.Java_Constructors_Instance_ClassVariables_AccessModifiers.Level1;
/*
Write a Circle class with a radius attribute. Use constructor chaining to initialize radius with default and user-provided values.
 */

import java.util.Scanner;

class Circle {

    double radius;

    Circle() {
        this(1.0);   // constructor chaining
    }

    Circle(double r) {
        radius = r;
    }

    void display() {
        System.out.println("Radius of the circle: " + radius);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Circle c1 = new Circle();
        System.out.println("Using default constructor:");
        c1.display();

        System.out.print("\nEnter radius: ");
        double r = sc.nextDouble();

        Circle c2 = new Circle(r);
        System.out.println("Using parameterized constructor:");
        c2.display();

        sc.close();
    }
}
