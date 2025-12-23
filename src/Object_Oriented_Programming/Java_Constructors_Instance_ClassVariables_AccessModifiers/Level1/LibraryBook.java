package Object_Oriented_Programming.Java_Constructors_Instance_ClassVariables_AccessModifiers.Level1;
/*
Problem 2: Book Library System
Design a Book class with:
ISBN (public).
title (protected).
author (private).
Write methods to:
Set and get the author name.
Create a subclass EBook to access ISBN and title and demonstrate access modifiers.
*/

import java.util.Scanner;

class LibraryBook {

    public String ISBN;
    protected String title;
    private String author;

    LibraryBook(String i, String t, String a) {
        ISBN = i;
        title = t;
        author = a;
    }

    // Setter
    public void setAuthor(String a) {
        author = a;
    }

    // Getter
    public String getAuthor() {
        return author;
    }
}

class DigitalBook extends LibraryBook {

    DigitalBook(String i, String t, String a) {
        super(i, t, a);
    }

    void displayDetails() {
        System.out.println("ISBN   : " + ISBN);          // public
        System.out.println("Title  : " + title);         // protected
        System.out.println("Author : " + getAuthor());   // private via method
    }
}

class TestLibrary {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        DigitalBook db = new DigitalBook(isbn, title, author);

        System.out.println("\nBook Details:");
        db.displayDetails();

        System.out.print("\nEnter new Author name: ");
        String newAuthor = sc.nextLine();
        db.setAuthor(newAuthor);

        System.out.println("Updated Author: " + db.getAuthor());

        sc.close();
    }
}
