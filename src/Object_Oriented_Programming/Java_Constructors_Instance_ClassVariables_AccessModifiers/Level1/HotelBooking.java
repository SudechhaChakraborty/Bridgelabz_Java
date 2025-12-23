package Object_Oriented_Programming.Java_Constructors_Instance_ClassVariables_AccessModifiers.Level1;
/*
Hotel Booking System: Create a HotelBooking class with attributes guestName, roomType, and nights. Use default, parameterized, and copy constructors to initialize bookings.
*/

import java.util.Scanner;

class HotelBooking {

    String guestName;
    String roomType;
    int nights;

    HotelBooking() {
        guestName = "Guest";
        roomType = "Standard";
        nights = 1;
    }

    HotelBooking(String g, String r, int n) {
        guestName = g;
        roomType = r;
        nights = n;
    }

    HotelBooking(HotelBooking hb) {
        guestName = hb.guestName;
        roomType = hb.roomType;
        nights = hb.nights;
    }

    void display() {
        System.out.println("Guest Name : " + guestName);
        System.out.println("Room Type  : " + roomType);
        System.out.println("Nights     : " + nights);
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HotelBooking b1 = new HotelBooking();
        System.out.println("Default Booking:");
        b1.display();

        System.out.print("Enter guest name: ");
        String name = sc.nextLine();

        System.out.print("Enter room type: ");
        String room = sc.nextLine();

        System.out.print("Enter number of nights: ");
        int nights = sc.nextInt();

        HotelBooking b2 = new HotelBooking(name, room, nights);
        System.out.println("\nUser Booking:");
        b2.display();

        HotelBooking b3 = new HotelBooking(b2);
        System.out.println("Copied Booking:");
        b3.display();

        sc.close();
    }
}
