package ui;

import entity.City;
import service.CityServiceImpl;
import util.ReadCityFromConsole;

import java.util.List;
import java.util.Scanner;

public class ConsoleMenuImpl implements Menu {

    CityServiceImpl cityServiceImpl;

    public ConsoleMenuImpl(CityServiceImpl cityServiceImpl) {
        this.cityServiceImpl = cityServiceImpl;
    }

    @Override
    public void startMenu() {

        final String FILE_NAME = "./src/main/resources/cities.txt";

        while (true) {
            System.out.println("=== DB Worker Menu ===");
            System.out.println("1. Load database from file");
            System.out.println("2. Add city manually");
            System.out.println("3. Create table");
            System.out.println("4. Select all cities");
            System.out.println("5. Select sorted cities by name");
            System.out.println("6. Select sorted cities by name and district");
            System.out.println("7. Select city with max population");
            System.out.println("8. Cities count in regions");
            System.out.println("9. Exit");
            System.out.println("Press number key to continue...");
            int x;
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
                    } else {
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
                    } else {
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
                    } else {
                        System.out.println("No results");
                    }
                    break;
                }
                case 7: {
                    System.out.println(cityServiceImpl.selectCityWithMaxPopulation());
                    break;
                }
                case 8: {
                    System.out.println(cityServiceImpl.citiesCountInRegion());
                    break;
                }
                case 9: {
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
