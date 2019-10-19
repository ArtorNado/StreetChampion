<%--
  Created by IntelliJ IDEA.
  User: One
  Date: 17.10.2019
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="/addRaiting?name=${playerBean.name}">
    <input type="hidden" name="name" value="${playerBean.name}">
    <p> Name: ${playerBean.name}</p>
    <p> Raiting: ${playerBean.avarageRaiting} </p>
    <select name="raitingValue">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10" selected>10</option>
    </select>
    <input type="submit" value="Отправить оценку">

</form>
</body>
</html>
