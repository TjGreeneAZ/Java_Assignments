// Tara Greene
// PA 12

//Write program named ProductTable that does the following:
//
//Run a query that displays all of the information in the table.
//Create and run SQL statements to do the following:
//Product Number B07XJ8C8F5 price has increased to 32.99, update the product's price and display a message that the update was successful.
//Product Number B07FKR6KXF has been discontinued, delete the product from the table and display a message that the delete was successful.
//Product Number B082JP6VP5 quantity has changed to 5 and price has been increased to 23.99, update the product's price and quantity, and display a message that the update was successful.
//Add the following product to the table: Product Number: B07DJWBYKP, Product Name: Cyberpunk 2077, Department: Video Games, Price: 34.99, Quantity: 35. Display a message that the product has been added successfully.

//Run a query that displays all of the information in the table.
//Create and run SQL statements to do the following:
//Create a query to display product name and quantity for products with a quantity <= 10, order the query results by quantity.
//Create a query to display product number, product name, price, and quantity for products in the Electronics department, order the query results by price in descending order.
//Create a query to display the product number and product name for products with a quantity > 30 and price >= 29.99.
//Create a query to display the average price of products in the Video Games department.

import java.sql.*;

public class ProductTable {
    private static final String URL = "jdbc:derby:ABCCorp";
    private static final String USERNAME = "CIS263";
    private static final String PASSWORD = "CIS263";

    // Calls the Connection method for connecting to the DB to run queries
    private static Connection conn;

    // calls the Statement method from the java API for use in queries
    private static Statement stmt;

    public static void main(String[] args) {
        try {
            // Connects to the DB using the 3 strings from above
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            // used to connect and runs the queries
            stmt = conn.createStatement();

            // All values to be changed or updated with spacing for ease of reading
            System.out.println("All Products");
            displayProducts();
            System.out.println();
            updateEchoDot("B07XJ8C8F5", 32.99);
            System.out.println();
            deleteFireTab("B07FKR6KXF");
            System.out.println();
            updatePriceQtyWick("B082JP6VP5", 23.99, 5);
            System.out.println();
            addCyberpunk("B07DJWBYKP", "Cyberpunk 2077", "Video Games", 34.99, 35);
            System.out.println();
            System.out.println("All Products");
            displayProducts();
            System.out.println();
            System.out.println("Products with quantity <= 10:");
            tenOrLess();
            System.out.println();
            System.out.println("Electronic Products");
            electronicsByPrice();
            System.out.println();
            System.out.println("Products with quantity > 30 and price >= 29.99:");
            thirtyInStock();
            System.out.println();
            avgVideoGames();


            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Start of all the query statements called above

    // Query to display the table information
    private static void displayProducts() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM product");
        while (rs.next()) {
            System.out.println(rs.getString("prodNumber") + "\t" +
                    rs.getString("prodName") + "\t" +
                    rs.getString("department") + "\t" +
                    rs.getDouble("price") + "\t" +
                    rs.getInt("quantity"));
        }
    }

    // Updates Echo Dot to a new price
    private static void updateEchoDot(String productNumber, double newPrice) throws SQLException {
        // Runs an SQL statement that will set a new price and product number based on what is given when updateEchoDot
        // is called. Will also print out success message if it works.
        String sql = "UPDATE product SET price = " + newPrice + " WHERE prodNumber = '" + productNumber + "'";
        int affectedRows = stmt.executeUpdate(sql);
        if (affectedRows > 0) {
            System.out.println("Update Successful");
        }
    }

    // Deletes Fire 7 Tablet
    private static void deleteFireTab(String productNumber) throws SQLException {
        // Will run a SQL statement that deletes a item based on the product number given when deleteFireTab is called
        String sql = "DELETE FROM product WHERE prodNumber = '" + productNumber + "'";
        int affectedRows = stmt.executeUpdate(sql);
        if (affectedRows > 0) {
            System.out.println("Update Successful");
        }
    }

    // Updates both quantity and price of John Wick movies
    private static void updatePriceQtyWick(String productNumber, double newPrice, int newQuantity) throws SQLException {
        // Runs an SQL statement that gives a new price, quantity based on the product number given when updatePriceWick
        // is called
        String sql = "UPDATE product SET price = " + newPrice + ", quantity = " + newQuantity + " WHERE prodNumber = '"
                + productNumber + "'";
        int affectedRows = stmt.executeUpdate(sql);
        if (affectedRows > 0) {
            System.out.println("Update Successful");
        }
    }
    // Adds Cyberpunk to the table
    private static void addCyberpunk(String prodNumber, String prodName, String department, double price, int quantity)
            throws SQLException {
        // Runs a statement adds an entirely new product into the table based on info given when called
        String sql = "INSERT INTO product (prodNumber, prodName, department, price, quantity) VALUES ('" +
                prodNumber + "', '" + prodName + "', '" + department + "', " + price + ", " + quantity + ")";
        int affectedRows = stmt.executeUpdate(sql);
        if (affectedRows > 0) {
            System.out.println("Update Successful");
        }
    }

    // Displays the products with 10 or less in stock
    private static void tenOrLess() throws SQLException {
        // Runs statement that a search that returns product with price if it's quantity is less than 10, and sorts it
        // by quantity
        String sql = "SELECT prodName, quantity FROM product WHERE quantity <= 10 ORDER BY quantity";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString("prodName") + "\t" + rs.getInt("quantity"));
        }
    }

    // Displays all products in Electronics sorting them by price
    private static void electronicsByPrice() throws SQLException {
        // Runs statement that searches for all in Department of 'Electronics' and gives back product number, name,
        // price and quantity sorted by price
        String sql = "SELECT prodNumber, prodName, price, quantity FROM product WHERE department = 'Electronics' ORDER BY price DESC";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString("prodNumber") + "\t" +
                    rs.getString("prodName") + "\t" +
                    rs.getDouble("price") + "\t" +
                    rs.getInt("quantity"));
        }
    }

    // Displays all products with more than 30 in stock and a price of 29.99 or more
    private static void thirtyInStock() throws SQLException {
        // Runs statement that searches table for products with more than 30 in stock and a price of 29.99 or more
        // giving back the products number and name
        String sql = "SELECT prodNumber, prodName FROM product WHERE quantity > 30 AND price >= 29.99";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString("prodNumber") + "\t" + rs.getString("prodName"));
        }
    }

    // Runs a query that gives the average price of all products in the department Video Games
    private static void avgVideoGames() throws SQLException {
        // Runs a statement that finds the av
        String sql = "SELECT AVG(price) AS averagePrice FROM product WHERE department = 'Video Games'";
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            System.out.println("Average price of a Video Game is " + rs.getDouble("averagePrice"));
        }
    }
}

