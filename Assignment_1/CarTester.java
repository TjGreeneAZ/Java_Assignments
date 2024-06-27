// Tara_Greene
// PA 1

import java.util.Scanner;

public class CarTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Prompt for details
        System.out.println("Enter Car Info");
        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Model Year: ");
        int modelYear = scanner.nextInt();
        scanner.nextLine();

        //Calling Car toString
        Car car = new Car(make, model, modelYear);
        System.out.println();//spacing
        System.out.println(car.toString());

        //Reprompting
        System.out.println();//spacing
        System.out.println("Enter Updated Car Info");
        System.out.print("New Make: ");
        make = scanner.nextLine();
        System.out.print("New Model: ");
        model = scanner.nextLine();
        System.out.print("New Model Year: ");
        modelYear = scanner.nextInt();
        scanner.nextLine();

        //setters
        car.setMake(make);
        car.setModel(model);
        car.setModelYear(modelYear);

        //getters for display
        System.out.println(); //spacing
        System.out.println("Updated Car Info");
        System.out.println("Make: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Model Year: " + car.getModelYear());

        //Prompt for ElectricCar info
        System.out.println(); //spacing
        System.out.println("Enter Electric Car Info");
        System.out.print("Make: ");
        String electricMake = scanner.nextLine();
        System.out.print("Model: ");
        String electricModel = scanner.nextLine();
        System.out.print("Model Year: ");
        int electricModelYear = scanner.nextInt();
        System.out.print("Battery Size (in kWh): ");
        int batterySize = scanner.nextInt();
        System.out.print("Miles Per Charge: ");
        int milesPerCharge = scanner.nextInt();
        scanner.nextLine();

        //Calling ElectricCar toString
        ElectricCar electricCar = new ElectricCar(electricMake, electricModel, electricModelYear, batterySize, milesPerCharge);
        System.out.println(); //spacing
        System.out.println(electricCar.toString());

        //Reprompting
        System.out.println(); //spacing
        System.out.println("Enter Updated Electric Car Info");
        System.out.print("New Make: ");
        String newElectricMake = scanner.nextLine();
        System.out.print("New Model: ");
        String newElectricModel = scanner.nextLine();
        System.out.print("New Model Year: ");
        int newElectricModelYear = scanner.nextInt();
        System.out.print("New Battery Size (in kWh): ");
        int newBatterySize = scanner.nextInt();
        System.out.print("New Miles Per Charge: ");
        int newMilesPerCharge = scanner.nextInt();

        //setters
        electricCar.setMake(newElectricMake);
        electricCar.setModel(newElectricModel);
        electricCar.setModelYear(newElectricModelYear);
        electricCar.setBatterySize(newBatterySize);
        electricCar.setMilesPerCharge(newMilesPerCharge);

        //getters
        System.out.println(); // spacing
        System.out.println("Updated Electric Car Information");
        System.out.println("Make: " + electricCar.getMake());
        System.out.println("Model: " + electricCar.getModel());
        System.out.println("Model Year: " + electricCar.getModelYear());
        System.out.println("Battery Size: " + electricCar.getBatterySize() + " kWh");
        System.out.println("Miles per Charge: " + electricCar.getMilesPerCharge());

        //closing scanner
        scanner.close();
    }
}
