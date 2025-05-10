package org.example;

import java.time.DateTimeException;
import java.time.LocalTime;
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
     * Compares in person dealer o1 to in person dealer o2 based off number of employees
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return 0 if the number of employees is the same
     *         -1 if the first in person dealer has fewer employees than the second
     *         1 if the first in person dealer has more employees than the second
     */
    @Override
    public int compare(Dealership o1, Dealership o2) {
        try {
            if (!(o1 instanceof InPersonDealer || o2 instanceof InPersonDealer)) {
                throw new ClassCastException("Both dealerships must be in person dealers in order to be compared");
            }

            InPersonDealer inPerson1 = (InPersonDealer) o1;
            InPersonDealer inPerson2 = (InPersonDealer) o2;

            return Integer.compare(inPerson1.getNumberOfEmployees(), inPerson2.getNumberOfEmployees());
        } catch (ClassCastException e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Unexpected error");
            return 0;
        }
    }

    /**
     * Checks if dealership is opened based off the store hours and the given system clock
     * @return true if the store is opened
     *         false if the store isn't opened
     */
    public boolean isOpen(LocalTime currentTime) {
        try {
            String[] parts = storeHours.split("-");
            if (parts.length != 2) {
                throw new IllegalArgumentException("Store hours must be in format HH:mm-HH:mm");
            }
            LocalTime openTime = LocalTime.parse(parts[0]);
            LocalTime closeTime = LocalTime.parse(parts[1]);

            return !currentTime.isBefore(openTime) && !currentTime.isAfter(closeTime);
        } catch (DateTimeException e) {
            System.out.println("Error: Invalid time format");
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Unexpected error");
            return false;
        }
    }

    /**
     * Verifies if input location matches with the store location
     * @param location the input location
     * @return true if the input location matches with the store location
     *         false if the input location doesn't match with the store location
     */
    public boolean isLocated(String location) {
        try {
            if (location == null || location.trim().isEmpty()) {
                throw new IllegalArgumentException("Location cannot be null or empty");
            }
            if (!this.location.equalsIgnoreCase(location)) {
                System.out.println("Location does not match store location");
                return false;
            } else {
                System.out.println("Location matches store location");
                return true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Unexpected error");
            return false;
        }
    }

    @Override
    public String toString() {
        return "In Person Dealer\n" +
                "Store hours: " + storeHours + "\n" +
                "Location: " + location + "\n" +
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
