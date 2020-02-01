<%--
  Created by IntelliJ IDEA.
  User: Jiang Lei
  Date: 2020/2/2
  Time: 2:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My WebSocket</title>
    <script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../../js/sockjs.min.js"></script>
    <script type="text/javascript" src="../../js/stomp.min.js"></script>
</head>
<script type="text/javascript">
    var noticeSocket = function () {
        var s = new SockJS('/wsUser');
        var stompClient = Stomp.over(s);
        stompClient.connect({}, function () {
            console.log('notice socket connected!');
            stompClient.subscribe('/user/queue/customer', function (data) {
                $('#receive').html(data.body);
            });
        });
    };
    noticeSocket();
</script>
<body>
<h1>
    <span id="receive">等待接收消息</span>
</h1>
</body>
</html>
