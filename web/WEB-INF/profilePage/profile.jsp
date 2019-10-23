<%@ page import="java.io.PrintWriter" %>
<%@ page import="dbWorker.Query" %><%--
  Created by IntelliJ IDEA.
  User: One
  Date: 04.10.2019
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/menu">
    <p>Login: ${userr.name}</p>
    <p>First Name: ${userData.firstName}</p>
    <p>Secon Name: ${userData.secondName}</p>
    <p>Age: ${userData.age}</p>aa
    <p>Raiting: ${userData.avarageRaiting }</p>
    <% Query query = new Query();
    Boolean check = query.checkTeam((Integer) session.getAttribute("userId"));
        if(check){
            int teamId = query.getTeam((Integer)session.getAttribute("userId"));
            String teamName = query.getTeamName(teamId);
            out.println("<a href=\"/teaminfo?name=" + teamName + "\"> " + teamName + "</a>");
    } else
        out.print("<p> Dont have team </p>");
    %>
    <%--<p>Password: ${userr.password}</p>--%>
    <p><input type="submit" value="Menu"></p>
</form>
</body>
</html>
