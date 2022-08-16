<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 16/08/2022
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/calculate">
    <h1>Calculator</h1>
    <input type="text" name="num1" placeholder="number1">
    <input type="text" name="num2" placeholder="number2">
    <button type="submit" name="operator" value="+">Addition(+)</button>
    <button type="submit" name="operator" value="-">Subtraction(-)</button>
    <button type="submit" name="operator" value="*">Multiplication(x)</button>
    <button type="submit" name="operator" value="/">Division(/)</button>
</form>
<p>The Result is: ${result}</p>
</body>
</html>
