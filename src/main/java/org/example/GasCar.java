package org.example;

import java.util.Objects;

public class GasCar extends Car {
    private double fuelTankCapacity;
    private String fuelType;
    private String engineType;

    public GasCar() {
        this.fuelTankCapacity = 0.0;
        this.fuelType = "Unknown";
        this.engineType = "Unknown";
    }

    public GasCar(double fuelTankCapacity, String fuelType, String engineType) {
        this.fuelTankCapacity = fuelTankCapacity;
        this.fuelType = fuelType;
        this.engineType = engineType;
    }

    public GasCar(String brand, String model, int horsePower, double fuelTankCapacity, String fuelType, String engineType) {
        super(brand, model, horsePower);
        this.fuelTankCapacity = fuelTankCapacity;
        this.fuelType = fuelType;
        this.engineType = engineType;
    }

    @Override
    public int compareTo(Car o) {
    }

    public static boolean isRightFuel() {}

    @Override
    public String toString() {
        return "Gas Car\n" +
                "Fuel tank capacity: " + fuelTankCapacity + " L\n" +
                "Fuel type " + fuelType + "\n" +
                "Engine type: " + engineType + "\n" +
                super.toString().replace("Car", "");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GasCar gasCar = (GasCar) o;
        return Double.compare(fuelTankCapacity, gasCar.fuelTankCapacity) == 0 && Objects.equals(fuelType, gasCar.fuelType) && Objects.equals(engineType, gasCar.engineType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fuelTankCapacity, fuelType, engineType);
    }

    public double getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public void setFuelTankCapacity(double fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}
