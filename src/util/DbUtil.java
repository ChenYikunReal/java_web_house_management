package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

class DbUtil {

    private static final String USERNAME;

    private static final String PASSWORD;

    private static final String URL;

    private static final String DRIVER;

    static {
        Properties properties = new Properties();
        try {
            properties.load(Objects.requireNonNull(DbUtil.class.getClassLoader().getResourceAsStream("db.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        USERNAME = properties.getProperty("username");
        PASSWORD = properties.getProperty("password");
        URL = properties.getProperty("url");
        DRIVER = properties.getProperty("driver");
    }

    static Connection getConnection() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
