package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

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
    public void displayInfo() {}

    /**
     * Adds the input car to the inventory
     * @param car the input car to be added
     */
    public void addCar(Car car) {}

    /**
     * Checks if car is in the inventory, removes it
     * @param car the input car to be removed
     */
    public void removeCar(Car car) {}

    /**
     * Compares dealership o1 to dealership o2 based first on their inventory count, and second their name
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return 0 if both dealerships have the same inventory size and same name
     *         -1 if o1 has fewer cars/fewer cars + name doesn't come alphabetically before o2's
     *         1 if o1 has more cars/more cars + name comes alphabetically before o2's/more cars + names comes alphabetically after o2's
     */
    @Override
    public int compare(Dealership o1, Dealership o2) {}

    public List<Car> filterByBrand(String brand) {}

    public List<Car> filterByModel(String model) {}

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
        return phoneNumber == dealership.phoneNumber && inventory == dealership.inventory && Objects.equals(name, dealership.name);
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
