package repositories;

import entity.City;

import java.util.List;

public interface CityRepo {
    public String addToDatabase(String inputDraftStringData, String TABLE_NAME);
    public String addOneCity(City city, String tableName);
    public String createTable(String tableName);
    public List<City> selectAllCities(String tableName);
    public List<City> selectSortedCitiesByName(String tableName);
    public List<City> selectSortedCitiesByNameAndDistrict(String tableName);

}
