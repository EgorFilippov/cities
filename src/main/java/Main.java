import repositories.CityRepo;
import repositories.CityRepoImpl;
import service.CityServiceImpl;
import ui.ConsoleMenuImpl;
import ui.Menu;

import java.io.IOException;

public class Main

{

    public static void main(String[] args) throws IOException, InterruptedException {

        CityRepo cityRepo = new CityRepoImpl();
        CityServiceImpl cityServiceImpl = new CityServiceImpl(cityRepo);
        Menu consoleMenu = new ConsoleMenuImpl(cityServiceImpl);
        consoleMenu.startMenu();
    }
}
