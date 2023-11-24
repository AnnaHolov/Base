package org.example;

import org.example.model.User;
import org.example.model.UserExtractor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.dao.connection.JDBCConnection.getConnection;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserExtractor userExtractor = new UserExtractor();
        userExtractor.getUserbByID();
        userExtractor.getAllUsers();
        userExtractor.deleteUser();
        userExtractor.createUser();
        userExtractor.getAllUsers();
        userExtractor.editUser();
        userExtractor.getAllUsers();
    }


    }

