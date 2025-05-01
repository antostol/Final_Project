package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DealershipTest {
    @Test
    public void testAddCar_NewCar() {
        Dealership dealership = new InPersonDealer(); // using concrete subclass
        Car car = new GasCar("Toyota", "Camry", 200, 50.0, "Gasoline", "V6");
        dealership.addCar(car);
        int expected = 1;
        int actual = dealership.getInventory().size();
        assertEquals(expected, actual);
    }

    @Test
    public void testAddCar_DuplicateCar() {
        Dealership dealership = new InPersonDealer();
        Car car = new ElectricCar("Tesla", "Model 3", 300, 5.0, "DC", 60.0);
        dealership.addCar(car);
        dealership.addCar(car);
        int expected = 2;
        int actual = dealership.getInventory().size();
        assertEquals(expected, actual);
    }

    @Test
    public void testAddCar_NullCar() {
        Dealership dealership = new InPersonDealer();
        dealership.addCar(null);
        int expected = 0;
        int actual = dealership.getInventory().size();
        assertEquals(expected, actual);
    }

    @Test
    public void testAddCar_MultipleCars() {
        Dealership dealership = new InPersonDealer();
        dealership.addCar(new GasCar("Ford", "Mustang", 450, 60, "Gasoline", "V8"));
        dealership.addCar(new ElectricCar("Nissan", "Leaf", 147, 7.5, "AC", 40));
        int expected = 2;
        int actual = dealership.getInventory().size();
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveCar_ExistingCar() {
        Dealership dealership = new InPersonDealer();
        Car car = new GasCar("Honda", "Civic", 180, 45, "Gasoline", "I4");
        dealership.addCar(car);
        dealership.removeCar(car);
        int expected = 0;
        int actual = dealership.getInventory().size();
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveCar_NonExistingCar() {
        Dealership dealership = new InPersonDealer();
        Car car = new ElectricCar("Chevy", "Bolt", 200, 8, "DC", 65);
        dealership.removeCar(car);
        int expected = 0;
        int actual = dealership.getInventory().size();
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveCar_MultipleCars() {
        Dealership dealership = new InPersonDealer();
        Car car1 = new GasCar("Mazda", "3", 155, 50, "Gasoline", "I4");
        Car car2 = new GasCar("Mazda", "6", 187, 55, "Gasoline", "I4");
        dealership.addCar(car1);
        dealership.addCar(car2);
        dealership.removeCar(car1);
        int expected = 1;
        int actual = dealership.getInventory().size();
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveCar_NullCar() {
        Dealership dealership = new InPersonDealer();
        dealership.removeCar(null);
        int expected = 0;
        int actual = dealership.getInventory().size();
        assertEquals(expected, actual);
    }

    @Test
    public void testFilterByBrand_OneMatch() {
        Dealership dealership = new InPersonDealer();
        dealership.addCar(new GasCar("Ford", "Explorer", 290, 70, "Gasoline", "V6"));
        dealership.addCar(new ElectricCar("Tesla", "Model S", 670, 1.5, "DC", 100));
        List<Car> result = dealership.filterByBrand("Ford");
        int expected = 1;
        int actual = result.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testFilterByBrand_MultipleMatches() {
        Dealership dealership = new InPersonDealer();
        dealership.addCar(new GasCar("Ford", "Fusion", 175, 50, "Gasoline", "I4"));
        dealership.addCar(new GasCar("Ford", "Mustang", 450, 60, "Gasoline", "V8"));
        List<Car> result = dealership.filterByBrand("Ford");
        int expected = 2;
        int actual = result.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testFilterByBrand_NoMatch() {
        Dealership dealership = new InPersonDealer();
        dealership.addCar(new ElectricCar("BMW", "i3", 170, 6, "AC", 42));
        List<Car> result = dealership.filterByBrand("Toyota");
        int expected = 0;
        int actual = result.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testFilterByBrand_CaseSensitive() {
        Dealership dealership = new InPersonDealer();
        dealership.addCar(new GasCar("TOYOTA", "Yaris", 105, 40, "Gasoline", "I4"));
        List<Car> result = dealership.filterByBrand("Toyota");
        int expected = 0;
        int actual = result.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testFilterByModel_OneMatch() {
        Dealership dealership = new InPersonDealer();
        dealership.addCar(new GasCar("Hyundai", "Elantra", 147, 50, "Gasoline", "I4"));
        List<Car> result = dealership.filterByModel("Elantra");
        int expected = 1;
        int actual = result.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testFilterByModel_MultipleMatches() {
        Dealership dealership = new InPersonDealer();
        dealership.addCar(new GasCar("Hyundai", "Elantra", 150, 45, "Gasoline", "I4"));
        dealership.addCar(new ElectricCar("Hyundai", "Elantra", 200, 6.5, "DC", 60));
        List<Car> result = dealership.filterByModel("Elantra");
        int expected = 2;
        int actual = result.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testFilterByModel_NoMatch() {
        Dealership dealership = new InPersonDealer();
        dealership.addCar(new ElectricCar("Audi", "e-tron", 355, 9.0, "DC", 95));
        List<Car> result = dealership.filterByModel("Model X");
        int expected = 0;
        int actual = result.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testFilterByModel_EmptyInventory() {
        Dealership dealership = new InPersonDealer();
        List<Car> result = dealership.filterByModel("Model Y");
        int expected = 0;
        int actual = result.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testOnlineDealerCompare_SameRating() {
        OnlineDealer d1 = new OnlineDealer("https://www.autotrader.com", "30 days", 4.5);
        OnlineDealer d2 = new OnlineDealer("https://www.cargurus.com", "14 days", 4.5);

        int expected = 0;
        int actual = d1.compare(d1, d2);
        assertEquals(expected, actual);
    }

    @Test
    public void testOnlineDealerCompare_LowerRating() {
        OnlineDealer d1 = new OnlineDealer("https://www.carfax.com", "7 days", 3.2);
        OnlineDealer d2 = new OnlineDealer("https://www.autobahnautomotive.com", "30 days", 4.8);

        int expected = -1;
        int actual = d1.compare(d1, d2);
        assertEquals(expected, actual);
    }

    @Test
    public void testOnlineDealerCompare_HigherRating() {
        OnlineDealer d1 = new OnlineDealer("https://www.vroom.com", "30 days", 4.9);
        OnlineDealer d2 = new OnlineDealer("https://www.carvana.com", "30 days", 3.9);

        int expected = 1;
        int actual = d1.compare(d1, d2);
        assertEquals(expected, actual);
    }

    @Test
    public void testOnlineDealerCompare_EdgeCaseDecimal() {
        OnlineDealer d1 = new OnlineDealer("https://www.shift.com", "15 days", 3.999);
        OnlineDealer d2 = new OnlineDealer("https://www.driveway.com", "15 days", 4.0);

        int expected = -1;
        int actual = d1.compare(d1, d2);
        assertEquals(expected, actual);
    }
}