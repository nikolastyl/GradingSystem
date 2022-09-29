<%@ page import="com.example.javabasics.servlets.LogInServlet" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>MyUniversity</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="header1">

<h1 style="text-align: center;color: midnightblue;">MyUniversity</h1>
</div>



<div class="main">

    <div class="signup">
        <form  action="LogInServlet" method="post">
            <label>Login</label>
            <input type="text" name="username" id="username" placeholder="Username" required>
            <input type="password" name="password" id="password" placeholder="Password" required>
            <button>Login</button>

            <%
                String login_msg = (String)request.getAttribute("error");
                if(login_msg != null) {
                    out.println("<font color=red size=4px>"+login_msg+"</font>");
                }
            %>







        </form>


    </div>


</div>



</body>


</html>