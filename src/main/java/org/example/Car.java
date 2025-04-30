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

    @Override
    public int compareTo(Car o) {};

    public static boolean matches(String brand, String model) {}

    public static boolean isHighPerformance() {}

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
