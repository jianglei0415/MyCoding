<%--
  Created by IntelliJ IDEA.
  User: Jiang Lei
  Date: 2020/1/29
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello Spring Boot</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        function post(user) {
            var url = "./save";
            $.post({
                url: url,
                contentType: "application/json",
                data: JSON.stringify(user),
                success: function (result, status) {
                    if (result == null || result.id == null) {
                        alert("插入失败");
                        return;
                    }
                }
            });
        }

        for (var i = 1; i <= 10; i++) {
            var user = {
                'id': i,
                'userName': 'user_name_' + i,
                'roles': [{
                    'id': i,
                    'roleName': 'role_' + i,
                    'note': 'note_' + i
                }, {
                    'id': i + 1,
                    'roleName': 'role_' + (i + 1),
                    'note': 'note_' + (i + 1)
                }]
            };
            post(user);
        }
    </script>
</head>
<body>
<h1>操作MongoDB文档</h1>
</body>
</html>
