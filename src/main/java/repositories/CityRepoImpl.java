package repositories;

import entity.City;
import util.ConnectToDBImpl;

import java.sql.*;
import java.util.*;

public class CityRepoImpl implements CityRepo {

    @Override
    public String addToDatabase(String inputDraftStringData, String tableName) {
        createTable(tableName);
        String sqlQuery = "INSERT INTO " + tableName + " (NAME, REGION, DISTRICT, POPULATION, FOUNDATION) VALUES ( ?, ?, ?, ?, ?)";
        String result = "";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = ConnectToDBImpl.getConnection().prepareStatement(sqlQuery);
            Scanner scan = new Scanner(inputDraftStringData);
            scan.useDelimiter(";");
            while (scan.hasNext()) {
                Scanner scan1 = new Scanner(scan.next());
                scan1.useDelimiter(",");
                StringBuilder sb = new StringBuilder();
                try {
                    preparedStatement.setString(1, scan1.next());
                    preparedStatement.setString(2, scan1.next());
                    preparedStatement.setString(3, scan1.next());
                    preparedStatement.setLong(4, scan1.nextLong());
                    preparedStatement.setInt(5, scan1.nextInt());
                    preparedStatement.executeUpdate();
                    result = "File successfully added to database";

                } catch (SQLException e) {
                    result = "Error: Add to DB error";
                    return result;
                }
            }
        } catch (SQLException e) {
            result = "Error: parsing file error";
            return result;
        }
        return result;
    }

    @Override
    public String addOneCity(City city, String tableName) {
        createTable(tableName);
        String sqlQuery = "INSERT INTO " + tableName + " (NAME, REGION, DISTRICT, POPULATION, FOUNDATION) VALUES ( ?, ?, ?, ?, ?)";
        String result;
        try (PreparedStatement preparedStatement = ConnectToDBImpl.getConnection().prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, city.getName());
            preparedStatement.setString(2, city.getRegion());
            preparedStatement.setString(3, city.getDistrict());
            preparedStatement.setLong(4, city.getPopulation());
            preparedStatement.setInt(5, city.getFoundation());
            preparedStatement.executeUpdate();
            result = "City successfully added to database";
        } catch (SQLException throwables) {
            return "Error: Adding to database error";
        }
        return result;
    }

    @Override
    public String createTable(String tableName) {
        String result;
        String sqlQuery = "CREATE TABLE IF NOT EXISTS " + tableName + " (ID INT NOT NULL AUTO_INCREMENT, NAME VARCHAR(255) NOT NULL, REGION VARCHAR(255) NOT NULL, DISTRICT VARCHAR(255) NOT NULL, POPULATION INT NOT NULL, FOUNDATION INT NOT NULL, PRIMARY KEY (ID, NAME))";
        try (PreparedStatement preparedStatement = ConnectToDBImpl.getConnection().prepareStatement(sqlQuery)) {
            preparedStatement.executeUpdate();
            result = "Table created";
        } catch (SQLException e) {
            return "Error: Creating table error";
        }
        return result;
    }

    @Override
    public List<City> selectAllCities(String tableName) {
        String sqlQuery = "SELECT * from " + tableName + ";";
        try (Statement statement = ConnectToDBImpl.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            List<City> cityList = new ArrayList<>();
            while (resultSet.next()) {
                City city = new City();
                city.setName(resultSet.getString(2));
                city.setRegion(resultSet.getString(3));
                city.setDistrict(resultSet.getString(4));
                city.setPopulation(resultSet.getInt(5));
                city.setFoundation(resultSet.getInt(6));
                cityList.add(city);
            }
            return cityList;
        } catch (SQLException e) {
            System.out.println("Ошибка считывания городов");
        }
        return null;
    }

    @Override
    public List<City> selectSortedCitiesByName(String tableName) {
        String sqlQuery = "SELECT * from " + tableName + " ORDER BY NAME;";
        try (Statement statement = ConnectToDBImpl.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            List<City> cityList = new ArrayList<>();
            while (resultSet.next()) {
                City city = new City();
                city.setName(resultSet.getString(2));
                city.setRegion(resultSet.getString(3));
                city.setDistrict(resultSet.getString(4));
                city.setPopulation(resultSet.getInt(5));
                city.setFoundation(resultSet.getInt(6));
                cityList.add(city);
            }
            return cityList;
        } catch (SQLException e) {
            System.out.println("Ошибка считывания или сортировки городов");
        }
        return null;
    }

    @Override
    public List<City> selectSortedCitiesByNameAndDistrict(String tableName) {
        String sqlQuery = "SELECT * from " + tableName + " ORDER BY DISTRICT, NAME;";
        try (Statement statement = ConnectToDBImpl.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            List<City> cityList = new ArrayList<>();
            while (resultSet.next()) {
                City city = new City();
                city.setName(resultSet.getString(2));
                city.setRegion(resultSet.getString(3));
                city.setDistrict(resultSet.getString(4));
                city.setPopulation(resultSet.getInt(5));
                city.setFoundation(resultSet.getInt(6));
                cityList.add(city);
            }
            return cityList;
        } catch (SQLException e) {
            System.out.println("Ошибка считывания или сортировки городов");
        }
        return null;
    }

    @Override
    public City selectCityWithMaxPopulation(String tableName) {
        String sqlQuery = "SELECT * from " + tableName + " WHERE POPULATION = (SELECT MAX (POPULATION) FROM " + tableName + ");";
        try (Statement statement = ConnectToDBImpl.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
            City city = new City();
            city.setName(resultSet.getString(2));
            city.setRegion(resultSet.getString(3));
            city.setDistrict(resultSet.getString(4));
            city.setPopulation(resultSet.getInt(5));
            city.setFoundation(resultSet.getInt(6));
            return city;
        } catch (SQLException e) {
            System.out.println("Ошибка получения данных");
        }
        return null;
    }

    @Override
    public Map<String, String> citiesCountInRegion(String tableName) {
        String sqlQuery = "SELECT DISTINCT REGION FROM " + tableName + ";";
        String sqlQuery1 = "SELECT COUNT(*) FROM " + tableName + " WHERE REGION=";
        Map<String, String> result = new HashMap<>();
        try (Statement statement = ConnectToDBImpl.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            List<City> cityList = new ArrayList<>();
            int counter = 0;
            while (resultSet.next()) {
                try (Statement statement1 = ConnectToDBImpl.getConnection().createStatement()) {
                    ResultSet resultSet1 = statement1.executeQuery(sqlQuery1 + "'" + resultSet.getString(1) + "';");
                    resultSet1.next();
                    result.put(resultSet.getString(1), String.valueOf(resultSet1.getInt(1)));

                } catch (SQLException e) {
                    System.out.println("Ошибка подсчет городов");
                }

            }

        } catch (SQLException e) {
            System.out.println("Ошибка подсчет регионов");
        }
        return result;
    }
}