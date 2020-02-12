<%--
  Created by IntelliJ IDEA.
  User: Jiang Lei
  Date: 2020/2/2
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购买产品测试</title>
    <script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
</head>
<script type="text/javascript">
    // 一般情况
    // var params = {
    //     userId: 1,
    //     productId: 1,
    //     quantity: 3
    // };
    // $.post("./purchase", params, function (result) {
    //     alert(result.message);
    // });

    // 高并发情况
    for (var i = 1; i <= 1000; i++) {
        var params = {
            userId: 1,
            productId: 1,
            quantity: 1
        };
        $.post("./purchase", params, function (result) {

        });
    }
</script>
<body>
<h1>抢购产品测试</h1>
</body>
</html>
