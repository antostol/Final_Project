package org.example;

import java.util.Objects;

public class ElectricCar extends Car {
    private double chargeTime;
    private String chargingType;
    private double batterCapacity;

    public ElectricCar() {
        this.chargeTime = 0.0;
        this.chargingType = "Unknown";
        this.batterCapacity = 0.0;
    }

    public ElectricCar(double chargeTime, String chargingType, double batterCapacity) {
        this.chargeTime = chargeTime;
        this.chargingType = chargingType;
        this.batterCapacity = batterCapacity;
    }

    public ElectricCar(String brand, String model, int horsePower, double chargeTime, String chargingType, double batterCapacity) {
        super(brand, model, horsePower);
        this.chargeTime = chargeTime;
        this.chargingType = chargingType;
        this.batterCapacity = batterCapacity;
    }

    @Override
    public int compareTo(Car o) {}

    public static boolean isFastCharging() {}

    public static boolean isLowRange() {}

    @Override
    public String toString() {
        return "Electric Car\n" +
                "Charge Time: " + chargeTime + " hours\n" +
                "Charging Type: " + chargingType + "\n" +
                "Battery Capacity: " + batterCapacity + " kWh\n" +
                super.toString().replace("Car", "");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ElectricCar that = (ElectricCar) o;
        return Double.compare(chargeTime, that.chargeTime) == 0 && Double.compare(batterCapacity, that.batterCapacity) == 0 && Objects.equals(chargingType, that.chargingType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), chargeTime, chargingType, batterCapacity);
    }

    public double getChargeTime() {
        return chargeTime;
    }

    public void setChargeTime(double chargeTime) {
        this.chargeTime = chargeTime;
    }

    public String getChargingType() {
        return chargingType;
    }

    public void setChargingType(String chargingType) {
        this.chargingType = chargingType;
    }

    public double getBatterCapacity() {
        return batterCapacity;
    }

    public void setBatterCapacity(double batterCapacity) {
        this.batterCapacity = batterCapacity;
    }
}
