<%@ page import="com.example.javabasics.servlets.AssignCourseServlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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



<br><br>
<div align="center">
  <form action="AssignCourseServlet" method="post">
      <label>Course</label>
      <input type="text" name="course" id="course" placeholder="Course Name" required>
      <br>
      <label>Professor</label>
      <input  type="text" name="prof" id="prof" placeholder="Professor ID" required><br>
      <button class="myButton">Submit</button>



  </form>

    <%
        String errormsg = (String)request.getAttribute("error");
        if(errormsg != null) {
            out.println("<font color=red size=4px>"+errormsg+"</font>");
        }
    %>
    <%
        String success = (String)request.getAttribute("ok");
        if(success != null) {
            out.println("<font color=#3e7327 size=4px>"+success+"</font>");
        }
    %>


</div>

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
