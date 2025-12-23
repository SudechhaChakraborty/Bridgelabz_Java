package Object_Oriented_Programming.Java_Constructors_Instance_ClassVariables_AccessModifiers.Level1;
/*
Problem 4: Employee Records
Develop an Employee class with:
employeeID (public).
department (protected).
salary (private).
Write methods to:
Modify salary using a public method.
Create a subclass Manager to access employeeID and department.

*/

import java.util.Scanner;

class Employee {

    public int employeeID;
    protected String department;
    private double salary;

    Employee(int id, String dept, double sal) {
        employeeID = id;
        department = dept;
        salary = sal;
    }

    // Setter
    public void setSalary(double sal) {
        salary = sal;
    }

    // Getter
    public double getSalary() {
        return salary;
    }
}

// Subclass
class Manager extends Employee {

    Manager(int id, String dept, double sal) {
        super(id, dept, sal);
    }

    void displayDetails() {
        System.out.println("Employee ID : " + employeeID);   // public
        System.out.println("Department  : " + department);   // protected
        System.out.println("Salary      : " + getSalary());  // private via method
    }
}

class TestEmployee {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        System.out.print("Enter Salary: ");
        double sal = sc.nextDouble();

        Manager m = new Manager(id, dept, sal);

        System.out.println("\nEmployee Details:");
        m.displayDetails();

        System.out.print("\nEnter new Salary: ");
        double newSal = sc.nextDouble();
        m.setSalary(newSal);

        System.out.println("Updated Salary: " + m.getSalary());

        sc.close();
    }
}
