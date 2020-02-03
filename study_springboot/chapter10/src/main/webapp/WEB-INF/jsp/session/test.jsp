<%@ page import="com.springboot.chapter10.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: Jiang Lei
  Date: 2020/1/30
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试@SessionAttributes</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    Long id = (Long) session.getAttribute("id_new");
    out.print("<br>user_name = " + user.getUserName());
    out.print("<br>id_name = " + id);
%>
</body>
</html>
