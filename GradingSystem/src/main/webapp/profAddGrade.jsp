<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.javabasics.model.Course" %>
<%@ page import="java.lang.reflect.Field" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>


<html>
<head>
    <title>MyUniversity</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="Views.css">
    <style>
        .myButton {
            box-shadow: 0px 10px 14px -7px #3e7327;
            background: #279d5a linear-gradient(to bottom, #279d5a 5%, #279d5a 100%);
            border-radius:7px;
            border:2px solid #4b8f29;
            display:inline-block;
            cursor:pointer;
            color:#ffffff;
            font-family:Arial;
            font-size:15px;
            font-weight:bold;
            padding:9px 22px;
            text-decoration:none;
            text-shadow:0px 1px 0px #5b8a3c;
        }
        .myButton:hover {
            background: #72b352 linear-gradient(to bottom, #72b352 5%, #77b55a 100%);
        }
        .myButton:active {
            position:relative;
            top:1px;
        }
    </style>
</head>
<body>
<div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <a href="assignmentCourse.jsp">Add a Grade</a>
    <a href="secretaryView.jsp">Show his/her Courses</a>
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

<br><br><br><br>
<div align="center">
    <form action="AddGradeServlet" method="post">
        <label>Student Id</label>
        <input type="text" name="student" id="student" placeholder="Student Id" required>
        <br><br>
        <label>Course</label>
        <input  type="text" name="course" id="course" placeholder="Course" required><br>
        <br>
        <label>Grade</label>
        <input  type="text" name="grade" id="grade" placeholder="Grade" required><br>
        <br>
        <label>Date</label>
        <input  type="text" name="date" id="date" placeholder="Date" required><br>
        <br>

        <button class="myButton">Submit</button>
    </form>

    <%
        String suc = (String)request.getAttribute("suc");
        if(suc != null) {
            out.println("<font color=#3e7327 size=4px>"+suc+"</font>");
        }
    %>
    <%
        String errormsg = (String)request.getAttribute("error");
        if(errormsg != null) {
            out.println("<font color=red size=4px>"+errormsg+"</font>");
        }
    %>




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
