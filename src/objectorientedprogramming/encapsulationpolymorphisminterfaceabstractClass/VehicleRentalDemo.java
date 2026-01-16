package Object_Oriented_Programming.Encapsulation_Polymorphism_Interface_AbstractClass;

import java.util.ArrayList;
import java.util.Scanner;

public class VehicleRentalDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.println("\nVehicle " + (i + 1));
            System.out.print("Choose Type (1-Car, 2-Bike, 3-Truck): ");
            int type = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Vehicle Number: ");
            String number = sc.nextLine();

            System.out.print("Enter Rental Rate (per day): ");
            double rate = sc.nextDouble();

            Vehicle v;

            if (type == 1) {
                v = new Car(number, rate);
            } else if (type == 2) {
                v = new Bike(number, rate);
            } else {
                v = new Truck(number, rate);
            }

            vehicles.add(v);
        }

        System.out.print("\nEnter number of rental days: ");
        int days = sc.nextInt();

        System.out.println("\n===== RENTAL DETAILS =====");
        for (Vehicle v : vehicles) {
            printRentalDetails(v, days);
        }

        sc.close();
    }

    // Polymorphic method
    static void printRentalDetails(Vehicle v, int days) {

        double insurance = 0;

        if (v instanceof Insurable) {
            insurance = ((Insurable) v).calculateInsurance();
        }

        double rentalCost = v.calculateRentalCost(days);

        v.displayDetails();
        System.out.println("Rental Cost: ₹" + rentalCost);
        System.out.println("Insurance Cost: ₹" + insurance);
        System.out.println("Total Cost: ₹" + (rentalCost + insurance));
        System.out.println("--------------------------");
    }
}

abstract class Vehicle {

    private String vehicleNumber;
    private String type;
    private double rentalRate;

    Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Encapsulation (getters)
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    // Concrete method
    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rate per Day: ₹" + rentalRate);
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {

    private String insurancePolicyNumber = "CAR-INS-101"; // encapsulated

    Car(String number, double rate) {
        super(number, "Car", rate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 500; // fixed insurance
    }

    public String getInsuranceDetails() {
        return "Car Insurance";
    }
}

class Bike extends Vehicle {

    Bike(String number, double rate) {
        super(number, "Bike", rate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
}

class Truck extends Vehicle implements Insurable {

    private String insurancePolicyNumber = "TRK-INS-201"; // encapsulated

    Truck(String number, double rate) {
        super(number, "Truck", rate);
    }

    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) + 1000; // extra charge
    }

    public double calculateInsurance() {
        return 1000;
    }

    public String getInsuranceDetails() {
        return "Truck Insurance";
    }
}
