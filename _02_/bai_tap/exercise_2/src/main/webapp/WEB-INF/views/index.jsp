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
<h2>Simple Calculator</h2>
<form action="calculate" method="get">
    <input type="number" name="number1" value="${number1}">
    <select name="operator">
        <option value="add">Addition (+)</option>
        <option value="subtract">Subtraction (-)</option>
        <option value="multiple">Multiplication (*)</option>
        <option value="divide">Division(/)</option>
    </select>
    <input type="number" name="number2" value="${number2}">
    <button>Result</button>
</form>
<h3>${result}</h3>
</body>
</html>
