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
        <p>Name: ${userr.name}</p>
        <%--<p>Password: ${userr.password}</p>--%>
        <p><input type="submit" value="Menu"></p>
    </form>
</body>
</html>
