<%--
  Created by IntelliJ IDEA.
  User: One
  Date: 04.10.2019
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="/allteams">
    <input type="submit" name="submit" value="Teams">
</form>

<form method="post" action="/freeteams">
    <input type="submit" name="submit" value="Free Teams">
</form>

<form method="post" action="/createteam">
    <input type="submit" name="submit" value="Create Team">
</form>

<form method="post" action="/myteammenu">
    <input type="submit" name="submit" value="My Team">
</form>

<form method="post" action="/allfreesinglematch">
    <input type="submit" name="submit" value="Free Match">
</form>


</body>
</html>
