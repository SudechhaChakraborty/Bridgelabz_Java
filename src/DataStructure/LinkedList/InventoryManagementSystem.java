package DataStructure.LinkedList;

import java.util.Scanner;

class InventoryManagementSystem {

    static class Node {
        int itemId;
        String itemName;
        int quantity;
        double price;
        Node next;

        Node(int itemId, String itemName, int quantity, double price) {
            this.itemId = itemId;
            this.itemName = itemName;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }

    Node head = null;

    void addAtBeginning(int id, String name, int qty, double price) {
        Node newNode = new Node(id, name, qty, price);
        newNode.next = head;
        head = newNode;
        System.out.println("Item added at beginning");
    }

    void addAtEnd(int id, String name, int qty, double price) {
        Node newNode = new Node(id, name, qty, price);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        System.out.println("Item added at end");
    }

    void addAtPosition(int pos, int id, String name, int qty, double price) {
        if (pos == 1) {
            addAtBeginning(id, name, qty, price);
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        Node newNode = new Node(id, name, qty, price);
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Item added at position " + pos);
    }

    void deleteByItemId(int id) {
        if (head == null) {
            System.out.println("Inventory is empty");
            return;
        }

        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item deleted");
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.itemId != id)
            temp = temp.next;

        if (temp.next == null) {
            System.out.println("Item not found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item deleted");
        }
    }

    void updateQuantity(int id, int newQty) {
        Node temp = head;

        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    void searchById(int id) {
        Node temp = head;

        while (temp != null) {
            if (temp.itemId == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    void searchByName(String name) {
        Node temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Item not found");
    }

    void totalInventoryValue() {
        Node temp = head;
        double total = 0;

        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value = " + total);
    }

    void sortByName(boolean ascending) {
        if (head == null) return;

        for (Node i = head; i.next != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if ((ascending && i.itemName.compareToIgnoreCase(j.itemName) > 0) ||
                        (!ascending && i.itemName.compareToIgnoreCase(j.itemName) < 0)) {
                    swapData(i, j);
                }
            }
        }
        System.out.println("Sorted by name");
    }

    void sortByPrice(boolean ascending) {
        if (head == null) return;

        for (Node i = head; i.next != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if ((ascending && i.price > j.price) ||
                        (!ascending && i.price < j.price)) {
                    swapData(i, j);
                }
            }
        }
        System.out.println("Sorted by price");
    }

    void swapData(Node a, Node b) {
        int id = a.itemId;
        String name = a.itemName;
        int qty = a.quantity;
        double price = a.price;

        a.itemId = b.itemId;
        a.itemName = b.itemName;
        a.quantity = b.quantity;
        a.price = b.price;

        b.itemId = id;
        b.itemName = name;
        b.quantity = qty;
        b.price = price;
    }

    void displayAll() {
        if (head == null) {
            System.out.println("No items in inventory");
            return;
        }

        Node temp = head;
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    void displayItem(Node i) {
        System.out.println(
                "ID: " + i.itemId +
                        ", Name: " + i.itemName +
                        ", Qty: " + i.quantity +
                        ", Price: " + i.price
        );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryManagementSystem inv = new InventoryManagementSystem();
        int choice;

        do {
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Delete Item by ID");
            System.out.println("5. Update Quantity");
            System.out.println("6. Search by Item ID");
            System.out.println("7. Search by Item Name");
            System.out.println("8. Display All Items");
            System.out.println("9. Total Inventory Value");
            System.out.println("10. Sort by Name (Asc)");
            System.out.println("11. Sort by Name (Desc)");
            System.out.println("12. Sort by Price (Asc)");
            System.out.println("13. Sort by Price (Desc)");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Item ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Item Name: ");
                    String name = sc.nextLine();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    if (choice == 1)
                        inv.addAtBeginning(id, name, qty, price);
                    else if (choice == 2)
                        inv.addAtEnd(id, name, qty, price);
                    else {
                        System.out.print("Position: ");
                        int pos = sc.nextInt();
                        inv.addAtPosition(pos, id, name, qty, price);
                    }
                    break;

                case 4:
                    System.out.print("Enter Item ID: ");
                    inv.deleteByItemId(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Item ID: ");
                    int iid = sc.nextInt();
                    System.out.print("New Quantity: ");
                    int nq = sc.nextInt();
                    inv.updateQuantity(iid, nq);
                    break;

                case 6:
                    System.out.print("Enter Item ID: ");
                    inv.searchById(sc.nextInt());
                    break;

                case 7:
                    System.out.print("Enter Item Name: ");
                    inv.searchByName(sc.nextLine());
                    break;

                case 8:
                    inv.displayAll();
                    break;

                case 9:
                    inv.totalInventoryValue();
                    break;

                case 10:
                    inv.sortByName(true);
                    break;

                case 11:
                    inv.sortByName(false);
                    break;

                case 12:
                    inv.sortByPrice(true);
                    break;

                case 13:
                    inv.sortByPrice(false);
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
