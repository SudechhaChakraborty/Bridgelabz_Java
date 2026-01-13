package Object_Oriented_Programming.Keywords.Level1;

import java.util.Scanner;

public class Patient {

    /* ---------- STATIC ---------- */
    static String hospitalName = "City Care Hospital";
    static int totalPatients = 0;

    static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    /* ---------- INSTANCE VARIABLES ---------- */
    String name;
    int age;
    String ailment;
    final int patientID;     // FINAL: cannot be changed

    /* ---------- CONSTRUCTOR (THIS) ---------- */
    Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;     // count patients
    }

    /* ---------- METHOD WITH INSTANCEOF ---------- */
    void displayPatientDetails(Object obj) {

        if (obj instanceof Patient) {
            System.out.println("\n--- Patient Details ---");
            System.out.println("Hospital Name : " + hospitalName);
            System.out.println("Patient ID    : " + patientID);
            System.out.println("Name          : " + name);
            System.out.println("Age           : " + age);
            System.out.println("Ailment       : " + ailment);
        } else {
            System.out.println("Object is not a Patient");
        }
    }

    /* ---------- MAIN METHOD (SAME FILE) ---------- */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Ailment: ");
        String ailment = sc.nextLine();

        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();

        // Create Patient object
        Patient patient = new Patient(name, age, ailment, id);

        // Validate using instanceof and display details
        patient.displayPatientDetails(patient);

        // Display total patients (static)
        Patient.getTotalPatients();

        sc.close();
    }
}
