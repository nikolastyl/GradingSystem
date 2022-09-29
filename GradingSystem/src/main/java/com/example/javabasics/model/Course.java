package com.example.javabasics.model;

import com.example.javabasics.Utility.DatabaseManager;
import com.example.javabasics.Utility.Query;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Course {
    private int id ;
    private String name;
    private int semester ;
    private String  professor_name ;

    public String getProfessor_name() {
        return professor_name;
    }

    public void setProfessor_name(String professor_name) {
        this.professor_name = professor_name;
    }

    public String getProfessor_surname() {
        return professor_surname;
    }

    public void setProfessor_surname(String professor_surname) {
        this.professor_surname = professor_surname;
    }

    private String  professor_surname ;
    private Department department;


    public Course(ResultSet resultSet) {
        try {
            DatabaseManager databaseManager = new DatabaseManager();
            Connection connection = databaseManager.getConnection();

            id = resultSet.getInt("id");
            name = resultSet.getString("name");
            semester = resultSet.getInt("semester");
            professor_name = resultSet.getString("profname");
            professor_surname = resultSet.getString("surname");
            department = Department.valueOf(resultSet.getString("department"));

            databaseManager.closeConnection();
        } catch (SQLException ex) {
            System.out.println("An error occurred while creating scheduled appointment from result set");
            System.out.println(ex.toString());
        }

    }
    public Course(int id, String name, int semester, String professor,String professor_surname, Department department) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.professor_name = professor;
        this.professor_surname=professor_surname;
        this.department = department;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getProfessor() {
        return professor_name;
    }

    public void setProfessor(String professor) {
        this.professor_name = professor;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void addToDatabase(Connection connection) {

    }

    public void removeFromDatabase(Connection connection) {

    }

    public static ArrayList<Course> getMultipleFromDatabase(Query query) {
        try {
            ResultSet resultSet = query.getStatement().executeQuery();
            ArrayList<Course> courses = new ArrayList<>();


            while (resultSet.next()) {
                courses.add(new Course(resultSet));
            }


            query.getStatement().close();


            if (courses.isEmpty())
                return null;
            else
                return courses;
        } catch (SQLException e) {
            System.out.println("An error occurred while getting all courses from the database");
            return null;
        }

    }
    //public static Course getFromDatabase(Query query) {

   // }

    //public static ArrayList<Course> getMultipleFromDatabase(Query query) {}
}
