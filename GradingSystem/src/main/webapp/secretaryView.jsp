<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.javabasics.model.Course" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>MyUniversity</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="Views.css">
</head>
<body>
<div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <a href="assignmentCourse.jsp">Assignment Course to Professor </a>
    <a href="secretaryView.jsp">Show Professors-Courses</a>
    <a href="index.jsp">Logout</a>
</div>

<div class="header2" style="background-color: cadetblue">
    <br>
    <br>
    <h1 style="text-align: center;font-family: fantasy">Welcome to MyUniversity!!</h1>
    <br>
    <br>
</div>

<div style="text-align: center;">
    <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; menu </span>
</div>
<br>
<br>
<br>
<br>
<br>
<div>
    <table style="width:50%;margin: 0px auto;border: 5px solid black;text-align: center;background-color: #fff4b0 " cellpadding="7" border="1">
        <tr>
            <th>COURSE NAME</th>
            <th>PROFESSOR'S NAME</th>
            <th>SEMESTER</th>
            <th>DEPARTMENT</th>


        </tr>
        <%
            ArrayList<Course> courseList = (ArrayList<Course>)session.getAttribute("allCourses");
            if (courseList != null) {
                for (Course course: courseList) {
                    out.println("<tr>");
                    out.println("<td>" + course.getName() + "</td> " +
                            "<td>" + course.getProfessor_surname() + course.getProfessor_name() + "</td> " +
                            "<td>" + course.getSemester() + "</td> " +
                            "<td>" + course.getDepartment().toString() + "</td> "
                    );
                    out.println("</tr>");
                }
            }
        %>
    </table>
</div>

</body>
<script>
    function openNav() {
        document.getElementById("mySidenav").style.width = "250px";
    }

    function closeNav() {
        document.getElementById("mySidenav").style.width = "0";
    }


        addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

        function hideURLbar() {
        window.scrollTo(0, 1);
    }


</script>
</html>
