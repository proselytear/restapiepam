package ua.epam.restapidemo.respository;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

    public static Connection getConnection() {
        Properties prop = readPropertiesFile("src/main/resources/application.properties");
        final String JDBC_DRIVER = prop.getProperty("database.driver");
        final String DATABASE_URL = prop.getProperty("database.url");

        final String USER = prop.getProperty("database.username");
        final String PASSWORD = prop.getProperty("database.password");

        try {
            Class.forName(JDBC_DRIVER);
            return DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
         throw new RuntimeException("Unable to create connection for data: " + DATABASE_URL + ", " + USER + ", " + PASSWORD);
        }
    }

    private static Properties readPropertiesFile(String fileName) {
        Properties prop = null;
        try (FileInputStream fis = new FileInputStream(fileName)) {
            prop = new Properties();
            prop.load(fis);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return prop;
    }

}
