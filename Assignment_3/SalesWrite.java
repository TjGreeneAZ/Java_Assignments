import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;
// Tara Greene
// PA3
public class SalesWrite {
    
    public static void main(String[] args) {
        // Opening the file
        try (Formatter output = new Formatter("sales.txt")) {
            // Initiate user input for sales data
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the sales amounts:");
            
            while (true) { // Loop that will stop only when -1 (sentinel value) is entered
                double amount;
                try {
                    amount = input.nextDouble();
                    if (amount == -1) break; // Check for sentinel value
                    output.format("%.2f%n", amount); // formats the doubles into the file
                } catch (NoSuchElementException elementException) {
                    System.err.println("Invalid input. Please try again.");
                    input.nextLine(); // Moves to next line for user to continue data entry
                }
            }
            
            input.close(); // Close the scanner
        } catch (SecurityException | FileNotFoundException | FormatterClosedException e) {
            e.printStackTrace();
        }
    }
}
