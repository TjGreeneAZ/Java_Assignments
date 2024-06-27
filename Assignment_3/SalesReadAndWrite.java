import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

// Tara Greene
// PA 3
public class SalesReadAndWrite {
    public static void main(String[] args) {
            // Start of try-catch with opening of the scanner and formatter for reader and writing the text files
        try {
            Scanner salesReader = new Scanner(new File("sales.txt"));
            Formatter salesWriter = new Formatter("salesSummary.txt");
            
            //Places the Sales text at the top
            salesWriter.format("%-10s%n", "Sales");

            // Initiates the sum of the sales and the counting of the doubles
            double totalSales = 0;
            int count = 0;
            
            // Count and total the sales data retrieved
            while (salesReader.hasNextDouble()) {
                double amount = salesReader.nextDouble();
                salesWriter.format("%-10.2f%n", amount);
                totalSales += amount;
                count++;
            }
            
            double salesAverage = (count > 0) ? totalSales / count : 0;
            
            // Write summary information, ensuring alignment
            salesWriter.format("%-10s %-20s %-15s%n", "Count", "Total Sales", "Average Sales");
            salesWriter.format("%-10d %-20.2f %-15.2f%n", count, totalSales, salesAverage);
            
            // Close out resources
            salesReader.close();
            salesWriter.close();
            
            // Closes out the try-catch for exception
            System.out.println("Sale Summary has been saved.");
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }
}
