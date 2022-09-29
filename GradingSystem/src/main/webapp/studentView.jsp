<%@ page import="com.example.javabasics.model.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.javabasics.model.Department" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyUniversity!!</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="Views.css">
</head>
<body>
<div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <a href="studentView.jsp">Student Informations</a>
    <a href="gradesPerStudent.jsp">Grades</a>
    <a href="index.jsp">Logout</a>
</div>

<div class="header2" style="background-color: cadetblue">
    <br>
    <br>
    <h1 style="text-align: center;font-family: fantasy">Welcome to MyUniversity!!</h1>
    <br>
    <br>
</div>

<h3 style="text-align: center;border: 3px solid black;width: 50%;margin: 13px auto">Student Informations</h3>
<table style="width:50%;margin: 0px auto;border: 3px solid black">
    <%  Student basicData = (Student)session.getAttribute("getBasicData");
        //Student basicData = new Student(123,"kostakis","12edwd","mpamphs","georgiou","12345", Department.Biology);
    %>

        <tr>
            <td>Name</td>
            <td><%=basicData.getName()%></td>
        </tr>


        <tr>
        <td>Surname</td>
        <td><%=basicData.getSurname()%></td>
        </tr>

        <tr>
        <td>RegistrationNumber</td>
        <td><%=basicData.getRegistrationNumber()%></td>
        </tr>

        <tr>
        <td>Department</td>
        <td><%=basicData.getDepartment()%></td>
        </tr>
    <tr>
        <td>Student Status</td>
        <td>Active</td>
    </tr>
</table>


<br><br>
<div style="text-align: center;">
    <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; menu </span>
</div>


</body>

<script>
    function openNav() {
        document.getElementById("mySidenav").style.width = "250px";
    }

    function closeNav() {
        document.getElementById("mySidenav").style.width = "0";
    }
</script>
</html>
