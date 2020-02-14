<%--
  Created by IntelliJ IDEA.
  User: Jiang Lei
  Date: 2020/1/30
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Spring MVC国际化</title>
</head>
<body>
<a href="./page?language=zh_CN">简体中文</a>
<a href="./page?language=en_US">美国英文</a>
<h2>
    <spring:message code="msg"/>
</h2>
Locale: ${pageContext.response.locale}
</body>
</html>
