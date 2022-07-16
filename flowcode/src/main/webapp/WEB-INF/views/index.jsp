<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 15/07/2022
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Calculator</h2>
<form action="calculate" method="get">
    <input type="text" pattern="[0-9]+([\.][0-9]{0,2})?"  name="number1" value="${number1}">
    <select name="operator">
        <option value="addition">Addition (+)</option>
        <option value="subtract">Subtraction (-)</option>
        <option value="multiple">Multiplication (*)</option>
        <option value="divide">Division(/)</option>
    </select>
    <input type="text"    pattern="[0-9]+([\.][0-9]{0,2})?" name="number2" value="${number2}">
    <button>Result</button>
</form>
<h3>${result}</h3>
</body>
</html>
