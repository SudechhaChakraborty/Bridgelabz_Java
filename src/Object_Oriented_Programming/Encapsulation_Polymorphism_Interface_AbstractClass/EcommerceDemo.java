package Object_Oriented_Programming.Encapsulation_Polymorphism_Interface_AbstractClass;

import java.util.ArrayList;
import java.util.Scanner;


public class EcommerceDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.println("\nProduct " + (i + 1));
            System.out.print("Choose Type (1-Electronics, 2-Clothing, 3-Groceries): ");
            int type = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Product ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Product Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();

            Product p;

            if (type == 1) {
                p = new Electronics(id, name, price);
            } else if (type == 2) {
                p = new Clothing(id, name, price);
            } else {
                p = new Groceries(id, name, price);
            }

            products.add(p);
        }

        System.out.println("\n===== FINAL PRICE DETAILS =====");
        for (Product p : products) {
            printFinalPrice(p);
        }

        sc.close();
    }

    // Polymorphic method
    static void printFinalPrice(Product p) {

        double tax = 0;

        if (p instanceof Taxable) {
            tax = ((Taxable) p).calculateTax();
        }

        double discount = p.calculateDiscount();
        double finalPrice = p.getPrice() + tax - discount;

        p.displayDetails();
        System.out.println("Tax: ₹" + tax);
        System.out.println("Discount: ₹" + discount);
        System.out.println("Final Price: ₹" + finalPrice);
        System.out.println("------------------------------");
    }
}

abstract class Product {

    private int productId;
    private String name;
    private double price;

    Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Encapsulation Getters and Setters
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Concrete method
    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: ₹" + price);
    }

    // Abstract method
    public abstract double calculateDiscount();
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {

    Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    public double calculateTax() {
        return getPrice() * 0.18; // 18% tax
    }

    public String getTaxDetails() {
        return "18% GST";
    }
}

class Clothing extends Product implements Taxable {

    Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.20; // 20% discount
    }

    public double calculateTax() {
        return getPrice() * 0.05; // 5% tax
    }

    public String getTaxDetails() {
        return "5% GST";
    }
}

class Groceries extends Product {

    Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}
