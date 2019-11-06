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

<form method="post" action="/matchs">
    <input type="submit" name="submit" value="Matchs">
</form>

<form method="post" action="/tourmaments">
    <input type="submit" name="submit" value="Tourmaments">
</form>

<form method="post" action="/editdata">
    <p><input type="submit" value="Edit Data"></p>
</form>

<form method="post" action="/profile">
    <p><input type="submit" value="Profile"></p>
</form>

</body>
</html>
