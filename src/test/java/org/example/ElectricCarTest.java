package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElectricCarTest {
    @Test
    public void testCompareTo_SameChargeTimeAndBattery() {
        ElectricCar car1 = new ElectricCar("Tesla", "Model S", 670, 5.5, "AC", 75);
        ElectricCar car2 = new ElectricCar("Tesla", "Model S", 670, 5.5, "AC", 75);
        int expected = 0;
        int actual = car1.compareTo(car2);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompareTo_LowerChargeTime() {
        ElectricCar car1 = new ElectricCar("Tesla", "Model 3", 480, 4.0, "DC", 70);
        ElectricCar car2 = new ElectricCar("Tesla", "Model X", 480, 6.0, "DC", 70);
        int expected = 1;
        int actual = car1.compareTo(car2);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompareTo_HigherChargeTime() {
        ElectricCar car1 = new ElectricCar("Tesla", "Model Y", 480, 7.0, "AC", 60);
        ElectricCar car2 = new ElectricCar("Tesla", "Model 3", 480, 5.0, "AC", 60);
        int expected = -1;
        int actual = car1.compareTo(car2);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompareTo_SameChargeTimeLowerBattery() {
        ElectricCar car1 = new ElectricCar("Tesla", "Model 3", 480, 6.0, "DC", 60);
        ElectricCar car2 = new ElectricCar("Tesla", "Model X", 480, 6.0, "DC", 80);
        int expected = -1;
        int actual = car1.compareTo(car2);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompareTo_InvalidType_ReturnsZero() {
        ElectricCar e = new ElectricCar("Tesla", "Model S", 500, 3.0, "DC", 60);
        Car gasCar = new GasCar("Toyota", "Camry", 150, 50.0, "Gasoline", "V6");

        int result = e.compareTo(gasCar);
        assertEquals(0, result);
    }

    @Test
    public void testIsFastCharging_TrueBoundary() {
        ElectricCar car = new ElectricCar(5.9, "AC", 70);
        boolean expected = true;
        boolean actual = car.isFastCharging();
        assertEquals(expected, actual);
    }

    @Test
    public void testIsFastCharging_FalseBoundary() {
        ElectricCar car = new ElectricCar(6.0, "DC", 70);
        boolean expected = false;
        boolean actual = car.isFastCharging();
        assertEquals(expected, actual);
    }

    @Test
    public void testIsFastCharging_LowTime() {
        ElectricCar car = new ElectricCar(3.5, "DC", 50);
        boolean expected = true;
        boolean actual = car.isFastCharging();
        assertEquals(expected, actual);
    }

    @Test
    public void testIsFastCharging_HighTime() {
        ElectricCar car = new ElectricCar(8.0, "AC", 60);
        boolean expected = false;
        boolean actual = car.isFastCharging();
        assertEquals(expected, actual);
    }

    @Test
    public void testIsLowRange_TrueBoundary() {
        ElectricCar car = new ElectricCar(5.0, "AC", 39.9);
        boolean expected = true;
        boolean actual = car.isLowRange();
        assertEquals(expected, actual);
    }

    @Test
    public void testIsLowRange_FalseBoundary() {
        ElectricCar car = new ElectricCar(5.0, "DC", 40.0);
        boolean expected = false;
        boolean actual = car.isLowRange();
        assertEquals(expected, actual);
    }

    @Test
    public void testIsLowRange_HighCapacity() {
        ElectricCar car = new ElectricCar(5.0, "AC", 75.0);
        boolean expected = false;
        boolean actual = car.isLowRange();
        assertEquals(expected, actual);
    }

    @Test
    public void testIsLowRange_LowCapacity() {
        ElectricCar car = new ElectricCar(5.0, "DC", 20.0);
        boolean expected = true;
        boolean actual = car.isLowRange();
        assertEquals(expected, actual);
    }

    @Test
    public void testIsLowRange_NegativeBatteryCapacity() {
        ElectricCar car = new ElectricCar(5.0, "AC", -10.0);
        assertDoesNotThrow(car::isLowRange);
    }

}