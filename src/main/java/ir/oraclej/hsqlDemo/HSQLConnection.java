package ir.oraclej.hsqlDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HSQLConnection {
    private static String url = "jdbc:hsqldb:file:D:\\hrdb.db";
    private static String driver = "org.hsqldb.jdbc.JDBCDriver";
    private static String username = "sa";
    private static String password = "password";

    private Connection connection;
    private static HSQLConnection hsqlConnection = new HSQLConnection();

    private HSQLConnection(){
        try {
//            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
            return hsqlConnection.connection;
    }
}
