<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 17/08/2022
  Time: 7:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form:form action="/save" method="post" modelAttribute="medical">
    <form:hidden path="id" value="${medicalReport.id}"/>
    <p>Họ và Tên (Ghi chữ in HOA)</p>
    <p><form:input value="${medicalReport.name}" path="name"/>
    <p>Năm sinh</p>
    <p><form:select path="yearOfBirth" items="${birthYear}"/></p>
    <p>Giới tính</p>
    <p><form:select path="gender" items="${gender}"/></p>
    <p>Quốc tịch</p>
    <p><form:select path="nationality" items="${nationality}"/></p>
    <p>CMND hoặc mã hộ chiếu</p>
    <p><form:input path="idCard" value="${medicalReport.idCard}"/></p>
    <p>Thông tin đi lại</p>
    <p><form:radiobuttons path="transport" items="${transport}"/></p>
    <p>Số hiệu phương tiện </p>
    <p><form:input path="transportIdr" value="${medicalReport.transportIdr}"/></p>
    <p>Số Ghế</p>
    <p><form:input path="seatNumber"/></p>
    <p>Ngày khởi hành</p>
    <p><form:select path="startDay" items="${days}"/></p>
    <p><form:select path="startMonth" items="${months}"/></p>
    <p><form:select path="startYear" items="${years}"/></p>
    <p>Ngày kết thúc</p>
    <p><form:select path="endDay" items="${days}"/></p>
    <p><form:select path="endMonth" items="${months}"/></p>
    <p><form:select path="endYear" items="${years}"/></p
    <p>Trong vòng 14 ngày qua anh chị đã đến thành phố nào</p>
    <p><form:input path="otherInfor" value="${medicalReport.otherInfor}"/></p>
    <button type="submit">Lưu</button>
</form:form>

</body>
</html>
