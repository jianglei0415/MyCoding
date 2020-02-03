<%--
  Created by IntelliJ IDEA.
  User: Jiang Lei
  Date: 2020/1/30
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session</title>
</head>
<body>
<%
    session.setAttribute("id", 2L);
    response.sendRedirect("./session/test");
%>
</body>
</html>
