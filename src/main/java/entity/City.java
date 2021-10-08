package entity;

public class City {

    public City(String name, String region, String district, int population, int foundation) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    public City () {

    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setFoundation(int foundation) {
        this.foundation = foundation;
    }

    public int getFoundation() {
        return foundation;
    }


    private String name;
    private String region;
    private String district;
    private int population;
    private int foundation;


    @Override
    public String toString() {
        return ("City{name=" + "\'" + name + "\', " + "region=" + "\'" + region + "\', " + "district=" + "\'" + district + "\', " + "population=" + population + ", " + "foundation=" + "\'" + foundation + "\'}");
    }

}
