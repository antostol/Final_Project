package org.example;

import java.util.Objects;

public class ElectricCar extends Car {
    private double chargeTime;
    private String chargingType;
    private double batteryCapacity;

    public ElectricCar() {
        this.chargeTime = 0.0;
        this.chargingType = "Unknown";
        this.batteryCapacity = 0.0;
    }

    public ElectricCar(double chargeTime, String chargingType, double batterCapacity) {
        this.chargeTime = chargeTime;
        this.chargingType = chargingType;
        this.batteryCapacity = batterCapacity;
    }

    public ElectricCar(String brand, String model, int horsePower, double chargeTime, String chargingType, double batterCapacity) {
        super(brand, model, horsePower);
        this.chargeTime = chargeTime;
        this.chargingType = chargingType;
        this.batteryCapacity = batterCapacity;
    }

    /**
     * Compares car o to this car based off charge time then battery capacity
     * @param o the object to be compared.
     * @return 0 if both the charge time and battery capacity of car o and this car are the same
     *         -1 if this car has higher charging time/higher charging time + lower battery capactiy/higher battery capacity than car o
     *         1 if this car has lower charging time/lower charging time + lower batter capacity/higher batter capacity than car o
     */
    @Override
    public int compareTo(Car o) {
    }

    /**
     * Verifies the charging speed of an electric car based on its charging time
     * 6+ hours = not fast charging; 6- hours = fast charging
     * @return true if the electric car is fast charging
     *         false if the electric car isn't fast charging
     */
    public boolean isFastCharging() {}

    /**
     * Verifies the range of an electric car based on its battery capacity
     * 40- kWh = low range; 40+ kWh = high range
     * @return true if the electric car is low range
     *         false if the electric car is high range
     */
    public boolean isLowRange() {}

    @Override
    public String toString() {
        return "Electric Car\n" +
                "Charge Time: " + chargeTime + " hours\n" +
                "Charging Type: " + chargingType + "\n" +
                "Battery Capacity: " + batteryCapacity + " kWh\n" +
                super.toString().replace("Car", "");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ElectricCar that = (ElectricCar) o;
        return Double.compare(chargeTime, that.chargeTime) == 0 && Double.compare(batteryCapacity, that.batteryCapacity) == 0 && Objects.equals(chargingType, that.chargingType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), chargeTime, chargingType, batteryCapacity);
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

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }
}
