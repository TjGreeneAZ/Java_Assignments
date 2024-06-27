// Tara_Greene
// PA 1


public class ElectricCar extends Car {

    //variables
    private int batterySize;
    private int milesPerCharge;

    //constructor with call to Car class
    public ElectricCar(String make, String model, int modelYear, int batterySize, int milesPerCharge) {
        super(make, model,modelYear);
        this.batterySize = batterySize;
        this.milesPerCharge = milesPerCharge;
    }

    //getters and setters
    public int getBatterySize() {
        return this.batterySize;
    }

    public void setBatterySize(int batterySize) {
        this.batterySize = batterySize;
    }

    public int getMilesPerCharge() {
        return this.milesPerCharge;
    }

    public void setMilesPerCharge(int milesPerCharge) {
        this.milesPerCharge = milesPerCharge;
    }

    //toString the calls both Car and ElectricCar info
    public String toString() {
        return "Electric Car Info\n" +
               "Make: " + getMake() + "\n" +
               "Model: " + getModel() + "\n" +
               "Model Year: " + getModelYear() + "\n" +
               "Battery Size: " + batterySize + " kWh\n" +
               "Miles per Charge: " + milesPerCharge + "\n";
    }
    

}
