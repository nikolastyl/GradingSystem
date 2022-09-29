package com.example.javabasics.servlets;

import com.example.javabasics.Utility.DatabaseManager;
import com.example.javabasics.Utility.Query;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "AssignCourseServlet", value = "/AssignCourseServlet")
public class AssignCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String course = request.getParameter("course");
        int professor;
        try {
            professor = Integer.parseInt(request.getParameter("prof"));
            DatabaseManager db = null;
            db = new DatabaseManager();
            Connection connection = db.getConnection();
            Statement statement =connection.createStatement();
            request.setAttribute("ok","Successful Update!!");

            Query.updateCourseProfessor(connection, course, professor).getStatement().executeQuery();




        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid ProfessorId");
        }catch (SQLException e){

        }


        String address = "/assignmentCourse.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
