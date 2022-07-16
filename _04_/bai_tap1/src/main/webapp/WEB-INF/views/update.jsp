<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 15/07/2022
  Time: 09:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Setting</h3>
<%--@elvariable id="email" type=""--%>
<form:form action="update" method="post" modelAttribute="email">
<fieldset>
<legend>Email Box</legend>
    <table>
        <tr>
            <th>Languages</th>
            <td>
                <form:select path="languages" items="${languages}"/>
            </td>
        </tr>
        <tr>
            <th>Page size:</th>
            <td>Show
                <form:select path="pageSize" items="${pageSizes}"/>
                emails per page
            </td>
        </tr>
        <tr>
            <th>Spam filter:</th>
            <td>
                <form:checkbox path="spamsFilter"/> Enable spams filter
            </td>
        </tr>
        <tr>
            <th>Signature:</th>
            <td>
                <form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:button>Update</form:button>
            </td>
        </tr>
    </table>
</fieldset>
</form:form>
</body>
</html>
