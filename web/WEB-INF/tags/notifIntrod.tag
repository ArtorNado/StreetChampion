<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
