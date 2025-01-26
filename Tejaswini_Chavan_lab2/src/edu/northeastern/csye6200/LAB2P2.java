package edu.northeastern.csye6200;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LAB2P2 {
    public static void main(String[] args) {
    	// Create a list to store grades
        ArrayList<Double> grades = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File("csye6200.txt"))) {
        	// Read up to 15 grades from the file, assuming they are stored as doubles
        	while (fileScanner.hasNextDouble() && grades.size() < 15) {
                grades.add(fileScanner.nextDouble());
            }
        } catch (FileNotFoundException e) {
        	 // Handle the case where the input file is not found
            System.out.println("File not found. Ensure 'csye6200.txt' exists in the project directory.");
            return;  // Exit the program as there is no file to process
        }

     // Check if no grades were loaded from the file
        if (grades.isEmpty()) {
            System.out.println("No grades to process.");
            return; // Exit the program as there are no grades to work with
        }

     // Calculate the average of the grades
        double average = calculateAverage(grades);
        // Display the average and the difference of each grade from the average
        System.out.printf("Grade differences from the average %.2f:\n", average);
        for (int i = 0; i < grades.size(); i++) {
            System.out.printf("Grade %d: %.2f\n", i + 1, grades.get(i) - average);
        }
    }

    private static double calculateAverage(ArrayList<Double> grades) {
        double sum = 0;
     // Sum all the grades
        for (double grade : grades) {
            sum += grade;
        }
        // Return the average by dividing the total sum by the number of grades
        return sum / grades.size();
    }
}
