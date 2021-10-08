package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDBImpl {
    public static Connection getConnection()  {
        final String TABLE_NAME = "CITIES_TABLE";
        final String DB_URL = "jdbc:h2:/Users/u19571094/IdeaProjects/testProject1";
        final String DB_Driver = "org.h2.Driver";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL);
            Class.forName(DB_Driver);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: database not available");
        }
        return connection;
    }
}
