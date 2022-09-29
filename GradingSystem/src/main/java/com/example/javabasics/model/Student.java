package com.example.javabasics.model;

import com.example.javabasics.Utility.DatabaseManager;
import com.example.javabasics.Utility.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Student extends User implements IDatabaseSupport{
    private String registrationNumber ;
    private Department department;
    public Student(int id,String username,String password, String name, String surname, String registrationNumber,Department department) {
        super(id,username,password ,name, surname);
        this.registrationNumber=registrationNumber;
        this.department =department;

    }
    public Student(int id,String username,String password, String name, String surname){
        super(id, username, password, name, surname);

    }

    public Department getDepartment() {
        return department;
    }

    public Student(ResultSet resultSet) {
        try {
            DatabaseManager databaseManager = new DatabaseManager();
            Connection connection = databaseManager.getConnection();
            id = resultSet.getInt("id");
            username= resultSet.getString("username");
            name= resultSet.getString("name");
            surname= resultSet.getString("surname");
            password= resultSet.getString("password");
            registrationNumber= resultSet.getString("registration_number");
            department = Department.valueOf(resultSet.getString("department"));
            databaseManager.closeConnection();
        } catch (SQLException ex) {
            System.out.println("An error occurred while creating scheduled appointment from result set");
            System.out.println(ex.toString());
        }

    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public void seeGrades()
    {

    }

    public static Student getFromDatabase(Query query) {
        try {
            ResultSet resultSet = query.getStatement().executeQuery();

            Student student = null;
            if (resultSet.next()) {
                student = new Student(resultSet);
            }

            query.getStatement().close();
            return student;
        } catch (SQLException e) {
            System.out.println("An error occurred while getting a student from the database");
            System.out.println(e.getMessage());
            return null;
        }
    }


    public static ArrayList<Student> getMultipleFromDatabase(Query query) {
        try {
            ResultSet resultSet = query.getStatement().executeQuery();
            ArrayList<Student> students = new ArrayList<>();


            while (resultSet.next()) {
                students.add(new Student(resultSet));
            }


            query.getStatement().close();


            if (students.isEmpty())
                return null;
            else
                return students;
        } catch (SQLException e) {
            System.out.println("An error occurred while getting all students from the database");
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
