<%--
  Created by IntelliJ IDEA.
  User: Jiang Lei
  Date: 2020/1/30
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试JSR-303</title>
    <script src="../../../js/jquery-3.2.0.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            var pojo = {
                id: null,
                date: '2020-01-30',
                doubleValue: 999999.09,
                integer: 100,
                range: 1000,
                email: 'email',
                size: 'adv1212',
                regexp: 'a,b,c,d'
            };
            $.post({
                url: "./validate",
                contentType: "application/json",
                data: JSON.stringify(pojo),
                success: function (result) {

                }
            });
        });
    </script>
</head>
<body>

</body>
</html>
