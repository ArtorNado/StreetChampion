<%--
  Created by IntelliJ IDEA.
  User: One
  Date: 04.10.2019
  Time: 22:39
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
    <c:forEach var="teams" items="${teams}">
        <li>
            <a href="/teaminfo?name=${teams}">  <c:out value="${teams}" />  </a>
        </li>
    </c:forEach>

</ul>
</body>
</html>
