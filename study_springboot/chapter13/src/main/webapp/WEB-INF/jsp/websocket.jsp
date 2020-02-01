<%--
  Created by IntelliJ IDEA.
  User: Jiang Lei
  Date: 2020/2/1
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My WebSocket</title>
    <script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../../js/websocket.js"></script>
</head>
<body>
测试一下WebSocket站点吧
<br/>
<input id="message" type="text">
<button onclick="sendMessage()">发送消息</button>
<button onclick="closeWebSocket()">关闭WebSocket连接</button>
<div id="context"></div>
</body>
</html>
