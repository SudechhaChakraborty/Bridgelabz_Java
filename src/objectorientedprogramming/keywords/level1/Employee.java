package Object_Oriented_Programming.Keywords.Level1;


import java.util.Scanner;

public class Employee {

    /* ---------- STATIC ---------- */
    static String companyName = "TechNova Solutions";
    static int totalEmployees = 0;

    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    /* ---------- INSTANCE VARIABLES ---------- */
    String name;
    final int id;              // FINAL: cannot be modified
    String designation;

    /* ---------- CONSTRUCTOR (THIS) ---------- */
    Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;     // count employees
    }

    /* ---------- METHOD WITH INSTANCEOF ---------- */
    void displayDetails(Object obj) {

        if (obj instanceof Employee) {
            System.out.println("\n--- Employee Details ---");
            System.out.println("Company     : " + companyName);
            System.out.println("Name        : " + name);
            System.out.println("Employee ID : " + id);
            System.out.println("Designation : " + designation);
        } else {
            System.out.println("Object is not an Employee");
        }
    }

    /* ---------- MAIN METHOD (SAME FILE) ---------- */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Designation: ");
        String designation = sc.nextLine();

        // Create Employee object
        Employee emp = new Employee(name, id, designation);

        // Display employee details using instanceof
        emp.displayDetails(emp);

        // Display total employees (static)
        Employee.displayTotalEmployees();

        sc.close();
    }
}
