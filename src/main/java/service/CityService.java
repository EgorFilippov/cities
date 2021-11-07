package service;

import entity.City;
import repositories.CityRepoImpl;

import java.util.List;
import java.util.Map;

public interface CityService {
    String addToDatabaseFromFile(String fileName);

    String addOneCity(City city);

    List<City> selectAllCities();

    List<City> selectSortedCitiesByName();

    List<City> selectSortedCitiesByNameAndDistrict();

    City selectCityWithMaxPopulation();

    Map<String, String> citiesCountInRegion();
}
