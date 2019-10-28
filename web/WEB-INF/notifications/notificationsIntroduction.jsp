<%--
  Created by IntelliJ IDEA.
  User: One
  Date: 19.10.2019
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <c:forEach var="message" items="${message}">
        <a href="/teaminfo?name=${message}"> <c:out value="Запрос от игрока ${message} на вступление в команду"/> </a>

        <form method="get">
            <input type="button" onClick="location.href='/trueanswer?id=${message}&teamid=${teamId}&type=1'" value="Yes" >
        </form>

        <form method="get" action="/notificationsintroduction">
            <input type="submit" value="No">
        </form>
    </c:forEach>
</ul>
</body>
</html>
