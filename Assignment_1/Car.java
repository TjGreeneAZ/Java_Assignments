// Tara_Greene
// PA 1


public class Car {

    //variables
    private String make;
    private String model;
    private int modelYear;

    //constructor
    public Car(String make, String model, int modelYear) {
        this.make = make;
        this.model = model;
        this.modelYear = modelYear;
    }

    //getters and setters
    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getModelYear() {
        return this.modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }
    
    //toString for displaying
    public String toString() {
        return "Car Info\n" +
               "Make: " + make + "\n" +
               "Model: " + model + "\n" +
               "Model Year: " + modelYear + "\n";
    }
    
}