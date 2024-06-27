import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Tara Greene
// PA 7

public class ProcessProducts {
    public static void main(String[] args) {
        // Array of Products, copied from the pictures?
        List<Product> productList = new ArrayList<>(Arrays.asList(
            new Product("B082JP6VP5", "John Wick: Chapters 1-3", "Movies and TV", 22.29, 18),
            new Product("B07JCRY8WP", "Minecraft", "Video Games", 29.88, 10),
            new Product("B07XJ8C8F5", "Echo Dot Smart Speaker", "Electronics", 29.99, 30),
            new Product("B07DWJBYKP", "Cyberpunk 2077", "Video Games", 34.99, 35),
            new Product("B005OCFHHK", "Harry Potter: 8-Film Collection", "Movies and TV", 39.99, 45),
            new Product("B075XLWML4", "Roku Streaming Stick", "Electronics", 47.92, 5),
            new Product("B08G3MN6KP", "Super Mario 3D All Stars", "Video Games", 49.94, 12),
            new Product("B07FKRK6XF", "Fire 7 Tablet", "Electronics", 49.99, 15)
        ));

        // 1. Use streams to sort the Product objects by price, then display the results.
        System.out.println("(a) Products sorted by price:");
        // Calls the stream to start using productList from above
        productList.stream()
            // Uses the sorted method  with compare to run through the objects in the productList array pulling using Double for prices
            .sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
            // Uses the short stream version to print out the sorted toString from Products.java
            .forEach(System.out::println);

        System.out.println();

        // 2. Use streams to sort the Product objects by department, then display the results
        System.out.println("(b) Products sorted by department:");
        productList.stream()
            // Another sorted but uses compareTo to compare Strings in the array
            .sorted((p1, p2) -> p1.getDepartment().compareTo(p2.getDepartment()))
            .forEach(System.out::println);

        System.out.println();

        // 3. Use streams to map each Product to its prodName, department, and quantity, sort the results by quantity, then display the results.
        System.out.println("(c) Products mapped to product name, department and quantity:");
        productList.stream()
            // Mapping each product to a string with just the prodName, department, and quantity
            .map(p -> String.format("%-32s %-14s %5d", p.getProdName(), p.getDepartment(), p.getQuantity()))
            // Next, sorted by quantity which is the last part of the string so we can compare it as numbers
            .sorted(Comparator.comparingInt(s -> Integer.parseInt(s.trim().split("\\s+")[s.trim().split("\\s+").length - 1])))
            // Finally, printing each product line using the format defined in Product.java's toString method
            .forEach(System.out::println);


        System.out.println();

        // 4. Use streams to map each Product to its prodName, price, and quantity where price > $30.00 and quantity < 30. Order the results by price.
        System.out.println("(d) Products mapped to product name, price and quantity where price > $30 and quantity < 30:");
        productList.stream()
            // Filters the list for the given parameters using a double for the price and a integer for the quantity
            // Then sorts by price
            .filter(p -> p.getPrice() > 30.00 && p.getQuantity() < 30)
            .sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
            // Again formatting to try and match the example using the toStrings format for each part
            .forEach(p -> System.out.printf("%-32s %6.2f %5d\n", p.getProdName(), p.getPrice(), p.getQuantity()));

        System.out.println();

        // 5. Use streams to find and display the first Product in which the department contains the word "Games".
        System.out.println("(e) Display first product where the department contains to word 'Games':");
        productList.stream()
            // Filters through the list for the Games parameter and the stores the first one it finds with the findFirst
            .filter(p -> p.getDepartment().contains("Games"))
            .findFirst()
            .ifPresent(System.out::println);
    }
}
