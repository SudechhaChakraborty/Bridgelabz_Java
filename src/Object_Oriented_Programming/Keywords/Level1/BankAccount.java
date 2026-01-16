package Object_Oriented_Programming.Keywords.Level1;



import java.util.Scanner;


class BankAccount {


    static String bankName = "ABC Bank";
    static int totalAccounts = 0;


    final int accountNumber;
    String accountHolderName;


    BankAccount(int accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        totalAccounts++;
    }


    static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }


    void displayDetails(Object obj) {
        if (obj instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Holder Name: " + accountHolderName);
        }
    }
}


class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);


        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine(); // clear buffer


        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();


        BankAccount acc = new BankAccount(accNo, name);


        System.out.println("\n--- Account Details ---\n");
        acc.displayDetails(acc);


        System.out.println();
        BankAccount.getTotalAccounts();


        sc.close();
    }
}
