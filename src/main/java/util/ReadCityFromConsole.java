package util;

import entity.City;

import java.util.Scanner;

public class ReadCityFromConsole {
    public static City readFromConsole () {
        Scanner scanner = new Scanner(System.in);
        City city = new City();

        System.out.println("==== Manual city adding ====");

        System.out.print("Enter city: ");
        city.setName(scanner.nextLine());

        System.out.print("Enter region: ");
        city.setRegion(scanner.nextLine());

        System.out.print("Enter district: ");
        city.setDistrict(scanner.nextLine());

        System.out.print("Enter population: ");
        city.setPopulation(scanner.nextInt());

        System.out.print("Enter foundation: ");
        city.setFoundation(scanner.nextInt());

        return city;
    }
}
