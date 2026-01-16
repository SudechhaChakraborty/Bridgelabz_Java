package Object_Oriented_Programming.Java_Class_And_Object.Level2;
/*
Program to Simulate an ATM
Problem Statement: Create a BankAccount class with attributes accountHolder, accountNumber, and balance. Add methods for:
Depositing money.
Withdrawing money (only if sufficient balance exists).
Displaying the current balance.
Explanation: The BankAccount class stores bank account details as attributes. The methods allow interaction with these attributes to modify and view the account's state.
*/

import java.util.Scanner;

class BankAccount {

    String accountHolder;
    int accountNumber;
    double balance;

    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Amount deposited: " + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Amount withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount acc = new BankAccount();

        System.out.print("Enter account holder name: ");
        acc.accountHolder = sc.nextLine();

        System.out.print("Enter account number: ");
        acc.accountNumber = sc.nextInt();

        System.out.print("Enter initial balance: ");
        acc.balance = sc.nextDouble();

        System.out.print("\nEnter amount to deposit: ");
        double depositAmount = sc.nextDouble();
        acc.deposit(depositAmount);

        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = sc.nextDouble();
        acc.withdraw(withdrawAmount);

        acc.displayBalance();
    }
}
