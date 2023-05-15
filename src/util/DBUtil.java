package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getConnection() throws Exception {
        try {
            //1. Register JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2. Create connection
           Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Assigment_JDBC","sa","12345678");

            System.out.println("connected to DB");

            return conn;

        } catch(Exception e) {
            throw new Exception("Connection failed");
        }
    }

}
