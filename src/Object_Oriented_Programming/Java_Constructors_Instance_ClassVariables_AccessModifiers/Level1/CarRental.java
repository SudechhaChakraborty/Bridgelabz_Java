package Object_Oriented_Programming.Java_Constructors_Instance_ClassVariables_AccessModifiers.Level1;
/*
Car Rental System: Create a CarRental class with attributes customerName, carModel, and rentalDays. Add constructors to initialize the rental details and calculate total cost.
 */

import java.util.Scanner;

class CarRental {

    String customerName;
    String carModel;
    int rentalDays;
    double totalCost;

    CarRental() {
        customerName = "Customer";
        carModel = "Basic";
        rentalDays = 1;
        totalCost = rentalDays * 1000;   // default cost per day
    }

    CarRental(String c, String m, int d) {
        customerName = c;
        carModel = m;
        rentalDays = d;
        totalCost = rentalDays * 1000;   // cost per day
    }

    void display() {
        System.out.println("\nCar Rental Details:");
        System.out.println("Customer Name : " + customerName);
        System.out.println("Car Model     : " + carModel);
        System.out.println("Rental Days   : " + rentalDays);
        System.out.println("Total Cost    : ₹" + totalCost);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter car model: ");
        String model = sc.nextLine();

        System.out.print("Enter rental days: ");
        int days = sc.nextInt();

        CarRental rent = new CarRental(name, model, days);

        rent.display();

        sc.close();
    }
}
