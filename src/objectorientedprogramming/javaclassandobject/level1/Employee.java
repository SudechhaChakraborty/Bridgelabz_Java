package Object_Oriented_Programming.Java_Class_And_Object.Level1;
/*
Program to Display Employee Details
Problem Statement: Write a program to create an Employee class with attributes name, id, and salary. Add a method to display the details.
*/

import java.util.Scanner;

class Employee {

    String name;
    int id;
    double salary;

    void displayDetails() {
        System.out.println("\nEmployee Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Employee emp = new Employee();

        System.out.print("Enter employee name: ");
        emp.name = sc.nextLine();

        System.out.print("Enter employee id: ");
        emp.id = sc.nextInt();

        System.out.print("Enter employee salary: ");
        emp.salary = sc.nextDouble();

        emp.displayDetails();
    }
}
