package Object_Oriented_Programming.Java_Class_And_Object.Level2;
/*
Program to Model a Movie Ticket Booking System
Problem Statement: Create a MovieTicket class with attributes movieName, seatNumber, and price. Add methods to:
Book a ticket (assign seat and update price).
Display ticket details.
Explanation: The MovieTicket class organizes ticket information with attributes. The methods handle booking logic and display ticket details.
*/

import java.util.Scanner;

class MovieTicket {

    String movieName;
    int seatNumber;
    double price;

    void bookTicket(String movie, int seat, double ticketPrice) {
        movieName = movie;
        seatNumber = seat;
        price = ticketPrice;
    }

    void displayTicket() {
        System.out.println("\nTicket Details:");
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MovieTicket ticket = new MovieTicket();

        System.out.print("Enter movie name: ");
        String movie = sc.nextLine();

        System.out.print("Enter seat number: ");
        int seat = sc.nextInt();

        System.out.print("Enter ticket price: ");
        double price = sc.nextDouble();

        ticket.bookTicket(movie, seat, price);

        ticket.displayTicket();
    }
}
