package Object_Oriented_Programming.Java_Class_And_Object.Level1;
/*

Program to Handle Mobile Phone Details
Problem Statement: Create a MobilePhone class with attributes brand, model, and price. Add a method to display all the details of the phone. The MobilePhone class uses attributes to store the phone's characteristics. The method is used to retrieve and display this information for each object.
*/

import java.util.Scanner;

class MobilePhone {

    String brand;
    String model;
    double price;

    void displayDetails() {
        System.out.println("\nMobile Phone Details:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MobilePhone phone = new MobilePhone();

        System.out.print("Enter mobile brand: ");
        phone.brand = sc.nextLine();

        System.out.print("Enter mobile model: ");
        phone.model = sc.nextLine();

        System.out.print("Enter mobile price: ");
        phone.price = sc.nextDouble();

        phone.displayDetails();
    }
}
