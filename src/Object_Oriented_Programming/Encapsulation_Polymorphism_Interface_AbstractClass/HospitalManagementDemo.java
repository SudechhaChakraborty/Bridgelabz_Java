package Object_Oriented_Programming.Encapsulation_Polymorphism_Interface_AbstractClass;

import java.util.ArrayList;
import java.util.Scanner;

public class HospitalManagementDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Patient> patients = new ArrayList<>();

        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.println("\nPatient " + (i + 1));
            System.out.print("Choose Type (1-InPatient, 2-OutPatient): ");
            int type = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Patient ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Diagnosis: ");
            String diagnosis = sc.nextLine();

            Patient p;

            if (type == 1) {
                System.out.print("Enter Number of Days Admitted: ");
                int days = sc.nextInt();
                p = new InPatient(id, name, age, diagnosis, days);
            } else {
                System.out.print("Enter Consultation Fee: ");
                double fee = sc.nextDouble();
                p = new OutPatient(id, name, age, diagnosis, fee);
            }

            patients.add(p);
        }

        System.out.println("\n===== PATIENT BILL DETAILS =====");
        for (Patient p : patients) {

            p.getPatientDetails();
            System.out.println("Total Bill: ₹" + p.calculateBill());

            if (p instanceof MedicalRecord) {
                MedicalRecord m = (MedicalRecord) p;
                m.addRecord();
                m.viewRecords();
            }

            System.out.println("-------------------------------");
        }

        sc.close();
    }
}

abstract class Patient {

    // Encapsulation
    private int patientId;
    private String name;
    private int age;
    private String diagnosis;

    Patient(int patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    // Getters
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    protected String getDiagnosis() {
        return diagnosis;
    }

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Abstract method
    public abstract double calculateBill();
}

interface MedicalRecord {
    void addRecord();
    void viewRecords();
}

class InPatient extends Patient implements MedicalRecord {

    private int daysAdmitted;

    InPatient(int id, String name, int age, String diagnosis, int daysAdmitted) {
        super(id, name, age, diagnosis);
        this.daysAdmitted = daysAdmitted;
    }

    public double calculateBill() {
        return daysAdmitted * 2000; // ₹2000 per day
    }

    public void addRecord() {
        System.out.println("Medical record added for In-Patient.");
    }

    public void viewRecords() {
        System.out.println("Diagnosis: " + getDiagnosis());
        System.out.println("Days Admitted: " + daysAdmitted);
    }
}

class OutPatient extends Patient implements MedicalRecord {

    private double consultationFee;

    OutPatient(int id, String name, int age, String diagnosis, double fee) {
        super(id, name, age, diagnosis);
        this.consultationFee = fee;
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord() {
        System.out.println("Medical record added for Out-Patient.");
    }

    public void viewRecords() {
        System.out.println("Diagnosis: " + getDiagnosis());
        System.out.println("Consultation Fee: ₹" + consultationFee);
    }
}
