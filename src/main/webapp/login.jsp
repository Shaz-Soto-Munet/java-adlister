<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: shaz
  Date: 4/26/22
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h1>Please enter your login credentials</h1>

<form action="/login.jsp" method="POST">
    <label for="username">Username:</label>
    <input name="username" id="username" type="text">
    <br>
    <br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password">
    <br>
    <br>
    <button>Submit</button>
</form>

<%

    if (Objects.equals(request.getParameter("username"), "admin") && Objects.equals(request.getParameter("password"), "password")) {
        response.sendRedirect("profile.jsp");
    }


%>


</body>
</html>
