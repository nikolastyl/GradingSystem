package com.example.javabasics.model;

import com.example.javabasics.Utility.DatabaseManager;
import com.example.javabasics.Utility.Query;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Grades implements Serializable {
    public static Integer gradeid =21;
    private String student;
    private String course;
    private int grade;
    private String date;

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Grades(String student, String course, int grade, String date) {
        this.student = student;
        this.course = course;
        this.grade = grade;
        this.date = date;
    }

    public Grades(ResultSet resultSet) {
        try {
            DatabaseManager databaseManager = new DatabaseManager();
            Connection connection = databaseManager.getConnection();
            student = resultSet.getString("name") +
                    " " +
                    resultSet.getString("surname");

            course= resultSet.getString("course");
            grade= resultSet.getInt("grade");
            date= resultSet.getString("exam");
            databaseManager.closeConnection();
        } catch (SQLException ex) {
            System.out.println("An error occurred while getting the grades from result set");
            System.out.println(ex.toString());
        }

    }


    public static ArrayList<Grades> getMultipleFromDatabase(Query query) {
        try {
            ResultSet resultSet = query.getStatement().executeQuery();
            ArrayList<Grades> grades = new ArrayList<>();


            while (resultSet.next()) {
                grades.add(new Grades(resultSet));
            }


            query.getStatement().close();


            if (grades.isEmpty())
                return null;
            else
                return grades;
        } catch (SQLException e) {
            System.out.println("An error occurred while getting all grades from the database");
            return null;
        }

    }

}

