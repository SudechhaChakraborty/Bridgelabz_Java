package Object_Oriented_Programming.Encapsulation_Polymorphism_Interface_AbstractClass;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<LibraryItem> items = new ArrayList<>();

        System.out.print("Enter number of library items: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.println("\nItem " + (i + 1));
            System.out.print("Choose Type (1-Book, 2-Magazine, 3-DVD): ");
            int type = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Item ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Author: ");
            String author = sc.nextLine();

            LibraryItem item;

            if (type == 1) {
                item = new Book(id, title, author);
            } else if (type == 2) {
                item = new Magazine(id, title, author);
            } else {
                item = new DVD(id, title, author);
            }

            items.add(item);
        }

        System.out.println("\n===== LIBRARY ITEM DETAILS =====");
        for (LibraryItem item : items) {

            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                Reservable r = (Reservable) item;
                r.reserveItem();
                System.out.println("Available: " + r.checkAvailability());
            }

            System.out.println("--------------------------------");
        }

        sc.close();
    }
}

abstract class LibraryItem {

    // Encapsulation
    private int itemId;
    private String title;
    private String author;

    LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Getters
    public int getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    // Abstract method
    public abstract int getLoanDuration();
}

interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {

    private boolean available = true;

    Book(int id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 14; // 14 days
    }

    public void reserveItem() {
        available = false;
        System.out.println("Book reserved successfully.");
    }

    public boolean checkAvailability() {
        return available;
    }
}

class Magazine extends LibraryItem {

    Magazine(int id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 7; // 7 days
    }
}

class DVD extends LibraryItem implements Reservable {

    private boolean available = true;

    DVD(int id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 3; // 3 days
    }

    public void reserveItem() {
        available = false;
        System.out.println("DVD reserved successfully.");
    }

    public boolean checkAvailability() {
        return available;
    }
}
