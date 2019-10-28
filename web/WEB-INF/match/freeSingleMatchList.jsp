<%--
  Created by IntelliJ IDEA.
  User: One
  Date: 25.10.2019
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>Info</th>
        <th>Players</th>
<%--
        <th>Data and time</th>
--%>
    </tr>
    <tag:freeSingleMatchTag></tag:freeSingleMatchTag>
</table>
</body>
</html>
