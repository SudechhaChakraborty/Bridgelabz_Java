package Object_Oriented_Programming.Keywords.Level1;

import java.util.Scanner;

public class Student {

    /* ---------- STATIC ---------- */
    static String universityName = "Global Tech University";
    static int totalStudents = 0;

    static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    /* ---------- INSTANCE VARIABLES ---------- */
    String name;
    final int rollNumber;     // FINAL: cannot be changed
    char grade;

    /* ---------- CONSTRUCTOR (THIS) ---------- */
    Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;      // count students
    }

    /* ---------- METHOD WITH INSTANCEOF ---------- */
    void manageStudent(Object obj, char newGrade) {

        if (obj instanceof Student) {
            System.out.println("\n--- Student Details ---");
            System.out.println("University : " + universityName);
            System.out.println("Name       : " + name);
            System.out.println("Roll No    : " + rollNumber);
            System.out.println("Grade      : " + grade);

            // Update grade
            grade = newGrade;
            System.out.println("Updated Grade: " + grade);
        } else {
            System.out.println("Object is not a Student");
        }
    }

    /* ---------- MAIN METHOD (SAME FILE) ---------- */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        System.out.print("Enter Grade: ");
        char grade = sc.next().charAt(0);

        // Create Student object
        Student student = new Student(name, roll, grade);

        // Validate using instanceof and manage student
        student.manageStudent(student, 'A');

        // Display total students (static)
        Student.displayTotalStudents();

        sc.close();
    }
}
