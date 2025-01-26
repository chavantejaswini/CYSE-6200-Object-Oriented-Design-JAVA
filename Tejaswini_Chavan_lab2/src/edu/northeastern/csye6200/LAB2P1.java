package edu.northeastern.csye6200;

import java.util.Scanner;

public class LAB2P1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);// Create a Scanner object for user input
        System.out.print("Enter credit card number as long integer: ");
        String numberStr = input.nextLine(); // Reading input as a string
        input.close();

        try {
            long number = Long.parseLong(numberStr); // Convert input to long for validation
            if (isValid(number)) {
                System.out.println(number + " is valid");
            } else {
                System.out.println(number + " is invalid");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values only.");
        }
    }

    /** Check if the credit card number is valid */
    public static boolean isValid(long number) {
    	// Total sum includes the sum of double even-place and odd-place digits
        int totalSum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
     // Check divisibility by 10 and valid prefixes (4, 5, 37, 6)
        return (totalSum % 10 == 0) && 
               (prefixMatched(number, 4) || prefixMatched(number, 5) || 
                prefixMatched(number, 37) || prefixMatched(number, 6));
    }

    /** Sum of double even place digits */
    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        String numStr = Long.toString(number); // Convert number to string for easy manipulation
        
        // Traverse digits from second-to-last, doubling every second digit
        for (int i = numStr.length() - 2; i >= 0; i -= 2) {
            int doubled = Character.getNumericValue(numStr.charAt(i)) * 2;
            sum += getDigit(doubled); // Add the sum of the digits of the doubled value
        }
        return sum;
    }

    /** Return the digit itself if single-digit, otherwise sum the digits */
    public static int getDigit(int number) {
        return number < 10 ? number : number / 10 + number % 10;
    }

    /** Sum of odd place digits */
    public static int sumOfOddPlace(long number) {
        int sum = 0;
        String numStr = Long.toString(number);
        
     // Traverse digits from the last digit, adding odd-place digits
        for (int i = numStr.length() - 1; i >= 0; i -= 2) {
            sum += Character.getNumericValue(numStr.charAt(i));
        }
        return sum;
    }

    /** Check if the card starts with a valid prefix */
    public static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }

    /** Get the number of digits in a long value */
    public static int getSize(long d) {
        return Long.toString(d).length();
    }

    /** Get the first k digits of a number */
    public static long getPrefix(long number, int k) {
        String numStr = Long.toString(number);
        return numStr.length() < k ? number : Long.parseLong(numStr.substring(0, k));
    }
}
