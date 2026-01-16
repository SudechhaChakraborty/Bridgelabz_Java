package Object_Oriented_Programming.Java_Constructors_Instance_ClassVariables_AccessModifiers.Level1;
/*
Problem 3: Bank Account Management
Create a BankAccount class with:
accountNumber (public).
accountHolder (protected).
balance (private).
Write methods to:
Access and modify balance using public methods.
Create a subclass SavingsAccount to demonstrate access to accountNumber and accountHolder.
*/

import java.util.Scanner;

class BankAccount {

    public int accountNumber;
    protected String accountHolder;
    private double balance;

    BankAccount(int accNo, String holder, double bal) {
        accountNumber = accNo;
        accountHolder = holder;
        balance = bal;
    }

    // Getter
    public double getBalance() {
        return balance;
    }

    // Setter
    public void setBalance(double bal) {
        balance = bal;
    }
}

// Subclass
class SavingsAccount extends BankAccount {

    SavingsAccount(int accNo, String holder, double bal) {
        super(accNo, holder, bal);
    }

    void displayDetails() {
        System.out.println("Account Number : " + accountNumber); // public
        System.out.println("Account Holder : " + accountHolder); // protected
        System.out.println("Balance        : " + getBalance());  // private via method
    }
}

class TestBank {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String holder = sc.nextLine();

        System.out.print("Enter Balance: ");
        double bal = sc.nextDouble();

        SavingsAccount sa = new SavingsAccount(accNo, holder, bal);

        System.out.println("\nAccount Details:");
        sa.displayDetails();

        System.out.print("\nEnter new Balance: ");
        double newBal = sc.nextDouble();
        sa.setBalance(newBal);

        System.out.println("Updated Balance: " + sa.getBalance());

        sc.close();
    }
}
