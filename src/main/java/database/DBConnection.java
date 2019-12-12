package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection conn;

    public static Connection get() throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://ec2-174-129-255-72.compute-1.amazonaws.com/dd5jboni9dpg7h",
                    "lktkgqkemluryv",
                    "ff6190a0bae6a3718fc03ed7bd30d62dafaf01ece4e86d2e92d3c5aa0fa8360d"
            );
        }
        return conn;
    }
}
