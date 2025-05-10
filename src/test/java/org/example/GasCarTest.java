package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GasCarTest {
    @Test
    void testCompareTo_sameFuelTankCapacity() {
        GasCar car1 = new GasCar("Toyota", "Corolla", 130, 40.0, "Gasoline", "V4");
        GasCar car2 = new GasCar("Honda", "Civic", 120, 40.0, "Gasoline", "V4");
        int expected = 0;
        int actual = car1.compareTo(car2);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompareTo_smallerTank() {
        GasCar car1 = new GasCar("Toyota", "Corolla", 130, 30.0, "Gasoline", "V4");
        GasCar car2 = new GasCar("Honda", "Civic", 120, 40.0, "Gasoline", "V4");
        int expected = -1;
        int actual = car1.compareTo(car2);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompareTo_largerTank() {
        GasCar car1 = new GasCar("Toyota", "Corolla", 130, 50.0, "Gasoline", "V4");
        GasCar car2 = new GasCar("Honda", "Civic", 120, 40.0, "Gasoline", "V4");
        int expected = 1;
        int actual = car1.compareTo(car2);
        assertEquals(expected, actual);
    }

    @Test
    public void testCompareTo_differentCarType() {
        GasCar car1 = new GasCar("Ford", "Fusion", 175, 55.0, "Diesel", "V6");
        Car car2 = new GasCar("Mazda", "6", 180, 30.0, "Gasoline", "V4");
        int expected = 1;
        int actual = car1.compareTo(car2);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsRightFuel_NullInput() {
        GasCar gasCar = new GasCar("Toyota", "Corolla", 150, 50.0, "Gasoline", "V4");
        assertDoesNotThrow(() -> gasCar.isRightFuel(null));
    }

    @Test
    public void testIsRightFuel_match() {
        GasCar car = new GasCar("Toyota", "Camry", 150, 50.0, "Gasoline", "V6");
        boolean expected = true;
        boolean actual = car.isRightFuel("Gasoline");
        assertEquals(expected, actual);
    }

    @Test
    public void testIsRightFuel_mismatch() {
        GasCar car = new GasCar("Toyota", "Camry", 150, 50.0, "Gasoline", "V6");
        boolean expected = false;
        boolean actual = car.isRightFuel("Diesel");
        assertEquals(expected, actual);
    }

    @Test
    public void testIsRightFuel_caseInsensitive() {
        GasCar car = new GasCar("Toyota", "Camry", 150, 50.0, "Gasoline", "V6");
        boolean expected = true;
        boolean actual = car.isRightFuel("gasoline");
        assertEquals(expected, actual);
    }

    @Test
    public void testIsRightFuel_nullInput() {
        GasCar car = new GasCar("Toyota", "Camry", 150, 50.0, "Gasoline", "V6");
        boolean expected = false;
        boolean actual = car.isRightFuel(null);
        assertEquals(expected, actual);
    }

}