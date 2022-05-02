<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="../partials/navbar.jsp" />

    <h1>Hello, ${user}</h1>
    <div class="container">
        <h1>Viewing your profile.</h1>
    </div>
    <a href="/logout">Logout</a>

</body>
</html>
