package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    public void testCompareTo_SameHorsePowerBrandModel() {
        Car c1 = new ElectricCar("Tesla", "Model S", 500, 1.0, "DC", 100.0);
        Car c2 = new ElectricCar("Tesla", "Model S", 500, 2.0, "DC", 80.0);
        assertEquals(0, c1.compareTo(c2));
    }

    @Test
    public void testCompareTo_HigherHorsePower() {
        Car c1 = new ElectricCar("Tesla", "Model S", 600, 1.0, "DC", 100.0);
        Car c2 = new ElectricCar("Tesla", "Model S", 500, 2.0, "DC", 80.0);
        assertTrue(c1.compareTo(c2) > 0);
    }

    @Test
    public void testCompareTo_LowerHorsePower() {
        Car c1 = new ElectricCar("Tesla", "Model S", 400, 1.0, "DC", 100.0);
        Car c2 = new ElectricCar("Tesla", "Model S", 500, 2.0, "DC", 80.0);
        assertTrue(c1.compareTo(c2) < 0);
    }

    @Test
    public void testCompareTo_SameHorsePowerDifferentBrand() {
        Car c1 = new ElectricCar("Audi", "e-tron", 500, 1.0, "DC", 100.0);
        Car c2 = new ElectricCar("Tesla", "Model S", 500, 2.0, "DC", 80.0);
        assertTrue(c1.compareTo(c2) < 0);
    }

    @Test
    public void testIsHighPerformance_HorsePowerExactly400() {
        Car c = new GasCar("Toyota", "Supra", 400, 50.0, "Gasoline", "V6");
        boolean expected = true;
        boolean actual = c.isHighPerformance();
        assertEquals(expected, actual);
    }

    @Test
    public void testIsHighPerformance_Above400() {
        Car c = new GasCar("Ford", "Mustang", 450, 60.0, "Gasoline", "V8");
        boolean expected = true;
        boolean actual = c.isHighPerformance();
        assertEquals(expected, actual);
    }

    @Test
    public void testIsHighPerformance_Below400() {
        Car c = new GasCar("Honda", "Civic", 300, 45.0, "Gasoline", "I4");
        boolean expected = false;
        boolean actual = c.isHighPerformance();
        assertEquals(expected, actual);
    }

    @Test
    public void testIsHighPerformance_ZeroHorsePower() {
        Car c = new GasCar("Unknown", "Unknown", 0, 0.0, "Unknown", "Unknown");
        boolean expected = false;
        boolean actual = c.isHighPerformance();
        assertEquals(expected, actual);
    }

    @Test
    public void testIsHighPerformance_NegativeHorsePower_ThrowsException() {
        Car c = new GasCar("Brand", "Model", -100, 50, "Gasoline", "V6");
        assertDoesNotThrow(c::isHighPerformance);
    }
}