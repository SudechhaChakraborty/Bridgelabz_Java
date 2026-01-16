package Object_Oriented_Programming.Inheritance;

import java.util.Scanner;

public class SmartHomeTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Device ID: ");
        int deviceId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Device Status (ON/OFF): ");
        String status = sc.nextLine();


        System.out.print("Enter Temperature Setting: ");
        int temperature = sc.nextInt();

        Thermostat t1 = new Thermostat(deviceId, status, temperature);

        System.out.println("\n--- Device Status ---");
        t1.displayStatus();

        sc.close();
    }
}

// Superclass
class Device {
    int deviceId;
    String status;

    Device(int deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

// Subclass
class Thermostat extends Device {
    int temperatureSetting;

    Thermostat(int deviceId, String status, int temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}
