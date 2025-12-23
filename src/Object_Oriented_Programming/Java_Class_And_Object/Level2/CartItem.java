package Object_Oriented_Programming.Java_Class_And_Object.Level2;
/*
Program to Simulate a Shopping Cart
Problem Statement: Create a CartItem class with attributes itemName, price, and quantity. Add methods to:
Add an item to the cart.
Remove an item from the cart.
Display the total cost.
Explanation: The CartItem class models a shopping cart item. The methods handle cart operations like adding or removing items and calculating the total cost.
*/


import java.util.Scanner;

class CartItem {

    String itemName;
    double price;
    int quantity;

    void addItem(String name, double p, int q) {
        itemName = name;
        price = p;
        quantity = q;
        System.out.println("Item added to cart.");
    }

    void removeItem(int removeQty) {
        if (removeQty <= quantity) {
            quantity = quantity - removeQty;
            System.out.println(removeQty + " item(s) removed from cart.");
        } else {
            System.out.println("Cannot remove more items than available.");
        }
    }

    void displayTotalCost() {
        double total = price * quantity;
        System.out.println("Remaining Quantity: " + quantity);
        System.out.println("Total Cost: " + total);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CartItem cart = new CartItem();

        System.out.print("Enter item name: ");
        String name = sc.nextLine();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        cart.addItem(name, price, quantity);
        cart.displayTotalCost();

        System.out.print("Do you want to remove the item? (yes/no): ");
        sc.nextLine(); // clear buffer
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("How many items do you want to remove?: ");
            int removeQty = sc.nextInt();
            cart.removeItem(removeQty);
            cart.displayTotalCost();
        } else {
            System.out.println("No items removed.");
        }
    }
}
