package org.example;

import java.io.Serializable;
import java.util.Objects;

public abstract class Car implements Comparable<Car> {
    protected String brand;
    protected String model;
    protected int horsePower;

    public Car() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.horsePower = 0;
    }

    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    /**
     * Compares car o to this car based on first horsepower, then brand, then model
     * @param o the object to be compared.
     * @return 0 if horsepower, brand and model are the same for this car and car o
     *         -1 if car o has lower horsepower/lower horsepower + brand/model that come alphabetically before/afterward car o's
     *         1 if car o has higher horsepower/higher horsepower + brand/model that come alphabetically before/afterward car o's
     */
    @Override
    public int compareTo(Car o) {
        return this.horsePower - o.horsePower * 1000
                + this.brand.compareTo(o.brand) * 100
                + this.model.compareTo(o.model);
    }

    /**
     * Verifies the performance of a car based off of its horsepower
     * 400 hp and less = isn't high performance; 400+ hp = is high performance
     * @return true if the car is high performance
     *         returns false if car isn't high performance
     */
    public boolean isHighPerformance() {
        try {
            if (this.horsePower < 0) {
                throw new IllegalArgumentException("Horse power cannot be less than zero");
            }

            return this.horsePower > 400;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public String toString() {
        return "Car\n" +
                "Brand: " + brand + "\n" +
                "Model: " + model + "\n" +
                "HorsePower: " + horsePower + "hp";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return horsePower == car.horsePower && Objects.equals(brand, car.brand) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, horsePower);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
