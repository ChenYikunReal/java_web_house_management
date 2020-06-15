package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DbUtil {

    private static final String USERNAME = "root";

    private static final String PASSWORD = "123456";

    private static final String URL = "jdbc:mysql://localhost:3306/fwtest?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

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
