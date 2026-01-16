package Object_Oriented_Programming.Keywords.Level1;

import java.util.Scanner;

public class Product {

    /* ---------- STATIC ---------- */
    static double discount = 10.0;   // shared discount percentage

    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("Updated Discount: " + discount + "%");
    }

    /* ---------- INSTANCE VARIABLES ---------- */
    String productName;
    final int productID;            // FINAL: cannot be changed
    double price;
    int quantity;

    /* ---------- CONSTRUCTOR (THIS) ---------- */
    Product(String productName, int productID, double price, int quantity) {
        this.productName = productName;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
    }

    /* ---------- METHOD WITH INSTANCEOF ---------- */
    void processProduct(Object obj) {

        if (obj instanceof Product) {
            double total = price * quantity;
            double discountAmount = total * (discount / 100);
            double finalPrice = total - discountAmount;

            System.out.println("\n--- Product Details ---");
            System.out.println("Product ID   : " + productID);
            System.out.println("Product Name : " + productName);
            System.out.println("Price        : " + price);
            System.out.println("Quantity     : " + quantity);
            System.out.println("Discount     : " + discount + "%");
            System.out.println("Final Price  : " + finalPrice);
        } else {
            System.out.println("Object is not a Product");
        }
    }

    /* ---------- MAIN METHOD (SAME FILE) ---------- */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        // Update discount (static method)
        Product.updateDiscount(15.0);

        // Create Product object
        Product product = new Product(name, id, price, qty);

        // Validate using instanceof and process product
        product.processProduct(product);

        sc.close();
    }
}
