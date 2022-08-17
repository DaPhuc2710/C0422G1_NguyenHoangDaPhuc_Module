<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 17/08/2022
  Time: 7:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<table>
    <tr>
        <th>STT</th>
        <th>Tên</th>

    </tr>
    <c:forEach var="medical" items="${medicalReportService}" varStatus="stt">
        <tr>
            <td>${stt.count}</td>
            <td>${medical.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
