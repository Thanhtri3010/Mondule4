<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 18/07/2022
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh Sách tờ khai y tế</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Năm sinh</th>
        <th>Thông Tin đi lại</th>
        <th>Ngày khởi hành</th>
        <th>Ngày kết thúc</th>
        <th>Trong 14 ngày qua</th>
    </tr>
    <c:forEach items="${medicalDeclarationList}" var="medicalDeclaration">
        <tr>
            <td>${medicalDeclaration.id}</td>
            <td>${medicalDeclaration.name}</td>
            <td>${medicalDeclaration.yearOfBirth}</td>
            <td>${medicalDeclaration.travelInformation}</td>
            <td>${medicalDeclaration.starDay}</td>
            <td>${medicalDeclaration.endDay}</td>
            <td>${medicalDeclaration.note}</td>
            <td>
                <a href="/update?id=${medicalDeclaration.id}">
                    <button>
                        Sửa
                    </button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
<div class="container-fluid">
    <div class="row">
        <a href="/create">
            <button class="btn btn-info">
                Thêm mới
            </button>
        </a>
    </div>

</div>
</body>
</html>
