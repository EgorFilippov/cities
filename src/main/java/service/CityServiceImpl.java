package service;

import entity.City;
import repositories.CityRepo;
import util.ReadFile;

import java.util.List;
import java.util.Map;

public class CityServiceImpl implements CityService {

    CityRepo cityRepo;
    String tableName = "CITIES_TABLE";

    public CityServiceImpl (CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    public String addToDatabaseFromFile(String fileName) {
        String inputDraftStringData = ReadFile.read(fileName);
        return cityRepo.addToDatabase(inputDraftStringData, tableName);
    }

    public String addOneCity(City city) {
        return cityRepo.addOneCity(city, tableName);
    }

    public String createTable() {
        return cityRepo.createTable(tableName);
    }

    public List<City> selectAllCities () {
        return cityRepo.selectAllCities(tableName);
    }

    public List<City> selectSortedCitiesByName() {
        return cityRepo.selectSortedCitiesByName(tableName);
    }

    public List<City> selectSortedCitiesByNameAndDistrict() {
        return cityRepo.selectSortedCitiesByNameAndDistrict(tableName);
    }

    public City selectCityWithMaxPopulation() {
        return cityRepo.selectCityWithMaxPopulation(tableName);
    }

    public Map<String, String> citiesCountInRegion() {
        return cityRepo.citiesCountInRegion(tableName);
    }
}