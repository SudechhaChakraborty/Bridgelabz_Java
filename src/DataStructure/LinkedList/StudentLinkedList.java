package DataStructure.LinkedList;

class StudentLinkedList {

    static class Node {
        int rollNo;
        String name;
        int age;
        char grade;
        Node next;

        Node(int rollNo, String name, int age, char grade) {
            this.rollNo = rollNo;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

    Node head = null;

    void addAtBeginning(int rollNo, String name, int age, char grade) {
        Node newNode = new Node(rollNo, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    void addAtEnd(int rollNo, String name, int age, char grade) {
        Node newNode = new Node(rollNo, name, age, grade);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void addAtPosition(int position, int rollNo, String name, int age, char grade) {
        if (position == 1) {
            addAtBeginning(rollNo, name, age, grade);
            return;
        }

        Node newNode = new Node(rollNo, name, age, grade);
        Node temp = head;

        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteByRollNo(int rollNo) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.rollNo == rollNo) {
            head = head.next;
            System.out.println("Student deleted");
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student deleted");
        }
    }

    void searchStudent(int rollNo) {
        Node temp = head;

        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println("Student Found:");
                System.out.println(temp.rollNo + " " + temp.name + " " + temp.age + " " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    void updateGrade(int rollNo, char newGrade) {
        Node temp = head;

        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.grade = newGrade;
                System.out.println("Grade updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    void display() {
        if (head == null) {
            System.out.println("No student records");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.println(
                    temp.rollNo + " " +
                            temp.name + " " +
                            temp.age + " " +
                            temp.grade
            );
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        StudentLinkedList list = new StudentLinkedList();

        list.addAtBeginning(1, "Amit", 20, 'A');
        list.addAtEnd(2, "Riya", 21, 'B');
        list.addAtEnd(3, "Suman", 19, 'A');
        list.addAtPosition(2, 4, "Neha", 22, 'C');

        System.out.println("All Students:");
        list.display();

        System.out.println("\nSearching Roll No 2:");
        list.searchStudent(2);

        System.out.println("\nUpdating Grade of Roll No 3:");
        list.updateGrade(3, 'A');

        System.out.println("\nDeleting Roll No 1:");
        list.deleteByRollNo(1);

        System.out.println("\nFinal Student List:");
        list.display();
    }
}
