package service;

import entity.City;
import repositories.CityRepoImpl;

import java.util.List;

public interface CityService {
    public String addToDatabaseFromFile (String fileName);
    public String addOneCity (City city);
    public List<City> selectAllCities ();
    public List<City> selectSortedCitiesByName();
    public List<City> selectSortedCitiesByNameAndDistrict();
}
