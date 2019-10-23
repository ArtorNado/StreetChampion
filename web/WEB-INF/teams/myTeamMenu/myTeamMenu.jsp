<%--
  Created by IntelliJ IDEA.
  User: One
  Date: 14.10.2019
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="get" <%--action="/myteamsquad?id=${teamInfoBean.id}"--%>>
    <%--<input type="submit" value="Squad">--%>
    <input type="button" onClick="location.href='/myteamsquad?id=${teamInfoBean.id}'" value="Squad" >
</form>

</body>
</html>
