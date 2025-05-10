package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InPersonDealer dealership = new InPersonDealer("09:00-17:00", "123 Main St", 5);

        while (true) {
            System.out.println("\n==== DEALERSHIP MENU ====");
            System.out.println("1. Add Electric Car");
            System.out.println("2. Add Gas Car");
            System.out.println("3. Display Inventory");
            System.out.println("4. Filter by Brand");
            System.out.println("5. Filter by Model");
            System.out.println("6. Save Inventory to File");
            System.out.println("7. Load Inventory from File");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addElectricCar(scanner, dealership);
                case 2 -> addGasCar(scanner, dealership);
                case 3 -> dealership.displayInfo();
                case 4 -> {
                    System.out.print("Enter brand: ");
                    String brand = scanner.nextLine();
                    dealership.filterByBrand(brand).forEach(System.out::println);
                }
                case 5 -> {
                    System.out.print("Enter model: ");
                    String model = scanner.nextLine();
                    dealership.filterByModel(model).forEach(System.out::println);
                }
                case 6 -> {
                    System.out.print("Filename to save: ");
                    String filename = scanner.nextLine();
                    try {
                        FileManager.writeToFile(dealership, filename);
                        System.out.println("Saved to " + filename);
                    } catch (Exception e) {
                        System.out.println("Error saving file: " + e.getMessage());
                    }
                }
                case 7 -> {
                    System.out.print("Filename to load: ");
                    String filename = scanner.nextLine();
                    try {
                        FileManager.readFromFile(dealership, filename);
                        System.out.println("Inventory loaded from " + filename);
                    } catch (Exception e) {
                        System.out.println("Error loading file: " + e.getMessage());
                    }
                }
                case 8 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void addElectricCar(Scanner scanner, InPersonDealer dealership) {
        System.out.print("Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Horsepower: ");
        int hp = Integer.parseInt(scanner.nextLine());
        System.out.print("Battery capacity (kWh): ");
        double capacity = Double.parseDouble(scanner.nextLine());
        System.out.print("Charging type: ");
        String type = scanner.nextLine();
        System.out.print("Charging time (h): ");
        double time = Double.parseDouble(scanner.nextLine());

        ElectricCar car = new ElectricCar(brand, model, hp, capacity, type, time);
        dealership.addCar(car);
        System.out.println("Electric car added.");
    }

    private static void addGasCar(Scanner scanner, InPersonDealer dealership) {
        System.out.print("Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Horsepower: ");
        int hp = Integer.parseInt(scanner.nextLine());
        System.out.print("Fuel tank capacity (L): ");
        double tank = Double.parseDouble(scanner.nextLine());
        System.out.print("Fuel type: ");
        String fuel = scanner.nextLine();
        System.out.print("Engine type: ");
        String engine = scanner.nextLine();

        GasCar car = new GasCar(brand, model, hp, tank, fuel, engine);
        dealership.addCar(car);
        System.out.println("Gas car added.");
    }
}