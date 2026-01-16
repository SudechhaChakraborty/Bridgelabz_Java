package Object_Oriented_Programming.Java_Constructors_Instance_ClassVariables_AccessModifiers.Level1;
/*
Library Book System: Create a Book class with attributes title, author, price, and availability. Implement a method to borrow a book.

 */

import java.util.Scanner;

class Library {

    String title;
    String author;
    double price;
    boolean available;

    Library(String t, String a, double p) {
        title = t;
        author = a;
        price = p;
        available = true;   // book is available initially
    }

    void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Sorry, book is already borrowed.");
        }
    }

    void display() {
        System.out.println("\nBook Details:");
        System.out.println("Title     : " + title);
        System.out.println("Author    : " + author);
        System.out.println("Price     : " + price);
        System.out.println("Available : " + available);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.print("Enter book title: ");
        String title = sc.nextLine();

        System.out.print("Enter author name: ");
        String author = sc.nextLine();

        System.out.print("Enter book price: ");
        double price = sc.nextDouble();

        Library book = new Library(title, author, price);

        book.display();

        System.out.println("\nTrying to borrow the book...");
        book.borrowBook();

        book.display();

        sc.close();
    }
}
