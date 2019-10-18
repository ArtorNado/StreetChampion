<%--
  Created by IntelliJ IDEA.
  User: One
  Date: 17.10.2019
  Time: 13:01
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
    <c:forEach var="players" items="${players}">
        <li>
            <a href="/playerinfo?name=${players}">  <c:out value="${players}" />  </a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
