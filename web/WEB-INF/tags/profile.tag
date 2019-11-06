<%@ tag import="dbWorker.Query" %>
<% Query query = new Query();
    Boolean check = query.checkTeam((Integer) session.getAttribute("userId"));
    if (check) {
        int teamId = query.getTeam((Integer) session.getAttribute("userId"));
        String teamName = query.getTeamName(teamId);
        out.println("<a href=\"/teaminfo?name=" + teamName + "\"> " + teamName + "</a>");
    } else
        out.print("<p> Dont have team </p>");
%>