package com.crud.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crud.model.User;

/**
 * UsersDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 */
public class UsersDAO {
    private String jdbcURL = "jdbc:derby://localhost:1527/DB;create=true";
    private String jdbcUsername = "user";
    private String jdbcPassword = "123";

    private static final String INSERT_USER_SQL = "INSERT INTO users (username, password, email, first_name, middle_name, last_name) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE user_id = ?";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users";
    private static final String DELETE_USER_SQL = "DELETE FROM users WHERE user_id = ?";
    private static final String UPDATE_USER_SQL = "UPDATE users SET username = ?, password = ?, email = ?, first_name = ?, middle_name = ?, last_name = ? WHERE user_id = ?";

    public UsersDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

 // Updated insertUser method in UsersDAO
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USER_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getMiddleName());
            preparedStatement.setString(6, user.getLastName());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }


    public User selectUser(int userId) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, userId);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String firstName = rs.getString("first_name");
                String middleName = rs.getString("middle_name");
                String lastName = rs.getString("last_name");
                user = new User(userId, username, password, email, firstName, middleName, lastName); // use correct constructor
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String firstName = rs.getString("first_name");
                String middleName = rs.getString("middle_name");
                String lastName = rs.getString("last_name");
                User user = new User(userId, username, password, email, firstName, middleName, lastName); // use correct constructor
                users.add(user);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    public boolean deleteUser(int userId) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL)) {
            statement.setInt(1, userId);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
            rowDeleted = false;
        }
        return rowDeleted;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SQL)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getMiddleName());
            statement.setString(6, user.getLastName());
            statement.setInt(7, user.getUserId());
            System.out.println("updated User:" + statement);
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
            rowUpdated = false;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
