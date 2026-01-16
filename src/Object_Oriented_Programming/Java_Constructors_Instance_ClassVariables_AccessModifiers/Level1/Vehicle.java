package Object_Oriented_Programming.Java_Constructors_Instance_ClassVariables_AccessModifiers.Level1;
/*
Problem 3: Vehicle Registration
Create a Vehicle class to manage the details of vehicles:
Instance Variables: ownerName, vehicleType.
Class Variable: registrationFee (fixed for all vehicles).
Methods:
An instance method displayVehicleDetails() to display owner and vehicle details.
A class method updateRegistrationFee() to change the registration fee.
*/


import java.util.Scanner;

class Vehicle {

    String ownerName;
    String vehicleType;
    static double registrationFee = 1000;

    Vehicle(String o, String v) {
        ownerName = o;
        vehicleType = v;
    }

    void displayVehicleDetails() {
        System.out.println(ownerName + " - " + vehicleType +
                " - Fee: " + registrationFee);
    }

    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter registration fee: ");
        double fee = sc.nextDouble();
        sc.nextLine(); // clear buffer
        Vehicle.updateRegistrationFee(fee);

        System.out.println("\nEnter details for Vehicle 1:");
        String owner1 = sc.nextLine();
        String type1 = sc.nextLine();

        System.out.println("Enter details for Vehicle 2:");
        String owner2 = sc.nextLine();
        String type2 = sc.nextLine();

        Vehicle v1 = new Vehicle(owner1, type1);
        Vehicle v2 = new Vehicle(owner2, type2);

        System.out.println("\nVehicle Details:");
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        sc.close();
    }
}
