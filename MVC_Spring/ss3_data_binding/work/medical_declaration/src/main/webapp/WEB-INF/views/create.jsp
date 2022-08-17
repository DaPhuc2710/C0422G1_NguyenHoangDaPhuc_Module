<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 17/08/2022
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/goSave" method="post">
    <h1 style="text-align: center">Tờ khai y tế</h1>
    <h2 style="text-align: center">Đây là tài liêu quan trọng thông tin của anh/chị sẽ giúp cơ quan y tế liên lạc khi
        cần thiết để phòng chống dịch bệnh truyền nhiễm</h2>
    <h3 style="color: red">Khuyến cáo : khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình
        sự</h3>
    <p>Họ và Tên (Ghi chữ in HOA)</p>
    <p><form:input path="name"/>
    <p>Năm sinh</p>
    <p><form:select path="yearOfBirth" items="${birthYear}"/></p>
    <p>Giới tính</p>
    <p><form:select path="gender" items="${gender}"/></p>
    <p>Quốc tịch</p>
    <p><form:select path="nationality" items="${nationality}"/></p>
    <p>CMND hoặc mã hộ chiếu</p>
    <p><form:input path="idCard"/></p>
    <p>Thông tin đi lại</p>
    <p><form:radiobuttons path="transport" items="${transport}"/></p>
    <p>Số hiệu phương tiện </p>
    <p><form:input path="transportIdr"/></p>
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
    <p><form:input path="otherInfor"/></p>
    <button type="submit">Gửi tờ khai</button>
</form:form>


</body>
</html>
