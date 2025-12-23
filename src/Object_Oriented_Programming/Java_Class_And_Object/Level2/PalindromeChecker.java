package Object_Oriented_Programming.Java_Class_And_Object.Level2;
/*
Program to Check Palindrome String
Problem Statement: 	Create a PalindromeChecker class with an attribute text. Add methods to:
Check if the text is a palindrome.
Display the result.
Explanation: The PalindromeChecker class holds the text attribute. The methods operate on this attribute to verify its palindrome status and display the result.
*/

import java.util.Scanner;

class PalindromeChecker {

    String text;

    boolean isPalindrome() {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    void displayResult() {
        if (isPalindrome())
            System.out.println("The string is a Palindrome");
        else
            System.out.println("The string is NOT a Palindrome");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PalindromeChecker pc = new PalindromeChecker();

        System.out.print("Enter a string: ");
        pc.text = sc.nextLine();

        pc.displayResult();
    }
}
