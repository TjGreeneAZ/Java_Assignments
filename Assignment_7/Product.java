// Product.java
public class Product {
   private String prodNumber; 
   private String prodName;
   private String department;
   private double price;
   private int quantity;
   

   // constructor
   public Product(String prodNumber, String prodName, String department, double price, int quantity)
   {
      
      if (price < 0.0) { // validate price
         throw new IllegalArgumentException("Price must be >= 0");
      }
      
      if (quantity < 0) { // validate quantity
         throw new IllegalArgumentException("Quantity must be >= 0");
      }

      this.prodNumber = prodNumber;
      this.prodName = prodName;
      this.department = department;
      this.price = price; 
      this.quantity = quantity;
   } 

   // get product number
   public String getProdNumber() 
   {
     return prodNumber;
   } 

   // get product name
   public String getProdName() 
   {
     return prodName;
   }
   
   // get department
   public String getDepartment() 
   {
     return department;
   }
   
   // get price   
   public double getPrice() 
   {
     return price;
   }
   
   // get quantity
   public int getQuantity() 
   {
     return quantity;
   }
   
   // Set product number
   public void setProdNumber(String prodNumber) 
   {
     this.prodNumber = prodNumber;
   }
   
   // Set product name
   public void setProdName(String prodName) 
   {
     this.prodName = prodName;
   }
   
   // Set department
   public void setDepartment(String department) 
   {
     this.department = department;
   }   
   
   // set price
   public void setPrice(double price) {
      if (price < 0.0) {// validate price
         throw new IllegalArgumentException("Price must be >= 0");
      }

      this.price = price;
   } 
     
   // set quantity
   public void setQuantity(int quantity) {
      if (quantity < 0) { // validate quantity
         throw new IllegalArgumentException("Quantity must be >= 0");
      }

      this.quantity = quantity;
   } 

   // return String representation of Product object
   @Override
   public String toString() {
      return String.format("%-12s %-32s %-14s %6.2f %5d",
          getProdNumber(), getProdName(), getDepartment(), getPrice(), getQuantity());
   } 
}


