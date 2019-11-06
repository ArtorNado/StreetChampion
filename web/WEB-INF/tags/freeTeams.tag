<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ul>
    <c:forEach var="freeTeams" items="${freeTeams}">
        <li>
            <a href="/teaminfo?name=${freeTeams}">  <c:out value="${freeTeams}" />  </a>
        </li>
    </c:forEach>
</ul>