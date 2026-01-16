package Object_Oriented_Programming.Keywords.Level1;

import java.util.Scanner;

public class Book {

    /* ---------- STATIC ---------- */
    static String libraryName = "Central City Library";

    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    /* ---------- INSTANCE VARIABLES ---------- */
    String title;
    String author;
    final String isbn;   // FINAL: cannot be changed

    /* ---------- CONSTRUCTOR (THIS) ---------- */
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    /* ---------- METHOD ---------- */
    void displayDetails(Object obj) {

        /* ---------- INSTANCEOF ---------- */
        if (obj instanceof Book) {
            System.out.println("\n--- Book Details ---");
            System.out.println("Title  : " + title);
            System.out.println("Author : " + author);
            System.out.println("ISBN   : " + isbn);
        } else {
            System.out.println("Object is not a Book");
        }
    }

    /* ---------- MAIN METHOD (SAME FILE, NO SEPARATE MAIN FILE) ---------- */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        // Display static data
        Book.displayLibraryName();

        // Create Book object
        Book book = new Book(title, author, isbn);

        // Verify using instanceof and display details
        book.displayDetails(book);

        sc.close();
    }
}
