<%--
  Created by IntelliJ IDEA.
  User: shaz
  Date: 5/3/22
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quotes</title>
</head>
<body>


    <c:forEach var="quote" items="${quotes}">
        <div class="quote">
            <p>${quote.author.author_name} said: ${quote.content}</p>
        </div>
    </c:forEach>

    <h2>Add an author to the database</h2>
    <form action="authors" method="post">
        <label for="author_name">Author Name:</label>
        <input type="text" name="author_name" id="author_name">
        <input type="submit" value="Submit">
    </form>

</body>
</html>
