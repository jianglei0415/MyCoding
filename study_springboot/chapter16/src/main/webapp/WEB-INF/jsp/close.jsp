<%--
  Created by IntelliJ IDEA.
  User: Jiang Lei
  Date: 2020/2/3
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="../../js/jquery-3.2.0.js"></script>
    <script type="text/javascript">
        $.(document).ready(function () {
            $("#submit").click(function () {
                $.post({
                    url: "./actuator/shutdown",
                    success: function (result) {
                        if (result == null || result.message != null) {
                            alert(result.message);
                            return;
                        }
                        alert("关闭Spring Boot应用失败");
                    }
                });
            });
        });
    </script>
    <title>测试关闭请求</title>
</head>
<body>
<input id="submit" type="button" value="关闭应用"/>
</body>
</html>
