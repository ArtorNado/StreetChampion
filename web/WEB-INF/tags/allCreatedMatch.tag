<%@ tag import="dbWorker.matchQuery.MatchQuery" %>
<%@ tag import="matchs.MatchBean" %>
<%@ tag import="java.util.ArrayList" %>
<%@ tag import="matchs.finishMatch.FinishMatchDAO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<% MatchQuery matchQuery = new MatchQuery();
    Boolean check = matchQuery.checkCreratedMatch((Integer) session.getAttribute("userId"));
    if (check) {
        FinishMatchDAO dao = new FinishMatchDAO();
        ArrayList<MatchBean> allCreatedMatch = new ArrayList();
        int userId = (Integer) session.getAttribute("userId");
        allCreatedMatch = dao.getAllCreatedMatch(allCreatedMatch, userId);
        out.print("<tr>\n" +
                "    <th>id</th>\n" +
                "    <th>Info</th>\n" +
                "    <th>Players</th>\n" +
                "</tr>");
        for (MatchBean i : allCreatedMatch) {
            out.print("<td>"+i.getId()+"</td>\n" +
                    "        <td>"+i.getInfo()+"</td>\n" +
                    "        <td><a href=\"/playerlist?id="+ i.getId() +"\"> "+i.getPlayers()+"/"+i.getCurPlayers()+" </a></td>\n" +
                    "        <td><input type=\"button\" onClick=\"location.href='/finishmatch?id="+i.getId()+"'\" value=\"Finish\" > </td>\n" +
                    "    </tr>");
        }
    } else
        out.print("<p> Not created matchs </p>");
%>