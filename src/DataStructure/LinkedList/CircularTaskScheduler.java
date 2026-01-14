package DataStructure.LinkedList;

import java.util.Scanner;

class CircularTaskScheduler {

    static class Node {
        int taskId;
        String taskName;
        int priority;
        String dueDate;
        Node next;

        Node(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
        }
    }

    Node head = null;
    Node current = null;

    void addAtBeginning(int id, String name, int priority, String date) {
        Node newNode = new Node(id, name, priority, date);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
        } else {
            Node temp = head;
            while (temp.next != head)
                temp = temp.next;

            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
        System.out.println("Task added at beginning");
    }

    void addAtEnd(int id, String name, int priority, String date) {
        Node newNode = new Node(id, name, priority, date);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
        } else {
            Node temp = head;
            while (temp.next != head)
                temp = temp.next;

            temp.next = newNode;
            newNode.next = head;
        }
        System.out.println("Task added at end");
    }

    void addAtPosition(int pos, int id, String name, int priority, String date) {
        if (pos == 1) {
            addAtBeginning(id, name, priority, date);
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(id, name, priority, date);
        newNode.next = temp.next;
        temp.next = newNode;

        System.out.println("Task added at position " + pos);
    }

    // Remove by Task ID
    void deleteByTaskId(int id) {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        Node temp = head;
        Node prev = null;

        do {
            if (temp.taskId == id) {

                if (temp == head) {
                    Node last = head;
                    while (last.next != head)
                        last = last.next;

                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = temp.next;
                }

                System.out.println("Task deleted");
                return;
            }
            prev = temp;
            temp = temp.next;

        } while (temp != head);

        System.out.println("Task not found");
    }

    // View current task and move to next
    void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks available");
            return;
        }

        System.out.println(
                "Task ID: " + current.taskId +
                        ", Name: " + current.taskName +
                        ", Priority: " + current.priority +
                        ", Due Date: " + current.dueDate
        );

        current = current.next;
    }

    // Display all tasks
    void displayTasks() {
        if (head == null) {
            System.out.println("No tasks to display");
            return;
        }

        Node temp = head;
        do {
            System.out.println(
                    "Task ID: " + temp.taskId +
                            ", Name: " + temp.taskName +
                            ", Priority: " + temp.priority +
                            ", Due Date: " + temp.dueDate
            );
            temp = temp.next;
        } while (temp != head);
    }

    // Search by priority
    void searchByPriority(int p) {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        Node temp = head;
        boolean found = false;

        do {
            if (temp.priority == p) {
                System.out.println(
                        "Task ID: " + temp.taskId +
                                ", Name: " + temp.taskName +
                                ", Due Date: " + temp.dueDate
                );
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No task found with this priority");
    }

    // Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularTaskScheduler scheduler = new CircularTaskScheduler();
        int choice;

        do {
            System.out.println("\n--- Circular Task Scheduler ---");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Delete Task by ID");
            System.out.println("5. View Current Task & Move Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search Task by Priority");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Priority: ");
                    int priority = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Due Date: ");
                    String date = sc.nextLine();

                    if (choice == 1)
                        scheduler.addAtBeginning(id, name, priority, date);
                    else if (choice == 2)
                        scheduler.addAtEnd(id, name, priority, date);
                    else {
                        System.out.print("Position: ");
                        int pos = sc.nextInt();
                        scheduler.addAtPosition(pos, id, name, priority, date);
                    }
                    break;

                case 4:
                    System.out.print("Enter Task ID: ");
                    scheduler.deleteByTaskId(sc.nextInt());
                    break;

                case 5:
                    scheduler.viewCurrentTask();
                    break;

                case 6:
                    scheduler.displayTasks();
                    break;

                case 7:
                    System.out.print("Enter Priority: ");
                    scheduler.searchByPriority(sc.nextInt());
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
