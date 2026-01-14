package DataStructure.LinkedList;


import java.util.Scanner;

class TextEditorUndoRedo {

    static class Node {
        String text;
        Node prev;
        Node next;

        Node(String text) {
            this.text = text;
        }
    }

    Node head = null;
    Node tail = null;
    Node current = null;
    int size = 0;
    final int MAX_HISTORY = 10;

    void addState(String text) {
        Node newNode = new Node(text);

        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
        }

        if (head == null) {
            head = tail = current = newNode;
            size = 1;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            current = newNode;
            size++;

            // Limit history to 10 states
            if (size > MAX_HISTORY) {
                head = head.next;
                head.prev = null;
                size--;
            }
        }

        System.out.println("Text added");
    }

    void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Nothing to undo");
            return;
        }
        current = current.prev;
        System.out.println("Undo successful");
    }

    void redo() {
        if (current == null || current.next == null) {
            System.out.println("Nothing to redo");
            return;
        }
        current = current.next;
        System.out.println("Redo successful");
    }

    void displayCurrent() {
        if (current == null) {
            System.out.println("Text is empty");
        } else {
            System.out.println("Current Text: " + current.text);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditorUndoRedo editor = new TextEditorUndoRedo();
        int choice;

        do {
            System.out.println("\n--- Text Editor (Undo/Redo) ---");
            System.out.println("1. Type / Add Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current Text");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    String text = sc.nextLine();
                    editor.addState(text);
                    break;

                case 2:
                    editor.undo();
                    break;

                case 3:
                    editor.redo();
                    break;

                case 4:
                    editor.displayCurrent();
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
