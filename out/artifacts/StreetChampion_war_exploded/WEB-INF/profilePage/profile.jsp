<%--
  Created by IntelliJ IDEA.
  User: One
  Date: 04.10.2019
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="/menu">
        <p>Login: ${userr.name}</p>
        <p>First Name: ${userData.firstName}</p>
        <p>Secon Name: ${userData.secondName}</p>
        <p>Age: ${userData.age}</p>
        <p>Raiting: ${userData.avarageRaiting }</p>
    <%--<p>Password: ${userr.password}</p>--%>
        <p><input type="submit" value="Menu"></p>
    </form>
</body>
</html>
