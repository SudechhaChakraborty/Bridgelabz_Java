package Object_Oriented_Programming.Inheritance;

import java.util.Scanner;

public class BankTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SavingsAccount sa = new SavingsAccount(1001, 5000, 4.5);
        sa.displayAccountType();
        sa.displayDetails();

        System.out.println();


        CheckingAccount ca = new CheckingAccount(1002, 8000, 3);
        ca.displayAccountType();
        ca.displayDetails();

        System.out.println();


        FixedDepositAccount fda = new FixedDepositAccount(1003, 20000, 12);
        fda.displayAccountType();
        fda.displayDetails();

        sc.close();
    }
}

// Superclass
class BankAccount {
    int accountNumber;
    double balance;

    BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}

//subclass
class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
    }
}

// subclass
class CheckingAccount extends BankAccount {
    int withdrawalLimit;

    CheckingAccount(int accountNumber, double balance, int withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        System.out.println("Account Type: Checking Account");
    }
}

//subclass
class FixedDepositAccount extends BankAccount {
    int tenure;

    FixedDepositAccount(int accountNumber, double balance, int tenure) {
        super(accountNumber, balance);
        this.tenure = tenure;
    }

    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
    }
}
