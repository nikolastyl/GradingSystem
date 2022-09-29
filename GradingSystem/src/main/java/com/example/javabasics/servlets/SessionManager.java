package com.example.javabasics.servlets;

import com.example.javabasics.Utility.DatabaseManager;
import com.example.javabasics.Utility.Query;
import com.example.javabasics.model.*;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

import static com.example.javabasics.Utility.Query.*;

public class SessionManager {
    public static void prepareSecretarySession(Secretary secretary, HttpSession session) {
        session.setAttribute("user", secretary);
        try {
            DatabaseManager dbManager = new DatabaseManager();
            session.setAttribute("allCourses", Course.getMultipleFromDatabase(getAllCourses(dbManager.getConnection())));
            dbManager.closeConnection();
        } catch (SQLException e) {
            System.out.println("An error occurred while getting all courses from the database");
            System.out.println(e.getMessage());
        }

    }

    public static void prepareProfessorSession(Professor professor, HttpSession session) {
        session.setAttribute("user", professor);
try{
        DatabaseManager dbManager = new DatabaseManager();
            session.setAttribute("getCourses", Course.getMultipleFromDatabase(getCoursesByProfessor(dbManager.getConnection(),professor.getId())));
        dbManager.closeConnection();
}catch (SQLException e){
    System.out.println("An error occurred while getting all courses from the database");
    System.out.println(e.getMessage());

    }

    }
    public static void prepareStudentSession(Student student, HttpSession session) {
        session.setAttribute("user", student);
        try {
            DatabaseManager dbManager = new DatabaseManager();
            session.setAttribute("getBasicData", Student.getFromDatabase(getBasicDataFromId(dbManager.getConnection(),student.getId())));
            session.setAttribute("getStudentsGrades", Grades.getMultipleFromDatabase(getGradesByStudent(dbManager.getConnection(),student.getId())));
            dbManager.closeConnection();
        }catch (SQLException e){
            System.out.println("An error occurred while getting students data from the database");
            System.out.println(e.getMessage());
        }
    }
    }


