package Object_Oriented_Programming.Java_Class_And_Object.Level1;
/*
Program to Track Inventory of Items
Problem Statement: Create an Item class with attributes itemCode, itemName, and price. Add a method to display item details and calculate the total cost for a given quantity.
*/

import java.util.Scanner;

class Item {

    int itemCode;
    String itemName;
    double price;

    void displayDetails(int quantity) {
        double totalCost = price * quantity;

        System.out.println("\nItem Details:");
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per item: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + totalCost);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Item item = new Item();

        System.out.print("Enter item code: ");
        item.itemCode = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter item name: ");
        item.itemName = sc.nextLine();

        System.out.print("Enter price of item: ");
        item.price = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        item.displayDetails(quantity);
    }
}
