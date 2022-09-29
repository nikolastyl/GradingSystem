package com.example.javabasics.model;

import com.example.javabasics.Utility.DatabaseManager;
import com.example.javabasics.Utility.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Secretary extends User /*implements IDatabaseSupport*/{

    public Secretary(int id, String username, String password, String name, String surname) {
        super(id, username, password, name, surname);
    }

    public Secretary(ResultSet resultSet) {
        try {
            DatabaseManager databaseManager = new DatabaseManager();
            Connection connection = databaseManager.getConnection();
            id = resultSet.getInt("id");
            username= resultSet.getString("username");
            name= resultSet.getString("name");
            surname= resultSet.getString("surname");
            password= resultSet.getString("password");
            databaseManager.closeConnection();
        } catch (SQLException ex) {
            System.out.println("An error occurred while creating scheduled appointment from result set");
            System.out.println(ex.toString());
        }

    }

    public static Secretary getFromDatabase(Query query) {
        try {
            ResultSet resultSet = query.getStatement().executeQuery();

            Secretary secretary = null;
            if (resultSet.next()) {
                secretary = new Secretary(resultSet);
            }

            query.getStatement().close();
            return secretary;
        } catch (SQLException e) {
            System.out.println("An error occurred while getting a secretary from the database");
            System.out.println(e.getMessage());
            return null;
        }
    }

/*
    @Override
    public void addToDatabase(Connection connection) {
        try {
            Query query = Query.addSecretary(connection);
            query.getStatement().setInt(1, id);
            query.getStatement().setString(2, username);
            query.getStatement().setString(3, name);
            query.getStatement().setString(4, surname);

            query.getStatement().execute();

            query.getStatement().close();
        } catch (SQLException e) {
            System.out.println("An error occurred while trying to add an admin to the database");
            System.out.println(e.getMessage());
        }


    }

    @Override
    public void removeFromDatabase(Connection connection) {

    }
    */

}