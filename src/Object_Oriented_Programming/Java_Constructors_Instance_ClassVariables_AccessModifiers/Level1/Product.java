package Object_Oriented_Programming.Java_Constructors_Instance_ClassVariables_AccessModifiers.Level1;
/*
Problem 1: Product Inventory
Create a Product class with:
Instance Variables: productName, price.
Class Variable: totalProducts (shared among all products).
Methods:
An instance method displayProductDetails() to display the details of a product.
A class method displayTotalProducts() to show the total number of products created.
*/

import java.util.Scanner;

class Product {

    // Instance variables
    String productName;
    double price;

    // Class variable
    static int totalProducts = 0;

    // Constructor
    Product(String name, double p) {
        productName = name;
        price = p;
        totalProducts++;
    }

    // Instance method
    void displayProductDetails() {
        System.out.println("Product Name : " + productName);
        System.out.println("Price        : " + price);
        System.out.println();
    }

    // Class method
    static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        Product[] products = new Product[n];

        // Taking input from user
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for product " + (i + 1));

            System.out.print("Product Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();
            sc.nextLine(); // clear buffer

            products[i] = new Product(name, price);
        }

        // Display product details
        System.out.println("\n--- Product Details ---");
        for (int i = 0; i < n; i++) {
            products[i].displayProductDetails();
        }

        // Display total products
        Product.displayTotalProducts();

        sc.close();
    }
}
