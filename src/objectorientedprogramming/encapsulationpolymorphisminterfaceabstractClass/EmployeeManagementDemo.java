package Object_Oriented_Programming.Encapsulation_Polymorphism_Interface_AbstractClass;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.println("\nEmployee " + (i + 1));
            System.out.print("Enter Employee Type (1-FullTime, 2-PartTime): ");
            int type = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Base Salary: ");
            double baseSalary = sc.nextDouble();

            Employee emp;

            if (type == 1) {

                emp = new FullTimeEmployee(id, name, baseSalary);
            } else {

                System.out.print("Enter Hours Worked: ");
                int hours = sc.nextInt();
                emp = new PartTimeEmployee(id, name, baseSalary, hours);
            }

            sc.nextLine();
            System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            emp.assignDepartment(dept);
            employees.add(emp);
        }

        System.out.println("\n===== EMPLOYEE DETAILS =====");
        for (Employee e : employees) {
            e.displayDetails();
            System.out.println("Calculated Salary: ₹" + e.calculateSalary());
            System.out.println("Department: " + e.getDepartmentDetails());
            System.out.println("----------------------------");
        }

        sc.close();
    }
}

abstract class Employee implements Department {

    // Encapsulation
    private int employeeId;
    private String name;
    private double baseSalary;

    Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Getters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    // Setter
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // Concrete method
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: ₹" + baseSalary);
    }

    // Abstract method
    public abstract double calculateSalary();
}

interface Department {
    void assignDepartment(String dept);
    String getDepartmentDetails();
}

class FullTimeEmployee extends Employee {

    private String department;

    FullTimeEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    public double calculateSalary() {
        return getBaseSalary(); // fixed salary
    }

    public void assignDepartment(String dept) {
        this.department = dept;
    }

    public String getDepartmentDetails() {
        return department;
    }
}

class PartTimeEmployee extends Employee {

    private int hoursWorked;
    private String department;

    PartTimeEmployee(int id, String name, double hourlyRate, int hoursWorked) {
        super(id, name, hourlyRate);
        this.hoursWorked = hoursWorked;
    }

    public double calculateSalary() {
        return getBaseSalary() * hoursWorked;
    }

    public void assignDepartment(String dept) {
        this.department = dept;
    }

    public String getDepartmentDetails() {
        return department;
    }
}
