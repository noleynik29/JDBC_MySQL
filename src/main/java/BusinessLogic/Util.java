package BusinessLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    public Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection ok");
        } catch (SQLException exception){
            exception.printStackTrace();
            System.out.println("Connection error!");
        }
        return connection;
    }
}
