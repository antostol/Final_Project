package org.example;

import java.util.List;

public interface Searchable {

     /**
      * Filters the inventory of a dealership by brand
      * @param brand the input brand to filter
      * @return the list of cars that belong to that brand
      */
     List<Car> filterByBrand(String brand);

     /**
      * Filters the inventory of a dealership by model
      * @param model
      * @return the list of cars that are that model
      */
     List<Car> filterByModel(String model);
}
