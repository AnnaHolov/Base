package org.example.model;

import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.dao.connection.JDBCConnection.getConnection;

public class UserExtractor {
    List<User> users;
    Connection connection;

    public UserExtractor() {
        this.users = new ArrayList<>();
        this.connection = getConnection();
    }


    public void getUserbByID() {
        users.clear();
        System.out.println("Get user by id");
        //    Statement statement= connection.createStatement();
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 3);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                User user = new User();
                user.setPassword(resultSet.getString("password"));
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));

                users.add(user);

            }
            System.out.println(users);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void getAllUsers() throws SQLException {
        users.clear();
        System.out.println("Get all users");
        String sql = "SELECT * FROM users ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));

                users.add(user);
            }
            System.out.println(users);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void deleteUser() {
        System.out.println("Delete user");
        String sql = "DELETE FROM users WHERE id = (select max(id) from users)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeQuery();
            System.out.println("User deleted");
        } catch (SQLException e) {
        }

    }

    public void createUser() {
        System.out.println("Add user");
        String sql = "INSERT INTO Users ( username, password) " +
                "VALUES ('Dean', 'Winchester')";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.executeQuery();

        } catch (SQLException e) {
        }

    }

    public void editUser(){
        System.out.println("Edit user");
        String sql = "UPDATE users  SET username = 'new name' WHERE id ='6'";


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.executeQuery();

        } catch (SQLException e) {
        }


    }
}
