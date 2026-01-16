package Object_Oriented_Programming.Java_Constructors_Instance_ClassVariables_AccessModifiers.Level1;
/*

Problem 2: Online Course Management
Design a Course class with:
Instance Variables: courseName, duration, fee.
Class Variable: instituteName (common for all courses).
Methods:
An instance method displayCourseDetails() to display the course details.
A class method updateInstituteName() to modify the institute name for all courses.
*/

import java.util.Scanner;

class Course {

    String courseName;
    int duration;     // in months
    double fee;

    static String instituteName = "Default Institute";

    Course(String c, int d, double f) {
        courseName = c;
        duration = d;
        fee = f;
    }

    void displayCourseDetails() {
        System.out.println("Institute Name : " + instituteName);
        System.out.println("Course Name    : " + courseName);
        System.out.println("Duration       : " + duration + " months");
        System.out.println("Fee            : " + fee);
        System.out.println();
    }

    static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter institute name: ");
        String instName = sc.nextLine();
        Course.updateInstituteName(instName);

        System.out.print("Enter number of courses: ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        Course[] courses = new Course[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for course " + (i + 1));

            System.out.print("Course Name: ");
            String name = sc.nextLine();

            System.out.print("Duration (in months): ");
            int duration = sc.nextInt();

            System.out.print("Fee: ");
            double fee = sc.nextDouble();
            sc.nextLine(); // clear buffer

            courses[i] = new Course(name, duration, fee);
        }

        System.out.println("\n--- Course Details ---");
        for (int i = 0; i < n; i++) {
            courses[i].displayCourseDetails();
        }

        sc.close();
    }
}
