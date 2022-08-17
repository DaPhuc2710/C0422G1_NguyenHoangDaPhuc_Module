<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/08/2022
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/main" method="get">
  <h1>Từ điển dịch thuật</h1>
  <input type="text" name="english" value="${english}"><br>
  <button type="submit">Dịch</button>
</form>
<h1>Kết quả là :${result}</h1>
</body>
</html>
