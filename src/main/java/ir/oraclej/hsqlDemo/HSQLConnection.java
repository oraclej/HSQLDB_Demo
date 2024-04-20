package ir.oraclej.hsqlDemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
//            Path p = Path.of(getClass().getClassLoader().getResource("init.sql").toURI());
//            String sql = Files.readString(p);
            String sql = "create table person(\n" +
                    "    id int identity,\n" +
                    "    name varchar(255),\n" +
                    "    family varchar(255),\n" +
                    "    age int\n" +
                    ")";
            connection.prepareStatement(sql).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
            return hsqlConnection.connection;
    }
}
