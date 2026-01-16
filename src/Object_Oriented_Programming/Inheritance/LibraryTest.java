package Object_Oriented_Programming.Inheritance;

import java.util.Scanner;

public class LibraryTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Publication Year: ");
        int year = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Author Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Author Bio: ");
        String bio = sc.nextLine();

        Author a1 = new Author(title, year, name, bio);

        System.out.println("\n--- Book & Author Details ---");
        a1.displayInfo();

        sc.close();
    }
}

// Superclass
class Book {
    String title;
    int publicationYear;

    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// Subclass
class Author extends Book {
    String name;
    String bio;

    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}
