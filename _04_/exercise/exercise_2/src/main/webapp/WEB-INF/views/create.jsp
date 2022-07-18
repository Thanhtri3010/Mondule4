<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 16/07/2022
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <style>
        .align-center {
            text-align: center;
        }
    </style>
</head>
<body>
<h3 class="align-center">TỜ KHAI Y TẾ</h3>
<h5 class="align-center">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ
    LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h5>
<h6 class="align-center">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</h6>

<%--@elvariable id="person" type=""--%>
<form:form action="create" modelAttribute="person" method="post">
    <div><label>Họ tên (ghi chữ IN HOA)</label>
        <form:input path="name" required="true"/>
    </div>
    <div><label>Năm sinh</label>
        <form:select path="yearOfBirth" items="${yearOfBirth}" required="true"/>
        <label>Giới tính</label>
        <form:select path="gender" items="${gender}" required="true"/>
        <label>Quốc tịch</label>
        <form:select path="nationality" items="${nationality}" required="true"/>
    </div>

    <div>
        <label>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</label>
        <form:input path="idCard" required="true"/>
    </div>
    <div>
        <label>Thông tin đi lại</label>
        <form:radiobuttons path="travelInformation" items="${travelInformation}"/>
    </div>
    <div><label>Số hiệu phương tiện</label>
        <form:input path="vehicleNumber"/>
        <label>Số ghế</label>
        <form:input path="seats"/>
    </div>
    <div>
        <label>Ngày khởi hành</label>
        <form:select path="starDay" items="${startDay}"/>
        <form:select path="starMonth" items="${startMonth}"/>
        <form:select path="starYear" items="${startYear}"/>
        <label>Ngày kết thúc</label>
        <form:select path="endDay" items="${endDay}"/>
        <form:select path="endMonth" items="${endMonth}"/>
        <form:select path="endYear" items="${endYear}"/>
    </div>
    <label>Trong vòng 14 ngày qua, anh/chị có đến tỉnh/thành phố nào?</label>
    <form:textarea path="note"/>
    <div>
        <label>Địa chỉ liên lạc</label>
        <label>Tỉnh/thành</label>
        <form:select path="province" items="${province}"/>
        <form:select path="district" items="${district}"/>
        <form:select path="wards" items="${wards}"/>
    </div>
    <div>
        <label>Địa chỉ nơi ở</label>
        <form:input path="addressOfResidence"/>
    </div>

    <form:button>Submit</form:button>
</form:form>

</body>
</html>
