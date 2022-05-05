<%--
  Created by IntelliJ IDEA.
  User: shaz
  Date: 5/5/22
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

    <form action="/register" method="post">
        <label for="username">Username</label>
        <input id="username" type="text" name="username" placeholder="Enter username">

        <label for="email">Email</label>
        <input id="email" name="email" type="email">

        <label for="password">Password</label>
        <input id="password" name="password">

        <button>Register!</button>

    </form>

</body>
</html>
