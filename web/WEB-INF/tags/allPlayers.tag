<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ul>
    <c:forEach var="players" items="${players}">
        <li>
            <a href="/playerinfo?name=${players}">  <c:out value="${players}" />  </a>
        </li>
    </c:forEach>
</ul>