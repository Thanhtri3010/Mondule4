<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 16/07/2022
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h2 class="text-center" >Danh Sách tờ khai y tế</h2>
<table class="table table-light">
    <tr class="bg-primary">
        <th>Họ Tên</th>
        <th>Năm Sinh</th>
        <th>Giới Tính</th>
        <th>Quốc tịch</th>
        <th>Số chứng minh nhân dân</th>
        <th>Thông tin đi lại</th>
        <th>Số hiệu phương tiện</th>
        <th>Số ghế</th>
        <th>Ngày bắt đầu</th>
        <th>Ngày kết thúc</th>
        <th>Trong vòng 14 ngày qua, anh/chị có đến tỉnh/thành phố nào?</th>
        <th>Địa chỉ liên lạc</th>
        <th>Nơi ở</th>
    </tr>
    <c:forEach items="${personList}" var="person">
        <tr>
            <td>${person.name}</td>
            <td>${person.yearOfBirth}</td>
            <td>${person.gender}</td>
            <td>${person.nationality}</td>
            <td>${person.idCard}</td>
            <td>${person.travelInformation}</td>
            <td>${person.vehicleNumber}</td>
            <td>${person.seats}</td>
            <td>${person.starDay}/${person.starMonth}/${person.starYear}</td>
            <td>${person.endDay}/${person.endMonth}/${person.endYear}</td>
            <td>${person.note}</td>
            <td>${person.province}-${person.district}-${person.wards}</td>
            <td>${person.addressOfResidence}</td>
            <td>
                <a href="/update?identity=${person.idCard}">
                    <button class="btn btn-info">
                        Update
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


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>