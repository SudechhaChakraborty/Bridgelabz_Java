package Object_Oriented_Programming.Encapsulation_Polymorphism_Interface_AbstractClass;

import java.util.ArrayList;
import java.util.Scanner;

public class FoodDeliveryDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<FoodItem> order = new ArrayList<>();

        System.out.print("Enter number of food items: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.println("\nFood Item " + (i + 1));
            System.out.print("Choose Type (1-Veg, 2-Non-Veg): ");
            int type = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Item Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();

            System.out.print("Enter Quantity: ");
            int qty = sc.nextInt();

            FoodItem item;

            if (type == 1) {
                item = new VegItem(name, price, qty);
            } else {
                item = new NonVegItem(name, price, qty);
            }

            order.add(item);
        }

        System.out.println("\n===== ORDER SUMMARY =====");
        processOrder(order);

        sc.close();
    }

    // Polymorphic order processing
    static void processOrder(ArrayList<FoodItem> order) {

        double grandTotal = 0;

        for (FoodItem item : order) {

            item.getItemDetails();
            double total = item.calculateTotalPrice();

            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                total = d.applyDiscount(total);
                System.out.println("Discount: " + d.getDiscountDetails());
            }

            System.out.println("Final Price: ₹" + total);
            System.out.println("-------------------------");

            grandTotal += total;
        }

        System.out.println("Grand Total: ₹" + grandTotal);
    }
}

abstract class FoodItem {

    // Encapsulation
    private String itemName;
    private double price;
    private int quantity;

    FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters only
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: ₹" + price);
        System.out.println("Quantity: " + quantity);
    }

    // Abstract method
    public abstract double calculateTotalPrice();
}

interface Discountable {
    double applyDiscount(double amount);
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {

    VegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    public double applyDiscount(double amount) {
        return amount - (amount * 0.10); // 10% discount
    }

    public String getDiscountDetails() {
        return "10% Veg Discount";
    }
}

class NonVegItem extends FoodItem {

    NonVegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    public double calculateTotalPrice() {
        double base = getPrice() * getQuantity();
        return base + (base * 0.05); // 5% extra charge
    }
}
