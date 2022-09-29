
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3>Login to MyUniversity</h3>
<form action="${pageContext.request.contextPath}/login" method="post">
    name: <label>
    <input type="text" name="loginname" width="30"/>
</label>
    password: <label>
    <input type="password" name="loginpassword" width="10"/>
</label>
    <input type="submit" value="Login"/>
</form>
</body>
</html>
