package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    /**
     * Writes the dealership's inventory of cars into a file
     * @param dealership the input dealership object whose inventory is to be saved
     * @param filename the input file name where the dealership inventory will be written
     */
    public static void writeToFile(Dealership dealership, String filename) throws IOException {
        List<Car> inventory = dealership.getInventory();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("====Dealership inventory:====\n");

            for (Car car : inventory) {

                if (car instanceof ElectricCar electricCar) {
                    writer.write("Electric\n");
                    writer.write("Brand: " + car.getBrand() + "\n");
                    writer.write("Model: " + car.getModel() + "\n");
                    writer.write("Horsepower: " + car.getHorsePower() + " hp\n");
                    writer.write("Battery capacity: " + electricCar.getBatteryCapacity() + " kWh\n");
                    writer.write("Charging type: " + electricCar.getChargingType() + "\n");
                    writer.write("Charging time: " + electricCar.getChargeTime() + " h\n");

                } else if (car instanceof GasCar gasCar) {
                    writer.write("Gas\n");
                    writer.write("Brand: " + car.getBrand() + "\n");
                    writer.write("Model: " + car.getModel() + "\n");
                    writer.write("Horsepower: " + car.getHorsePower() + " hp\n");
                    writer.write("Fuel tank capacity: " + gasCar.getFuelTankCapacity() + " L\n");
                    writer.write("Fuel type: " + gasCar.getFuelType() + "\n");
                    writer.write("Engine type: " + gasCar.getEngineType() + "\n");
                }
                writer.write("-------------------------------\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file" + e.getMessage());
        }
    } // read from file must except this format

    /**
     * Reads the dealership's inventory of cars from a file and updates the dealership
     * @param dealership the input dealership object
     * @param filename the input file name from which the dealership's inventory will be read
     */
    public static void readFromFile(Dealership dealership, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            List<Car> inventory = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                if (line.equals("====Dealership inventory:====") || line.equals("-------------------------------")) {
                    continue;
                }
                    String typeLine = line.trim();
                    String brand = reader.readLine().split(":",2)[1].trim();
                    String model = reader.readLine().split(":",2)[1].trim();
                    int horsePower = Integer.parseInt(reader.readLine().split(":",2)[1].replace(" hp", "").trim());

                    if (typeLine.equals("Electric")) {
                        double batteryCapacity = Double.parseDouble(reader.readLine().split(":",2)[1].replace(" kWh", "").trim());
                        String chargingType = reader.readLine().split(":",2)[1].trim();
                        double chargingTime = Double.parseDouble(reader.readLine().split(":",2)[1].replace(" h", "").trim());

                        inventory.add(new ElectricCar(brand, model, horsePower, batteryCapacity, chargingType, chargingTime));
                    } else if (typeLine.equals("Gas")) {
                        double fuelTankCapacity = Double.parseDouble(reader.readLine().split(":",2)[1].replace(" L", "").trim());
                        String fuelType = reader.readLine().split(":",2)[1].trim();
                        String engineType = reader.readLine().split(":",2)[1].trim();

                        inventory.add(new GasCar(brand, model, horsePower, fuelTankCapacity, fuelType, engineType));
                    }
            }

            dealership.setInventory(inventory);

        } catch (IOException e) {
            throw new RuntimeException("Error reading from file" + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Malformed file content" + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error while parsing file" + e.getMessage());
        }
    }
}
