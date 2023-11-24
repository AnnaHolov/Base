package org.example.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

    private final static String URL = "jdbc:postgresql://localhost:5432/auth";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "test";
    //url (localhost5432)

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
