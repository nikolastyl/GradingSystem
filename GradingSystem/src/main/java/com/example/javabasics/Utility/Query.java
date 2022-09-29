package com.example.javabasics.Utility;

import com.example.javabasics.model.Department;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Query {
    private Query(PreparedStatement statement) { this.statement = statement; }

    private final PreparedStatement statement;
    public PreparedStatement getStatement() { return statement; }

    public static Query getStudentByUsername(Connection connection, String username) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select * from users join students on users.id=students.id where users.username=?");
        statement.setString(1, username);
        return new Query(statement);
    }

    public static Query getProfessorByUsername(Connection connection, String username) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select * from users join professors on users.id=professors.id where users.username=? ");
        statement.setString(1, username);
        return new Query(statement);
    }

    public static Query getSecretaryByUsername(Connection connection, String username) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select * from users where username=?");
        statement.setString(1, username);
        return new Query(statement);
    }
    public static  Query getAllProfessors(Connection connection)throws SQLException{
        return new Query(connection.prepareStatement("select * from  users join professors on users.id=professors.id"));

    }
    public static Query getProfessorsByDepartment(Connection connection, Department department)throws  SQLException{
        PreparedStatement statement =connection.prepareStatement("select * from  users join professors on users.id=professors.id where professors.department =? ");
        statement.setString(1,department.name());
        return  new Query(statement);
    }

    public static  Query getAllStudents(Connection connection)throws SQLException{
        return new Query(connection.prepareStatement("select * from  users join students on users.id=students.id"));

    }
    public static  Query getAllSecretaries(Connection connection)throws SQLException{
        return new Query(connection.prepareStatement("select * from  users join secretaries on users.id=secretaries.id"));

    }
    public static  Query getAllCourses(Connection connection)throws SQLException{
        return new Query(connection.prepareStatement("select courses.id,courses.name,courses.semester,users.name as profname,users.surname,courses.department from courses join professors on courses.professor=professors.id\n" +
                "join users on professors.id = users.id"));

    }
    public static Query getCoursesByProfessor(Connection connection,int id) throws SQLException{
        PreparedStatement statement = connection.prepareStatement("select courses.id,courses.name,courses.semester,users.name as profname,users.surname,courses.department from courses join professors on courses.professor=professors.id join users on professors.id = users.id where professors.id=?");
        statement.setInt(1, id);
        return new Query(statement);
    }


    public static Query getGradesByCourseandDate(Connection connection,String course, String date) throws SQLException {

        PreparedStatement statement =connection.prepareStatement("select users.name as name ,users.surname as surname ,courses.name as course,grades.grade as grade ,grades.date as exam from courses inner join takes on courses.id =takes.course\n" +
                "                inner join grades on takes.id=grades.takes inner join students on students.id=takes.student  inner join users on students.id =users.id where courses.name =? and grades.date =?");
        statement.setString(1,course);
        statement.setString(2,date);
        return new Query(statement);
    }
    public static Query getGradesByStudent(Connection connection,int student)throws SQLException{
        PreparedStatement statement = connection.prepareStatement("select users.name as name ,users.surname as surname ,courses.name as course,grades.grade as grade ,grades.date as exam from courses inner join takes on courses.id =takes.course " +
                "inner join grades on takes.id=grades.takes inner join students on students.id=takes.student  inner join users on students.id =users.id where students.id=?");
        statement.setInt(1,student);
        return new Query(statement);
    }
    public static Query UpdateCourseProfessor(Connection connection,int professor,String course)throws  SQLException{
        PreparedStatement statement =connection.prepareStatement("update courses set professor=? where name=? ");
        statement.setInt(1,professor);
        statement.setString(2,course);
        return  new Query(statement);

    }
    public static Query getBasicDataFromId(Connection connection,int id)throws  SQLException{
        PreparedStatement statement =connection.prepareStatement("select * from users inner join students on users.id=students.id where users.id=?");
        statement.setInt(1,id);
        return  new Query(statement);

    }
    public static Query updateCourseProfessor(Connection connection,String course, int prof) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("update courses set professor=? where name=? ");
        statement.setInt(1,prof);
        statement.setString(2,course);
        return new Query(statement);
    }

    public static Query checkTakes(Connection connection,int student,String course)throws SQLException{
        PreparedStatement statement =connection.prepareStatement("select takes.id as takes from takes inner join courses on takes.course=courses.id where takes.student=? and courses.name=? ");
        statement.setInt(1,student);
        statement.setString(2,course);
        return new Query(statement);
    }
    public static  Query addGrade(Connection connection,int id ,int takes ,int grade, String  date)throws SQLException{
        PreparedStatement statement = connection.prepareStatement("insert into grades (id,takes,grade,date) values(?,?,?,?)");
        statement.setInt(1,id);
        statement.setInt(2,takes);
        statement.setInt(3,grade);
        statement.setString(4,date);
        return new Query(statement);
    }



}
