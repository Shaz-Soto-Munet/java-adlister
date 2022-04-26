<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: shaz
  Date: 4/26/22
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.

  Create a file called foods.jsp.

Add scriptlet tags and define an ArrayList of strings containing 10 foods.

Include JSTL in this JSP.

Add the needed JSTL to display each food in a list item. Use an ordered list. The food list should look something like this:

1. Hot Dogs
2. Pizza
3. Nachos
...

Underneath the existing unordered list of foods, use JSTL to display the list of foods again but only food strings longer than 6 characters should be displayed. This should not require a change to the data in the
scriptlet tags (use the string length condition in the test attribute of a JSTL c:if tag).

--%>

<%
    ArrayList<String> foods = new ArrayList<>();
    foods.add("pizza");
    foods.add("pasta");
    foods.add("rice");
    foods.add("burger");
    foods.add("taco");
    foods.add("quesadilla");
    foods.add("turkey leg");
    foods.add("fried chicken");
    foods.add("fries");
    foods.add("baked potato");

    request.setAttribute("foods", foods);
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL Exercise</title>
</head>
<body>

<h1>Foods</h1>

<h3>All foods:</h3>
<ol>
    <c:forEach var="food" items="${foods}">
        <li>${food}</li>
    </c:forEach>
</ol>

<h3>Foods with long names:</h3>

<ol>
    <c:forEach var="food" items="${foods}">
        <c:if test="${food.length() > 6}">
            <li>${food}</li>
        </c:if>
    </c:forEach>
</ol>

</body>
</html>
