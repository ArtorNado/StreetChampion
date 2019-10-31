<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach var="freeSingleMatchs" items="${freeSingleMatchs}">
    <tr>
        <td>${freeSingleMatchs.id}</td>
        <td>${freeSingleMatchs.info}</td>
        <td><a href="/playerlist?id=${freeSingleMatchs.id}"> <c:out value="${freeSingleMatchs.players}/${freeSingleMatchs.curPlayers}"/></a></td>
        <td><input type="button" onClick="location.href='/subsingmatch?id=${freeSingleMatchs.id}'" value="Subscribe" > </td>
    </tr>
</c:forEach>