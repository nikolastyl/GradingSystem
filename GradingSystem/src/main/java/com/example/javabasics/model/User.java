package com.example.javabasics.model;

import com.example.javabasics.Utility.DatabaseManager;
import com.example.javabasics.Utility.Query;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public class    User {
    protected String username ;
    protected int id ;
    protected String password;
    protected String name ;
    protected String surname ;

    static int userCounter = 0;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public User() {}

    public User(int id, String username, String password, String name, String surname){
        this.id=id;
        this.username=username;
        this.password=password;
        this.name=name;
        this.surname=surname;
        userCounter++;

    }



    public static User login(String username, String password) {

       try{
            DatabaseManager databaseManager = new DatabaseManager();
            Connection connection = databaseManager.getConnection();


            Student student = Student.getFromDatabase(Query.getStudentByUsername(connection, username));



            if (student != null && student.password.equals(password)) {
                databaseManager.closeConnection();
                return student;
            }


            Professor professor = Professor.getFromDatabase(Query.getProfessorByUsername(connection, username));
            if (professor != null && Objects.equals(professor.password, password)) {
                databaseManager.closeConnection();
                return professor;
            }

            Secretary secretary = Secretary.getFromDatabase(Query.getSecretaryByUsername(connection, username));
            if (secretary != null && Objects.equals(secretary.password, password)) {
                databaseManager.closeConnection();
                return secretary;
            }
            else {
                databaseManager.closeConnection();
                return null;
            }


        }catch (SQLException e) {
            System.out.println("An error occurred while logging in a user");
            System.out.println(e.getMessage());
            return null;
        }



    }

    public static User getFromDatabase(Connection connection, String username) {
        try {
            Student student = Student.getFromDatabase(Query.getStudentByUsername(connection, username));
            if (student != null) {
                return student;
            }

            Professor professor = Professor.getFromDatabase(Query.getProfessorByUsername(connection, username));
            if (professor != null) {
                return professor;
            }

            return Secretary.getFromDatabase(Query.getSecretaryByUsername(connection, username));
        } catch (SQLException e) {
            System.out.println("An error occurred while searching for a user");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int getId() {
        return id;
    }
}
