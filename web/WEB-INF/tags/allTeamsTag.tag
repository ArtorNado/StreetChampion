<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ul>
    <c:forEach var="teams" items="${teams}">
        <li>
            <a href="/teaminfo?name=${teams}">  <c:out value="${teams}" />  </a>
        </li>
    </c:forEach>
</ul>