<%--
  Created by IntelliJ IDEA.
  User: One
  Date: 09.10.2019
  Time: 17:43
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
    <c:forEach var="freeTeams" items="${freeTeams}">
        <li>
            <a href="/teaminfo?name=${freeTeams}">  <c:out value="${freeTeams}" />  </a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
