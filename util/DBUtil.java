package com.crud.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    // Replace these with your actual MySQL database URL, user, and password
    private static final String URL = "jdbc:derby://localhost:1527/DB;create=true";
    private static final String USER = "user"; // replace with your database username
    private static final String PASSWORD = "123"; // replace with your database password

    // Load the MySQL JDBC driver
    static {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found. Include it in your library path.", e);
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            if (connection != null) {
                System.out.println("Connection successful!");
            } else {
                System.out.println("Failed to connect.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
