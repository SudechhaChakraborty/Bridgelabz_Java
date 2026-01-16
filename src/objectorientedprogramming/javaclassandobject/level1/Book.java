package Object_Oriented_Programming.Java_Class_And_Object.Level1;
/*
Program to Handle Book Details
Problem Statement: Write a program to create a Book class with attributes title, author, and price. Add a method to display the book details.
*/

import java.util.Scanner;

class Book {

    String title;
    String author;
    double price;

    void displayDetails() {
        System.out.println("\nBook Details:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Book b = new Book();

        System.out.print("Enter book title: ");
        b.title = sc.nextLine();

        System.out.print("Enter author name: ");
        b.author = sc.nextLine();

        System.out.print("Enter book price: ");
        b.price = sc.nextDouble();

        b.displayDetails();
    }
}
