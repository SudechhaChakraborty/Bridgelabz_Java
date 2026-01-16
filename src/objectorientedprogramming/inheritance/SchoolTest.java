package Object_Oriented_Programming.Inheritance;

import java.util.Scanner;

public class SchoolTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Teacher Details");
        System.out.print("Name: ");
        String tName = sc.nextLine();

        System.out.print("Age: ");
        int tAge = sc.nextInt();
        sc.nextLine();

        System.out.print("Subject: ");
        String subject = sc.nextLine();

        Teacher teacher = new Teacher(tName, tAge, subject);

        System.out.println();
        teacher.displayRole();
        teacher.displayDetails();

        System.out.println("\n------------------\n");

        System.out.println("Enter Student Details");
        System.out.print("Name: ");
        String sName = sc.nextLine();

        System.out.print("Age: ");
        int sAge = sc.nextInt();
        sc.nextLine();

        System.out.print("Grade: ");
        String grade = sc.nextLine();

        Student student = new Student(sName, sAge, grade);

        System.out.println();
        student.displayRole();
        student.displayDetails();

        System.out.println("\n------------------\n");

        System.out.println("Enter Staff Details");
        System.out.print("Name: ");
        String stName = sc.nextLine();

        System.out.print("Age: ");
        int stAge = sc.nextInt();
        sc.nextLine();

        System.out.print("Department: ");
        String department = sc.nextLine();

        Staff staff = new Staff(stName, stAge, department);

        System.out.println();
        staff.displayRole();
        staff.displayDetails();

        sc.close();
    }
}

// Superclass
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Teacher subclass
class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    void displayRole() {
        System.out.println("Role: Teacher");
    }
}

// Student subclass
class Student extends Person {
    String grade;

    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    void displayRole() {
        System.out.println("Role: Student");
    }
}

// Staff subclass
class Staff extends Person {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    void displayRole() {
        System.out.println("Role: Staff");
    }
}
