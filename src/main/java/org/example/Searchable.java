package org.example;

import java.util.List;

public interface Searchable {

     List<Car> filterByBrand(String brand);

     List<Car> filterByModel(String model);
}
