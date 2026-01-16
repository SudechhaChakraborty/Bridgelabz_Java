package Object_Oriented_Programming.Java_Constructors_Instance_ClassVariables_AccessModifiers.Level1;
/*
Problem 1: University Management System
Create a Student class with:
rollNumber (public).
name (protected).
CGPA (private).
Write methods to:
Access and modify CGPA using public methods.
Create a subclass PostgraduateStudent to demonstrate the use of protected members.
*/

import java.util.Scanner;

class Student {

    public int rollNumber;
    protected String name;
    private double cgpa;

    Student(int r, String n, double c) {
        rollNumber = r;
        name = n;
        cgpa = c;
    }

    // Getter
    public double getCGPA() {
        return cgpa;
    }

    // Setter
    public void setCGPA(double c) {
        cgpa = c;
    }
}

class PostgraduateStudent extends Student {

    PostgraduateStudent(int r, String n, double c) {
        super(r, n, c);
    }

    void display() {
        System.out.println("Roll No : " + rollNumber);
        System.out.println("Name    : " + name);
        System.out.println("CGPA    : " + getCGPA());
    }
}

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter CGPA: ");
        double cgpa = sc.nextDouble();

        PostgraduateStudent pg =
                new PostgraduateStudent(roll, name, cgpa);

        System.out.println("\nStudent Details:");
        pg.display();

        System.out.print("\nEnter new CGPA: ");
        double newCgpa = sc.nextDouble();
        pg.setCGPA(newCgpa);

        System.out.println("Updated CGPA: " + pg.getCGPA());

        sc.close();
    }
}
