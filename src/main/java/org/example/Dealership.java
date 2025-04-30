package org.example;

import java.util.Comparator;
import java.util.Objects;

public abstract class Dealership implements Comparator<Dealership> {
    protected String name;
    protected int phoneNumber;
    protected int inventory;

    public Dealership() {
        this.name = "Unknown";
        this.phoneNumber = 0;
        this.inventory = 0;
    }

    public Dealership(String name, int phoneNumber, int inventory) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.inventory = inventory;
    }

    public static void displayInfo() {}

    public static void addCar() {}

    public static void removeCar() {}

    @Override
    public int compare(Dealership o1, Dealership o2) {}

    @Override
    public String toString() {
        return "Dealership\n" +
                "Name: " + name + "\n" +
                "PhoneNumber: " + phoneNumber + "\n" +
                "Inventory: " + inventory;
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

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
