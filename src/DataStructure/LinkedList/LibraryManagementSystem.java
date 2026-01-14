package DataStructure.LinkedList;


import java.util.Scanner;

class LibraryManagementSystem {

    static class Node {
        int bookId;
        String title;
        String author;
        String genre;
        boolean available;
        Node next;
        Node prev;

        Node(int bookId, String title, String author, String genre, boolean available) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.available = available;
        }
    }

    Node head = null;
    Node tail = null;

    void addAtBeginning(int id, String title, String author, String genre, boolean available) {
        Node newNode = new Node(id, title, author, genre, available);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Book added at beginning");
    }

    void addAtEnd(int id, String title, String author, String genre, boolean available) {
        Node newNode = new Node(id, title, author, genre, available);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Book added at end");
    }

    void addAtPosition(int pos, int id, String title, String author, String genre, boolean available) {
        if (pos == 1) {
            addAtBeginning(id, title, author, genre, available);
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(id, title, author, genre, available);
            return;
        }

        Node newNode = new Node(id, title, author, genre, available);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;

        System.out.println("Book added at position " + pos);
    }

    void deleteByBookId(int id) {
        if (head == null) {
            System.out.println("Library is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            if (temp.bookId == id) {

                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }

                System.out.println("Book removed");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found");
    }

    void searchByTitle(String title) {
        Node temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Book not found");
    }

    void searchByAuthor(String author) {
        Node temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No books found for this author");
    }

    void updateAvailability(int id, boolean status) {
        Node temp = head;

        while (temp != null) {
            if (temp.bookId == id) {
                temp.available = status;
                System.out.println("Availability updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found");
    }

    void displayForward() {
        if (head == null) {
            System.out.println("No books available");
            return;
        }

        Node temp = head;
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    void displayReverse() {
        if (tail == null) {
            System.out.println("No books available");
            return;
        }

        Node temp = tail;
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    void countBooks() {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total books in library: " + count);
    }

    void displayBook(Node b) {
        System.out.println(
                "ID: " + b.bookId +
                        ", Title: " + b.title +
                        ", Author: " + b.author +
                        ", Genre: " + b.genre +
                        ", Available: " + (b.available ? "Yes" : "No")
        );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManagementSystem lib = new LibraryManagementSystem();
        int choice;

        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book by Title");
            System.out.println("6. Search Book by Author");
            System.out.println("7. Update Availability");
            System.out.println("8. Display Books (Forward)");
            System.out.println("9. Display Books (Reverse)");
            System.out.println("10. Count Books");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Available (true/false): ");
                    boolean avail = sc.nextBoolean();

                    if (choice == 1)
                        lib.addAtBeginning(id, title, author, genre, avail);
                    else if (choice == 2)
                        lib.addAtEnd(id, title, author, genre, avail);
                    else {
                        System.out.print("Position: ");
                        int pos = sc.nextInt();
                        lib.addAtPosition(pos, id, title, author, genre, avail);
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    lib.deleteByBookId(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Title: ");
                    lib.searchByTitle(sc.nextLine());
                    break;

                case 6:
                    System.out.print("Enter Author: ");
                    lib.searchByAuthor(sc.nextLine());
                    break;

                case 7:
                    System.out.print("Enter Book ID: ");
                    int bid = sc.nextInt();
                    System.out.print("Available (true/false): ");
                    boolean status = sc.nextBoolean();
                    lib.updateAvailability(bid, status);
                    break;

                case 8:
                    lib.displayForward();
                    break;

                case 9:
                    lib.displayReverse();
                    break;

                case 10:
                    lib.countBooks();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);

        sc.close();
    }
}
