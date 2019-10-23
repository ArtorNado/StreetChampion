<%--
  Created by IntelliJ IDEA.
  User: One
  Date: 04.10.2019
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LoginPage</title>
</head>
<body>
<form method="post" action="/profile">
    Login<input type="text" name="login" value="${cookies.name}">
    Password<input name="password" type="password" value="${cookies.password}">
    Remember me<input type="checkbox" name="checkBox">
    <input type="submit" value="Log in">
</form>
<form method="post" action="/registration">
    <input type="submit" value="Registration">
</form>
</body>
</html>
