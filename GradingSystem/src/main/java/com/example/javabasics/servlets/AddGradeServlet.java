package com.example.javabasics.servlets;

import com.example.javabasics.Utility.DatabaseManager;
import com.example.javabasics.Utility.Query;
import com.example.javabasics.model.Grades;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "AddGradeServlet", value = "/AddGradeServlet")
public class AddGradeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        int student = Integer.parseInt(request.getParameter("student"));
        int grade = Integer.parseInt(request.getParameter("grade"));
        String course = request.getParameter("course");
        String date =  request.getParameter("date");
        DatabaseManager db = null;
            db = new DatabaseManager();
            Connection connection = db.getConnection();
            Statement statement =connection.createStatement();
            ResultSet rs = Query.checkTakes(connection,student,course).getStatement().executeQuery();
            if (rs.next()){
                int takes=rs.getInt("takes");
                Statement statement1 =connection.createStatement();
                Grades.gradeid++;
                ResultSet rs1 = Query.addGrade(connection,(int)Grades.gradeid,takes,grade,date).getStatement().executeQuery();
            }
        } catch (SQLException e) {
            request.setAttribute("suc","Successful Adding!!");
            String address = "/profAddGrade.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request, response);


        }catch (NullPointerException e){
            request.setAttribute("error", "Unsuccessful attempt to add grade ");
        }


        String address = "/profAddGrade.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);


    }
}
