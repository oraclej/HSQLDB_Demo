package ir.oraclej.hsqlDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.stream.Collectors;

public class HSQLConnection {
//    private static String url = "jdbc:hsqldb:file:D:\\hrdb.db";
    private static String url = "jdbc:hsqldb:mem:.";
    private static String driver = "org.hsqldb.jdbc.JDBCDriver";
    private static String username = "sa";
    private static String password = "password";

    private Connection connection;
    private static HSQLConnection hsqlConnection = new HSQLConnection();

    private HSQLConnection(){
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            initScript();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initScript() {
        try {
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("init.sql");
            InputStreamReader i = new InputStreamReader(resourceAsStream);
            BufferedReader br = new BufferedReader(i);
            String sql = br.lines().collect(Collectors.joining("\n"));
            connection.prepareStatement(sql).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
            return hsqlConnection.connection;
    }
}
