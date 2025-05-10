package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class Dealership implements Comparator<Dealership>, Searchable {
    protected String name;
    protected int phoneNumber;
    protected List<Car> inventory;

    public Dealership() {
        this.name = "Unknown";
        this.phoneNumber = 0;
        this.inventory = new ArrayList<>();
    }

    public Dealership(String name, int phoneNumber, List<Car> inventory) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.inventory = inventory;
    }

    /**
     * Displays the dealership's name, phone number, and full list of cars from inventory
     * Formats the output in a user-friendly way
     */
    public void displayInfo() {
        System.out.println("==== DEALERSHIP INFO =====");
        System.out.println("Name          : " + this.name);
        System.out.println("Phone number  : " + this.phoneNumber);
        System.out.println("Inventory     : " + this.inventory.size() + " cars in stock");

        int count = 1;

        System.out.println("-- Electric cars--");
        for (Car car : this.inventory) {
            if (car instanceof ElectricCar electricCar) {
                System.out.println(count + ". " + electricCar.getBrand() + " " + electricCar.getModel() + " | " +
                        electricCar.getHorsePower() + " hp | " +
                        electricCar.getBatteryCapacity() + " kWh | " +
                        electricCar.getChargeTime() + "h charge");
                count++;
            }
        }

        System.out.println();

        System.out.println("-- Gas Cars--");
        for (Car car : this.inventory) {
            if (car instanceof GasCar gasCar) {
                System.out.println(count + ". " + gasCar.getBrand() + " " + gasCar.getModel() + " | " +
                        gasCar.getHorsePower() + " hp | " +
                        gasCar.getFuelTankCapacity() + " L | " +
                        gasCar.getEngineType() + " Engine");
                count++;
            }
        }
    }

    /**
     * Adds the input car to the inventory
     *
     * @param car the input car to be added
     */
    public void addCar(Car car) {
        this.inventory.add(car);
    }

    /**
     * Checks if car is in the inventory, removes it
     *
     * @param car the input car to be removed
     */
    public void removeCar(Car car) {
        this.inventory.remove(car);
    }

    /**
     * Compares dealership o1 to dealership o2 based first on their inventory count, and second their name
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return 0 if both dealerships have the same inventory size and same name
     * Negative if o1 has fewer cars/fewer cars + name doesn't come alphabetically before o2's
     * Positive if o1 has more cars/more cars + name comes alphabetically before o2's/more cars + names comes alphabetically after o2's
     */
    @Override
    public int compare(Dealership o1, Dealership o2) {
        try {
            if (o1 == null || o2 == null) {
                throw new IllegalArgumentException("Dealerships cannot be null");
            }
            if (o1.getInventory() == null || o2.getInventory() == null) {
                throw new IllegalStateException("Dealership inventory cannot be null");
            }
            if (o1.getName() == null || o2.getName() == null) {
                throw new IllegalStateException("Dealership name cannot be null");
            }
            return o1.getInventory().size() - o2.getInventory().size() * 1000 +
                    o1.getName().compareTo(o2.getName());
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Unexpected error");
            return 0;
        }
    }

    public List<Car> filterByBrand(String brand) {
        try {
            if (brand == null) {
                throw new IllegalArgumentException("Brand cannot be null");
            }
            return inventory.stream()
                    .filter(car -> brand.equalsIgnoreCase(car.getBrand()))
                    .toList();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return new ArrayList<>();
        } catch (NullPointerException e) {
            System.out.println("Error: Inventory is null");
            return new ArrayList<>();
        } catch (Exception e) {
            System.out.println("Unexpected error");
            return new ArrayList<>();
        }
    }

    public List<Car> filterByModel(String model) {
        try {
            if (model == null) {
                throw new IllegalArgumentException("Model cannot be null");
            }
            return inventory.stream()
                    .filter(car -> model.equalsIgnoreCase(car.getModel()))
                    .toList();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return new ArrayList<>();
        } catch (NullPointerException e) {
            System.out.println("Error: Inventory is null");
            return new ArrayList<>();
        } catch (Exception e) {
            System.out.println("Unexpected error");
            return new ArrayList<>();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dealership\n");
        sb.append("Name: ").append(name).append("\n");
        sb.append("Phone Number: ").append(phoneNumber).append("\n");
        sb.append("Inventory:\n");

        for (Car car : inventory) {
            sb.append("------------------\n");
            sb.append(car.toString()).append("\n");
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dealership dealership = (Dealership) o;
        return phoneNumber == dealership.phoneNumber &&
                Objects.equals(inventory, dealership.inventory) &&
                Objects.equals(name, dealership.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber, inventory);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Car> getInventory() {
        return inventory;
    }

    public void setInventory(List<Car> inventory) {
        this.inventory = inventory;
    }
}
