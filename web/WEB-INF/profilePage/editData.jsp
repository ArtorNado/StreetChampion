<%--
  Created by IntelliJ IDEA.
  User: One
  Date: 04.11.2019
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="/editdata">
    First Name <input type="text" name="firstName" value="${playerBean.firstName}">
    Second Name <input type="text" name="secondName" value="${playerBean.secondName}">
    Age <input type="text" name="age" value="${playerBean.age}">
    <input type="submit" value="Change">
</form>
</body>
</html>
