package org.example;

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

    public InPersonDealer(String name, int phoneNumber, int inventory, String storeHours, String location, int numberOfEmployees) {
        super(name, phoneNumber, inventory);
        this.storeHours = storeHours;
        this.location = location;
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public int compare(Dealership o1, Dealership o2) {}

    public static boolean isOpen() {}

    public static boolean isLocated() {}

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

    public String getStoreHours() {
        return storeHours;
    }

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
