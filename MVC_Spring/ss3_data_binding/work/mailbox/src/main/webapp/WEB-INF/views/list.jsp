<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 17/08/2022
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>ZSaving PAGE</title>
</head>
<body>
<table>
    <tr>
        <td>${mailBox1.language}</td>
        <td>${mailBox1.pageSize}</td>
        <td>${mailBox1.spamFilter}</td>
        <td>${mailBox1.signature}</td>
    </tr>
</table>
</body>
</html>
