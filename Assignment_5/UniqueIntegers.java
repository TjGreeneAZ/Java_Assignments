// Tara Greene
// PA 5

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class UniqueIntegers {

    public static void main(String[] args) {
        // Opening the file for reading
        String filename = "values.txt";

        try (Scanner in = new Scanner(new File(filename))) {
            // Creates the TreeSet for storing the integers
            TreeSet<Integer> uniqueNums = new TreeSet<>();
            // Initializes the count of total integers
            int numInt = 0;
            while (in.hasNext()) {
                // Moves through each number
                int number = in.nextInt();
                numInt++;
                // Adds to the set if it's unique
                uniqueNums.add(number);
            }
            // Using the Iterator to print out the set of unique integers in sorted order
            Iterator<Integer> iter = uniqueNums.iterator();
            while (iter.hasNext()) {
                System.out.print(iter.next() + " ");
            }
            System.out.println(); // Moves to the next line for formatting
            System.out.println("Number of integers: " + numInt);
            System.out.println("Unique integers count: " + uniqueNums.size());
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open: " + filename);
        }
    }
}