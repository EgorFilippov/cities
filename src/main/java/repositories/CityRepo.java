package repositories;

import entity.City;

import java.util.List;
import java.util.Map;

public interface CityRepo {
    String addToDatabase(String inputDraftStringData, String TABLE_NAME);
    String addOneCity(City city, String tableName);
    String createTable(String tableName);
    List<City> selectAllCities(String tableName);
    List<City> selectSortedCitiesByName(String tableName);
    List<City> selectSortedCitiesByNameAndDistrict(String tableName);
    City selectCityWithMaxPopulation(String tableName);
    Map<String, String> citiesCountInRegion(String tableName);
}
