<%@ page import="com.example.javabasics.model.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.javabasics.model.Grades" %>
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
    <a href="#">Grades</a>
    <a href="index.jsp">Logout</a>
</div>

<div class="header2" style="background-color: cadetblue">
    <br>
    <br>
    <h1 style="text-align: center;font-family: fantasy">Welcome to MyUniversity!!</h1>
    <br>
    <br>
</div>
<br><br>
<h2 style="text-align: center">STUDENT'S GRADES</h2>
<br><br>
<table style="width:50%;margin: 0px auto;border: 5px solid black;text-align: center;background-color: #fff4b0 " cellpadding="7" border="1">
    <tr>
        <th>COURSE NAME</th>
        <th>SEMESTER</th>
        <th>GRADE</th>
    </tr>
   <% ArrayList<Grades> grades = (ArrayList<Grades>)session.getAttribute("getStudentsGrades");
       if (grades != null) {
           for (Grades course: grades) {
               out.println("<tr>");
               out.println("<td>" + course.getCourse() + "</td> "+
                       "<td>" + course.getDate() + "</td> " +
                       "<td>" + course.getGrade() + "</td> "
               );
               out.println("</tr>");
           }
       }
   %>

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
