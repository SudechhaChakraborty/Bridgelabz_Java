package Object_Oriented_Programming.Encapsulation_Polymorphism_Interface_AbstractClass;

import java.util.ArrayList;
import java.util.Scanner;

public class BankingSystemDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        System.out.print("Enter number of accounts: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.println("\nAccount " + (i + 1));
            System.out.print("Choose Type (1-Savings, 2-Current): ");
            int type = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Account Number: ");
            int accNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Holder Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();

            BankAccount acc;

            if (type == 1) {
                acc = new SavingsAccount(accNo, name, balance);
            } else {
                acc = new CurrentAccount(accNo, name, balance);
            }

            accounts.add(acc);
        }

        System.out.println("\n===== ACCOUNT DETAILS =====");
        for (BankAccount acc : accounts) {

            acc.displayDetails();
            System.out.println("Interest: ₹" + acc.calculateInterest());

            if (acc instanceof Loanable) {
                ((Loanable) acc).applyForLoan();
                System.out.println("Loan Eligibility: ₹" +
                        ((Loanable) acc).calculateLoanEligibility());
            }

            System.out.println("--------------------------");
        }

        sc.close();
    }
}

abstract class BankAccount {

    // Encapsulation
    private int accountNumber;
    private String holderName;
    private double balance;

    BankAccount(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: ₹" + balance);
    }

    // Abstract method
    public abstract double calculateInterest();
}

interface Loanable {
    void applyForLoan();
    double calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {

    SavingsAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    public double calculateInterest() {
        return getBalance() * 0.04; // 4% interest
    }

    public void applyForLoan() {
        System.out.println("Savings Account Loan Applied");
    }

    public double calculateLoanEligibility() {
        return getBalance() * 5;
    }
}

class CurrentAccount extends BankAccount {

    CurrentAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    public double calculateInterest() {
        return getBalance() * 0.02; // 2% interest
    }
}
