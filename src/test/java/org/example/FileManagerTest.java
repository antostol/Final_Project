package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {
    private static final String TEST_FIlE = "test_dealership.txt";

    private TestDealership dealership;

    @BeforeEach
    public void setUp() {
        dealership = new TestDealership();
    }

    @AfterEach
    public void cleanUp() {
        new File(TEST_FIlE).delete();
    }

    @Test
    public void testWriteToFileEmptyInventory() throws IOException {
        FileManager.writeToFile(dealership, TEST_FIlE);

        try (BufferedReader reader =  new BufferedReader(new FileReader(TEST_FIlE))) {
            String firstLine = reader.readLine();
            assertEquals("====Dealership inventory:====", firstLine);
        }
    }

    @Test
    public void testWriteToFileElectricCars() throws IOException {
        ElectricCar electricCar = new ElectricCar("Tesla", "Model S", 400, 100, "AC", 1.5);
        dealership.addCar(electricCar);
        FileManager.writeToFile(dealership, TEST_FIlE);

        try (BufferedReader reader =  new BufferedReader(new FileReader(TEST_FIlE))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Electric")) {
                    found = true;
                    break;
                }
            }
            assertTrue(found, "Electric car should be written in the file");
        }
    }

    @Test
    public void testWriteToFileGasCars() throws IOException {
        GasCar gasCar = new GasCar("Toyota", "Corolla", 150, 50, "Petrol", "V4");
        dealership.addCar(gasCar);
        FileManager.writeToFile(dealership, TEST_FIlE);

        try (BufferedReader reader =  new BufferedReader(new FileReader(TEST_FIlE))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Gas")) {
                    found = true;
                    break;
                }
            }
            assertTrue(found, "Gas car should be written in the file");
        }
    }

    @Test
    public void testWriteToFileWithMixedFuels() throws IOException {
        ElectricCar electricCar = new ElectricCar("Tesla", "Model S", 400, 100, "AC", 1.5);
        GasCar gasCar = new GasCar("Toyota", "Corolla", 150, 50, "Petrol", "V4");
        dealership.addCar(electricCar);
        dealership.addCar(gasCar);

        FileManager.writeToFile(dealership, TEST_FIlE);

        try (BufferedReader reader =  new BufferedReader(new FileReader(TEST_FIlE))) {
            String line;
            boolean foundElectric = false;
            boolean foundGas = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Electric")) {
                    foundElectric = true;
                }
                if (line.contains("Gas")) {
                    foundGas = true;
                }
            }
            assertTrue(foundElectric, "Electric car should be written in the file");
            assertTrue(foundGas, "Gas car should be written in the file");
        }
    }

    @Test
    public void testReadFromEmptyInventory() throws IOException {
        FileManager.writeToFile(dealership, TEST_FIlE);
        assertTrue(dealership.getInventory().isEmpty(), "Inventory should be empty");
    }

    @Test
    public void testReadFromFileElectricCars() throws IOException {
        ElectricCar electricCar = new ElectricCar("Tesla", "Model S", 400, 100, "AC", 1.5);
        FileManager.writeToFile(dealership, TEST_FIlE);
        dealership.getInventory().clear();
        FileManager.readFromFile(dealership, TEST_FIlE);

        assertEquals(1, dealership.getInventory().size(), "There should be 1 car in the inventory");
        assertTrue(dealership.getInventory().get(0) instanceof ElectricCar, "The car should be an electric car");
    }

    @Test
    public void testReadFromFileGasCars() throws IOException {
        GasCar gasCar = new GasCar("Toyota", "Corolla", 150, 50, "Petrol", "V4");
        FileManager.writeToFile(dealership, TEST_FIlE);
        dealership.getInventory().clear();
        FileManager.readFromFile(dealership, TEST_FIlE);

        assertEquals(1, dealership.getInventory().size(), "There should be 1 car in the inventory");
        assertTrue(dealership.getInventory().get(0) instanceof GasCar, "The car should be a gas car");
    }

    @Test
    public void testReadFromFileWithMixedInventory() throws IOException {
        ElectricCar electricCar = new ElectricCar("Tesla", "Model S", 400, 100, "AC", 1.5);
        GasCar gasCar = new GasCar("Toyota", "Corolla", 150, 50, "Petrol", "V4");
        dealership.addCar(electricCar);
        dealership.addCar(gasCar);

        FileManager.writeToFile(dealership, TEST_FIlE);
        dealership.getInventory().clear();
        FileManager.readFromFile(dealership, TEST_FIlE);

        assertEquals(2, dealership.getInventory().size(), "There should be 2 cars in the inventory");
    }

    @Test
    public void testReadFromFile_NonExistentFile() {
        Dealership dealership1 = new InPersonDealer();
        assertThrows(RuntimeException.class, () -> FileManager.readFromFile(dealership1, TEST_FIlE));
    }
}