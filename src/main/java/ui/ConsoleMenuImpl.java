package ui;

import entity.City;
import repositories.CityRepoImpl;
import service.CityServiceImpl;
import util.ReadCityFromConsole;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenuImpl implements Menu {

    CityServiceImpl cityServiceImpl;
    CityRepoImpl cityRepoImpl;

    public ConsoleMenuImpl(CityServiceImpl cityServiceImpl) {
        this.cityServiceImpl = cityServiceImpl;
    }

    @Override
    public void startMenu() {

        final String FILE_NAME = "/Users/u19571094/IdeaProjects/testProject1/src/main/resources/cities.txt";

        while (true) {
            System.out.println("=== DB Worker Menu ===");
            System.out.println("1. Load database from file");
            System.out.println("2. Add city manually");
            System.out.println("3. Create table");
            System.out.println("4. Select all cities");
            System.out.println("5. Select sorted cities by name");
            System.out.println("6. Select sorted cities by name and district");
            System.out.println("7. Exit");
            System.out.println("Press number key to continue...");
            int x = 0;
            Scanner scanner = new Scanner(System.in);
            x = scanner.nextInt();

            switch (x) {
                case 1: {
                    System.out.println(cityServiceImpl.addToDatabaseFromFile(FILE_NAME));
                    break;
                }
                case 2: {
                    System.out.println(cityServiceImpl.addOneCity(ReadCityFromConsole.readFromConsole()));
                    break;
                }
                case 3: {
                    System.out.println(cityServiceImpl.createTable());
                    break;
                }
                case 4: {
                        List<City> city = cityServiceImpl.selectAllCities();
                        if (city != null) {
                            for (City c : city) {
                                System.out.println(c.toString());
                            }
                        }
                        else {
                            System.out.println("No results");
                        }
                    break;
                }
                case 5: {
                        List<City> city = cityServiceImpl.selectSortedCitiesByName();
                        if (city != null) {
                            for (City c : city) {
                                System.out.println(c.toString());
                            }
                        }
                        else {
                            System.out.println("No results");
                        }
                    break;
                }
                case 6: {
                    List<City> city = cityServiceImpl.selectSortedCitiesByNameAndDistrict();
                    if (city != null) {
                        for (City c : city) {
                            System.out.println(c.toString());
                        }
                    }
                    else {
                        System.out.println("No results");
                    }
                    break;
                }
                case 7: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Error: Choose item by number...");
                    break;
                }
            }
            System.out.println();
        }
    }
}
