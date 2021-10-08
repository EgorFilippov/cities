import repositories.CityRepo;
import repositories.CityRepoImpl;
import service.CityServiceImpl;
import ui.ConsoleMenuImpl;
import ui.Menu;

import java.io.IOException;
import java.sql.SQLException;

public class Main

{

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, InterruptedException {

        CityRepo cityRepo = new CityRepoImpl();
        CityServiceImpl cityServiceImpl = new CityServiceImpl(cityRepo);
        Menu consoleMenu = new ConsoleMenuImpl(cityServiceImpl);
//        Menu consoleMenu = new ConsoleMenu(cityServiceImpl, cityRepoImpl);
        consoleMenu.startMenu();
    }
}
