<%--
  Created by IntelliJ IDEA.
  User: Jiang Lei
  Date: 2020/2/1
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登出</title>
</head>
<body>
<form action="/logout/page" method="post">
    <p>
        <input type="submit" value="登出">
    </p>
    <input type="hidden" id="${_csrf.parameterName}"
           name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</body>
</html>
