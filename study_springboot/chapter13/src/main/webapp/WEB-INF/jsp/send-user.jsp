<%--
  Created by IntelliJ IDEA.
  User: Jiang Lei
  Date: 2020/2/2
  Time: 2:00
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
    var stompClient = null;

    function setConnected(connected) {
        $("#connect").attr({"disabled": connected});
        $("#disconnect").attr({"disabled": !connected});
        if (connected) {
            $("#conversationDiv").show();
        } else {
            $("#conversationDiv").hide();
        }
        $("#response").html("");
    }

    function connect() {
        var socket = new SockJS('/wsUser');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            setConnected(true);
        });
    }

    function disconnect() {
        if (stompClient != null) {
            stompClient.disconnect();
        }
        setConnected(false);
        console.log("Disconnected");
    }

    function sendMsg() {
        var value = $("#message").val();
        var user = $("#user").val();
        var text = user + "," + value;
        stompClient.send("/request/sendUser", {}, text);
    }

    connect();
</script>
<body>
<div>
    <div>
        <button id="connect" onclick="connect();">连接</button>
        <button id="disconnect" disabled="disabled" onclick="disconnect();">断开连接</button>
    </div>
    <div id="conversationDiv">
        <p>
            <label>发送给用户</label>
        </p>
        <p>
            <input type="text" id="user"/>
        </p>
        <p>
            <label>发送的内容</label>
        </p>
        <p>
            <textarea id="message" rows="5"></textarea>
        </p>
        <button id="sendMsg" onclick="sendMsg();">发送</button>
        <p id="response"></p>
    </div>
</div>
</body>
</html>
