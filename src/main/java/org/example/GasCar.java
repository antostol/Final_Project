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

    /**
     * Compares car o to this car based off fuel tank capacity
     *
     * @param o the object to be compared.
     * @return 0 if the fuel tank capacity is the same
     * -1 if this car has a smaller fuel tank capacity than car o
     * 1 if this car has a higher fuel tank capacity than car o
     */
    @Override
    public int compareTo(Car o) {
        try {
            if (o == null) {
                throw new IllegalArgumentException("Car cannot be null");
            }
            if (!(o instanceof GasCar car)) {
                throw new ClassCastException("Car must be a GasCar");
            }
            return Double.compare(this.fuelTankCapacity, car.fuelTankCapacity);
        } catch (IllegalArgumentException | ClassCastException e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Unexpected error");
            return 0;
        }
    }

    /**
     * Compares input fuel vs fuel type to see if they're the same
     *
     * @param inputFuelType the input fuelType to be compared
     * @return true if the input fuel is the right fuel
     * false if the input fuel is the wrong fuel
     */
    public boolean isRightFuel(String inputFuelType) {
        try {
            if (inputFuelType == null || inputFuelType.isEmpty()) {
                throw new IllegalArgumentException("Input Fuel Type cannot be null or empty");
            }
            return this.fuelType.equalsIgnoreCase(inputFuelType);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Unexpected error");
            return false;
        }
    }

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
