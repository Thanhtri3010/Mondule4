<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 13/07/2022
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<form method="post">
    <input type="text" name="search" placeholder="Enter your word">
    <input type="submit" id="submit" value="Search">
    <h3>Translate : ${result}</h3>

</form>
</body>
</html>
