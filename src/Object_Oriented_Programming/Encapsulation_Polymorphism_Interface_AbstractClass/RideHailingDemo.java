package Object_Oriented_Programming.Encapsulation_Polymorphism_Interface_AbstractClass;

import java.util.ArrayList;
import java.util.Scanner;

public class RideHailingDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<RideVehicle> rides = new ArrayList<>();

        System.out.print("Enter number of rides: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.println("\nRide " + (i + 1));
            System.out.print("Choose Vehicle Type (1-Car, 2-Bike, 3-Auto): ");
            int type = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Vehicle ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Driver Name: ");
            String driver = sc.nextLine();

            System.out.print("Enter Rate per Km: ");
            double rate = sc.nextDouble();

            RideVehicle v;

            if (type == 1) {
                v = new CarRide(id, driver, rate);
            } else if (type == 2) {
                v = new BikeRide(id, driver, rate);
            } else {
                v = new Auto(id, driver, rate);
            }

            rides.add(v);
        }

        System.out.print("\nEnter Distance (in km): ");
        double distance = sc.nextDouble();

        System.out.println("\n===== FARE DETAILS =====");
        for (RideVehicle v : rides) {
            calculateFareForRide(v, distance);
        }

        sc.close();
    }

    // Polymorphic method
    static void calculateFareForRide(RideVehicle v, double distance) {

        v.getVehicleDetails();
        double fare = v.calculateFare(distance);
        System.out.println("Distance: " + distance + " km");
        System.out.println("Total Fare: ₹" + fare);

        if (v instanceof GPS) {
            GPS g = (GPS) v;
            g.updateLocation("City Center");
            System.out.println("Current Location: " + g.getCurrentLocation());
        }

        System.out.println("------------------------");
    }
}

abstract class RideVehicle {

    // Encapsulation
    private int vehicleId;
    private String driverName;
    private double ratePerKm;

    RideVehicle(int vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Getters
    public int getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    // Concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: ₹" + ratePerKm);
    }

    // Abstract method
    public abstract double calculateFare(double distance);
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

class CarRide extends RideVehicle implements GPS {

    private String location = "Unknown";

    CarRide(int id, String driver, double rate) {
        super(id, driver, rate);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 50; // base charge
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String location) {
        this.location = location;
    }
}

class BikeRide extends RideVehicle implements GPS {

    private String location = "Unknown";

    BikeRide(int id, String driver, double rate) {
        super(id, driver, rate);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String location) {
        this.location = location;
    }
}

class Auto extends RideVehicle implements GPS {

    private String location = "Unknown";

    Auto(int id, String driver, double rate) {
        super(id, driver, rate);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 20;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String location) {
        this.location = location;
    }
}
