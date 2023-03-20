package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/employeemanage?useUnicode=yes&characterEncoding=UTF-8";
    private static final String userNguyen = "root";
    private static final String passNguyen = "Nguyen251096*";
    public static Connection getConnection()
    {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, userNguyen, passNguyen);
            System.out.println("connection successfully");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
