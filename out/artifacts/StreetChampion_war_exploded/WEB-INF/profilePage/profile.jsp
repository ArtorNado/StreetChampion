<%@ page import="java.io.PrintWriter" %>
<%@ page import="dbWorker.Query" %><%--
  Created by IntelliJ IDEA.
  User: One
  Date: 04.10.2019
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/menu">
    <p>Login: ${userr.name}</p>
    <p>First Name: ${userData.firstName}</p>
    <p>Second Name: ${userData.secondName}</p>
    <p>Age: ${userData.age}</p>aa
    <p>Raiting: ${userData.avarageRaiting }</p>
    <tag:profile></tag:profile>
    <%--<p>Password: ${userr.password}</p>--%>
    <p><input type="submit" value="Menu"></p>
</form>
<form method="post" action="/logout">
    <p><input type="submit" value="Log out"></p>
</form>
</body>
</html>
