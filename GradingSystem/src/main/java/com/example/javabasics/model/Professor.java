package com.example.javabasics.model;

import com.example.javabasics.Utility.DatabaseManager;
import com.example.javabasics.Utility.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Professor extends User implements IDatabaseSupport{
    public Professor(ResultSet resultSet) {
        try {
            DatabaseManager databaseManager = new DatabaseManager();
            Connection connection = databaseManager.getConnection();
            id = resultSet.getInt("id");
            department = Department.valueOf(resultSet.getString("department"));
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

    private Department department;
    public Professor(int id,String username,String password, String name, String surname, Department department) {
        super(id, username, password, name,surname);
        this.department= department;
    }

    public static Professor getFromDatabase(Query query) {
        try {
            ResultSet resultSet = query.getStatement().executeQuery();

            Professor professor = null;
            if (resultSet.next()) {
                professor = new Professor(resultSet);
            }

            query.getStatement().close();
            return professor;
        } catch (SQLException e) {
            System.out.println("An error occurred while getting a professor from the database");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static ArrayList<Professor> getMultipleFromDatabase(Query query) {
        try {
            ResultSet resultSet = query.getStatement().executeQuery();
            ArrayList<Professor> professors = new ArrayList<>();


            while (resultSet.next()) {
                professors.add(new Professor(resultSet));
            }


            query.getStatement().close();


            if (professors.isEmpty())
                return null;
            else
                return professors;
        } catch (SQLException e) {
            System.out.println("An error occurred while getting all professors from the database");
            return null;
        }
    }


    @Override
    public void addToDatabase(Connection connection) {

    }

    @Override
    public void removeFromDatabase(Connection connection) {

    }
}
