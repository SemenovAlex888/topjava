<%@ page import="ru.javawebinar.topjava.model.MealTo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 08.02.2021
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<c:forEach var="user" items="${requestScope.users}">
    <li><c:out value="${user}" /></li>
</c:forEach>
<table>
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
    </tr>
    <%--
    <jsp:useBean id="list" scope="request" type="ru.javawebinar.topjava.model.MealTo"/>
    <c:forEach items="${list}" var="meal">
            <td>${meal.dateTime}</td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
    </c:forEach>
    --%>
</table>
<%--
testing
<p>Name: ${name}</p>
<p>Age: ${age}</p>
--%>
</body>
</html>
