<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 17/08/2022
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Setting</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="/save" method="post" modelAttribute="mailbox">
    <p>Language <form:select path="language" items="${langList}"/></p>
    <p>Page size show <form:select path="pageSize" items="${pageList}"/> emails per page </p>
    <p>Spams filter <form:checkbox path="spamFilter"/></p>
    <p>Signature <form:textarea path="signature"/></p>
    <button type="submit">Save</button>
</form:form>
</body>
</html>
