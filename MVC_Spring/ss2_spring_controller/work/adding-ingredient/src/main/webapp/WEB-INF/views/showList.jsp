<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 16/08/2022
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<h1>Sandwich Condiment</h1>
<form action="/result" method="post">
    <c:forEach var="listCondiment" items="${list}">
        <input type="checkbox" name="condiment" value="${listCondiment.name}"> ${listCondiment.name}
    </c:forEach>
    <br>
    <button type="submit">Send</button>
</form>

    <c:if test="${condiment!=null}">
        <h1>Your Choose:</h1>
        <c:forEach var="condiments"  items="${condiment}">
            <p>${condiments}</p>
        </c:forEach>
    </c:if>
</body>
</html>
