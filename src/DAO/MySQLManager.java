package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLManager {
    public static Connection init() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/hadoop?serverTimezone=UTC";
        String username="root";
        String password="root";
        return (Connection) DriverManager.getConnection(url,username,password);
    }
}
