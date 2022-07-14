<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 14/07/2022
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h2>Sandwich Condiments</h2>
<form action="save">
    <input type="checkbox" id="taste1" name="condiment" value="lettuce">
    <label for="taste1">Lettuce</label>
    <input type="checkbox" id="taste2" name="condiment" value="tomato">
    <label for="taste2">Tomato</label>
    <input type="checkbox" id="taste3" name="condiment" value="mustard">
    <label for="taste3">Mustard</label>
    <input type="checkbox" id="taste4" name="condiment" value="sprouts">
    <label for="taste4">Sprouts</label>

    <button>Save</button>
</form>
<p>The sandwich condiments chosen are:
    <c:forEach items="${condiment}" var="item">
        <span>${item}</span>
    </c:forEach>
</p>
</form>
</body>
</html>
