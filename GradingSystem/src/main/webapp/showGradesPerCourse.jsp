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
    <a href="profAddGrade.jsp">Add a Grade</a>
    <a href="professorView.jsp">Show his/her Courses</a>
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
<%String courseName = (String)session.getAttribute("");%>
<h3></h3>
<br>
<br>
<br>
<div>
    <table style="width:50%;margin: 0px auto;border: 5px solid black;text-align: center;background-color: #fff4b0 " cellpadding="7" border="1">
        <tr>
            <th>STUDENT ID</th>
            <th>SEMESTER</th>
            <th>GRADE</th>


        </tr>
        <%
            ArrayList<Course> courseList = (ArrayList<Course>)session.getAttribute("getCourses");
            if (courseList != null) {
                for (Course course: courseList) {%>
        <tr>
            <td> <a href="login.jsp"><%=course.getName()%></a> </td>
            <td> <%=course.getSemester()%> </td>

            <td> <%=course.getDepartment()%></td>

        </tr>
        <% }
        }%>

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
