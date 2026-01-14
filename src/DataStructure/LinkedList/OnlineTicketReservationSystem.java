package DataStructure.LinkedList;


import java.util.Scanner;

class OnlineTicketReservationSystem {

    static class Node {
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        Node next;

        Node(int ticketId, String customerName, String movieName,
             String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            this.next = null;
        }
    }

    Node head = null;

    void addTicket(int id, String customer, String movie,
                   String seat, String time) {
        Node newNode = new Node(id, customer, movie, seat, time);

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head)
                temp = temp.next;

            temp.next = newNode;
            newNode.next = head;
        }
        System.out.println("Ticket booked successfully");
    }

    void removeTicket(int id) {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        Node curr = head;
        Node prev = null;

        do {
            if (curr.ticketId == id) {

                if (curr == head && curr.next == head) {
                    head = null;
                }

                else if (curr == head) {
                    Node last = head;
                    while (last.next != head)
                        last = last.next;

                    head = head.next;
                    last.next = head;
                }

                else {
                    prev.next = curr.next;
                }

                System.out.println("Ticket cancelled");
                return;
            }
            prev = curr;
            curr = curr.next;

        } while (curr != head);

        System.out.println("Ticket not found");
    }

    void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        Node temp = head;
        do {
            displayTicket(temp);
            temp = temp.next;
        } while (temp != head);
    }

    void searchByCustomer(String name) {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        Node temp = head;
        boolean found = false;

        do {
            if (temp.customerName.equalsIgnoreCase(name)) {
                displayTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No ticket found for this customer");
    }

    void searchByMovie(String movie) {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        Node temp = head;
        boolean found = false;

        do {
            if (temp.movieName.equalsIgnoreCase(movie)) {
                displayTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No tickets found for this movie");
    }

    void countTickets() {
        if (head == null) {
            System.out.println("Total booked tickets: 0");
            return;
        }

        int count = 0;
        Node temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total booked tickets: " + count);
    }

    void displayTicket(Node t) {
        System.out.println(
                "Ticket ID: " + t.ticketId +
                        ", Customer: " + t.customerName +
                        ", Movie: " + t.movieName +
                        ", Seat: " + t.seatNumber +
                        ", Time: " + t.bookingTime
        );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OnlineTicketReservationSystem sys =
                new OnlineTicketReservationSystem();
        int choice;

        do {
            System.out.println("\n--- Online Ticket Reservation System ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket by ID");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search Ticket by Customer Name");
            System.out.println("5. Search Ticket by Movie Name");
            System.out.println("6. Count Booked Tickets");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Ticket ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Customer Name: ");
                    String cust = sc.nextLine();
                    System.out.print("Movie Name: ");
                    String movie = sc.nextLine();
                    System.out.print("Seat Number: ");
                    String seat = sc.nextLine();
                    System.out.print("Booking Time: ");
                    String time = sc.nextLine();
                    sys.addTicket(id, cust, movie, seat, time);
                    break;

                case 2:
                    System.out.print("Enter Ticket ID: ");
                    sys.removeTicket(sc.nextInt());
                    break;

                case 3:
                    sys.displayTickets();
                    break;

                case 4:
                    System.out.print("Enter Customer Name: ");
                    sys.searchByCustomer(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Enter Movie Name: ");
                    sys.searchByMovie(sc.nextLine());
                    break;

                case 6:
                    sys.countTickets();
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
