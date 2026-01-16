package Object_Oriented_Programming.Keywords.Level1;

import java.util.Scanner;

public class Vehicle {

    /* ---------- STATIC ---------- */
    static double registrationFee = 1500.0;   // common for all vehicles

    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Updated Registration Fee: " + registrationFee);
    }

    /* ---------- INSTANCE VARIABLES ---------- */
    String ownerName;
    String vehicleType;
    final String registrationNumber;    // FINAL: cannot be changed

    /* ---------- CONSTRUCTOR (THIS) ---------- */
    Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    /* ---------- METHOD WITH INSTANCEOF ---------- */
    void displayRegistrationDetails(Object obj) {

        if (obj instanceof Vehicle) {
            System.out.println("\n--- Vehicle Registration Details ---");
            System.out.println("Owner Name          : " + ownerName);
            System.out.println("Vehicle Type        : " + vehicleType);
            System.out.println("Registration Number : " + registrationNumber);
            System.out.println("Registration Fee    : " + registrationFee);
        } else {
            System.out.println("Object is not a Vehicle");
        }
    }

    /* ---------- MAIN METHOD (SAME FILE) ---------- */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Owner Name: ");
        String owner = sc.nextLine();

        System.out.print("Enter Vehicle Type: ");
        String type = sc.nextLine();

        System.out.print("Enter Registration Number: ");
        String regNo = sc.nextLine();

        // Update registration fee (static method)
        Vehicle.updateRegistrationFee(2000.0);

        // Create Vehicle object
        Vehicle vehicle = new Vehicle(owner, type, regNo);

        // Validate using instanceof and display details
        vehicle.displayRegistrationDetails(vehicle);

        sc.close();
    }
}
