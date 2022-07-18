<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 18/07/2022
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Tờ Khai y tế</h3>
<form:form action="create" modelAttribute="medicalDeclaration" method="post">
    <div><label>Họ tên </label>
        <form:input path="name" required="true"/>
    </div>
    <div>
        <label>Năm Sinh</label>
        <form:select path="yearOfBirth" items="${yearOfBirth}" required="true"/>
    </div>
    <div>
        <label>Thông tin đi lại</label>
        <form:radiobuttons path="travelInformation" items="${travelInformation}"  required="true"/>
    </div>
    <div>
        <label> Ngày khởi Hành</label>
        <form:select path="starDay" items="${startDay}" required="true"/>
    </div>
    <div>
        <label> Ngày kết thúc</label>
        <form:select path="endDay" items="${endDay}" required="true"/>
    </div>
    <div>
        <label> Trong vòng 14 ngày qua</label>
        <form:textarea path="note" required="true"/>
    </div>
    <form:button>Submit</form:button>
</form:form>
</body>
</html>
