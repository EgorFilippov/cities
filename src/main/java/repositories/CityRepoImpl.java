package repositories;
import entity.City;
import util.ConnectToDBImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityRepoImpl implements CityRepo {

    @Override
    //онли сити обжект инпут
    public String addToDatabase(String inputDraftStringData, String tableName) {
        createTable(tableName);
        String sqlQuery = "INSERT INTO " + tableName + " (NAME, REGION, DISTRICT, POPULATION, FOUNDATION) VALUES ( ?, ?, ?, ?, ?)";
        String result = "";
        PreparedStatement preparedStatement;
        //connect and statement from try w res
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
                    preparedStatement.setLong(4, Long.valueOf(scan1.next()));
                    preparedStatement.setInt(5, Integer.valueOf(scan1.next()));
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
        String result = "City added successful";
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
        String result = "Error: Creating table error";
        String sqlQuery = "CREATE TABLE IF NOT EXISTS " + tableName + " (ID INT NOT NULL AUTO_INCREMENT, NAME VARCHAR(255) NOT NULL, REGION VARCHAR(255) NOT NULL, DISTRICT VARCHAR(255) NOT NULL, POPULATION INT NOT NULL, FOUNDATION INT NOT NULL, PRIMARY KEY (ID, NAME))";
        try (PreparedStatement preparedStatement = ConnectToDBImpl.getConnection().prepareStatement(sqlQuery)) {
            preparedStatement.executeUpdate();
            result = "Table created";
        }
        catch (SQLException e){
            return "Error: Creating table error";
        }
        return result;
    }

    @Override
    public List<City> selectAllCities(String tableName) {
        String sqlQuery = "SELECT * from " + tableName + ";";
        try (Statement statement = ConnectToDBImpl.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            List <City> cityList = new ArrayList<>();
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
        }
        catch (SQLException e){
        }
        return null;
    }

    @Override
    public List<City> selectSortedCitiesByName(String tableName) {
        String sqlQuery = "SELECT * from " + tableName + " ORDER BY NAME ASC;";
        try (Statement statement = ConnectToDBImpl.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            List <City> cityList = new ArrayList<>();
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
        }
        catch (SQLException e){
        }
        return null;
    }

    @Override
    public List<City> selectSortedCitiesByNameAndDistrict(String tableName) {
        String sqlQuery = "SELECT * from " + tableName + " ORDER BY DISTRICT ASC, NAME ASC;";
        try (Statement statement = ConnectToDBImpl.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            List <City> cityList = new ArrayList<>();
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
        }
        catch (SQLException e){
        }
        return null;
    }
}