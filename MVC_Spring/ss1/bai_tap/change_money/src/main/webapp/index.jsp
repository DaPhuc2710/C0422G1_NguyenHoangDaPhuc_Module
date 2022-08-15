<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/08/2022
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/main" method="get">
    <h1>Nhập số tiền cần chuyển đổi(từ USD sang VND)</h1>
    <input type="text" name="soTienNhap" value="${soTienNhap}">
    <br>
    <h1>Nhập tỉ giá </h1>
    <input type="text" name="rate" value="${rate}">
    <br>
    <button type="submit">Chuyển đổi</button>
</form>
<h1>Kết Quả</h1>
<h1>${tienSauDo}</h1>
</body>
</html>
