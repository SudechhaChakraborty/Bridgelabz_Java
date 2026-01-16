package Object_Oriented_Programming.Java_Class_And_Object.Level2;
/*
Program to Simulate Student Report
Problem Statement: Create a Student class with attributes name, rollNumber, and marks. Add two methods:
To calculate the grade based on the marks.
To display the student's details and grade.
Explanation: The Student class organizes all relevant details about a student as attributes. Methods are used to calculate the grade and provide a way to display all information.
*/

import java.util.Scanner;

class Student {

    String name;
    int rollNumber;
    int marks;

    char calculateGrade() {
        if (marks >= 90)
            return 'A';
        else if (marks >= 75)
            return 'B';
        else if (marks >= 60)
            return 'C';
        else if (marks >= 40)
            return 'D';
        else
            return 'F';
    }

    void displayDetails() {
        System.out.println("\nStudent Report:");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Student s = new Student();

        System.out.print("Enter student name: ");
        s.name = sc.nextLine();

        System.out.print("Enter roll number: ");
        s.rollNumber = sc.nextInt();

        System.out.print("Enter marks: ");
        s.marks = sc.nextInt();

        s.displayDetails();
    }
}
