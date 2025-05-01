package org.example;

import java.time.Clock;
import java.util.List;
import java.util.Objects;

public class InPersonDealer extends Dealership {
    private String storeHours;
    private String location;
    private int numberOfEmployees;

    public InPersonDealer() {
        this.storeHours = "Unknown";
        this.location = "Unknown";
        this.numberOfEmployees = 0;
    }

    public InPersonDealer(String storeHours, String location, int numberOfEmployees) {
        this.storeHours = storeHours;
        this.location = location;
        this.numberOfEmployees = numberOfEmployees;
    }

    public InPersonDealer(String name, int phoneNumber, List<Car> inventory, String storeHours, String location, int numberOfEmployees) {
        super(name, phoneNumber, inventory);
        this.storeHours = storeHours;
        this.location = location;
        this.numberOfEmployees = numberOfEmployees;
    }

    /**
     * Compares dealership o1 to dealership o2 based off number of employees
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return 0 if the number of employees is the same
     *         -1 if the first dealership has fewer employees than the second
     *         1 if the first dealership has more employees than the second
     */
    @Override
    public int compare(Dealership o1, Dealership o2) {}

    /**
     * Checks if dealership is opened based off the store hours and the given system clock
     * @return true if the store is opened
     *         false if the store isn't opened
     */
    public boolean isOpen(Clock clock) {}

    /**
     * Verifies if input location matches with the store location
     * @param location the input location
     * @return true if the input location matches with the store location
     *         false if the input location doesn't match with the store location
     */
    public boolean isLocated(String location) {}

    @Override
    public String toString() {
        return "In Person Dealer\n" +
                "Store hours: " + storeHours + "\n" +
                "Location: " + storeHours + "\n" +
                "Number of employees " + numberOfEmployees + "\n" +
                super.toString().replace("Dealership", "");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        InPersonDealer that = (InPersonDealer) o;
        return numberOfEmployees == that.numberOfEmployees && Objects.equals(storeHours, that.storeHours) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), storeHours, location, numberOfEmployees);
    }

    public String getStoreHours() { return storeHours; }

    public void setStoreHours(String storeHours) {
        this.storeHours = storeHours;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }
}
