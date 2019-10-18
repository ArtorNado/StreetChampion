<%--
  Created by IntelliJ IDEA.
  User: One
  Date: 09.10.2019
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="get" action="">
    <p>Name: ${team.name}</p>
    <p name = "id" value="${team.id}">Id: ${team.id} </p>
    <input type="button" onClick="location.href='/allplayers?name=${team.id}'" value="Squad" >
</form>

</body>
</html>
