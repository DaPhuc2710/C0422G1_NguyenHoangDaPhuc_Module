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
        <th>Chi tiết</th>
        <th>Sửa</th>
        <th><a href="/goCreate">Thêm mới</a></th>

    </tr>
    <c:forEach var="medical" items="${medical}" varStatus="stt">
        <tr>
            <td>${stt.count}</td>
            <td>${medical.name}</td>
            <td><a href="/goEdit">Sửa</a> </td>
            <td></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
