<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 15/07/2022
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Display email</title>
</head>
<body>
<h2></h2>
<table>
    <tr>
        <th>ID</th>
        <th>Languages</th>
        <th>Page size</th>
        <th>Spam filters</th>
        <th>Signature</th>
        <th>Edit</th>
    </tr>
    <c:forEach items="${emailList}" var="email">
        <tr>
            <td>${email.id}</td>
            <td>${email.languages}</td>
            <td>${email.pageSize}</td>
            <td>${email.spamsFilter}</td>
            <td>${email.signature}</td>
            <td>
                <a href="/update?id=${email.id}">
                    <button>
                        Update
                    </button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>