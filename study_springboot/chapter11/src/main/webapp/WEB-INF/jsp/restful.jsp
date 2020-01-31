<%--
  Created by IntelliJ IDEA.
  User: Jiang Lei
  Date: 2020/1/31
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello Spring Boot</title>
    <script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        function post() {
            var params = {
                'userName': 'user_name_new',
                'sexCode': 1,
                'note': 'note_new'
            };
            $.post({
                url: "./user",
                contentType: "application/json",
                data: JSON.stringify(params),
                success: function (result) {
                    if (result == null || result.id == null) {
                        alert("插入失败");
                        return;
                    }
                    alert("插入成功");
                }
            });
        }

        function get() {
            $.get("./user/1", function (user, status) {
                if (user == null) {
                    alert("结果为空");
                } else {
                    alert("用户信息为：" + JSON.stringify(user));
                }
            });
        }

        function updateUser() {
            var params = {
                'userName': 'user_name_1_new',
                'sexCode': 1,
                'note': 'note_new_1'
            };
            $.ajax({
                url: "./user/1",
                type: 'PUT',
                contentType: "application/json",
                data: JSON.stringify(params),
                success: function (user, status) {
                    if (user == null) {
                        alert("结果为空");
                    } else {
                        alert(JSON.stringify(user));
                    }
                }
            });
        }

        function updateUserName() {
            $.ajax({
                url: "./user/1/user_name_patch",
                type: "PATCH",
                success: function (result, status) {
                    if (result == null) {
                        alert("结果为空");
                    } else {
                        alert(result.success ? "更新成功" : "更行失败");
                    }
                }
            });
        }

        function deleteUser() {
            $.ajax({
                url: "./user/1",
                type: 'DELETE',
                success: function (result) {
                    if (result == null) {
                        alert("结果为空");
                    } else {
                        alert(result.success ? "删除成功" : "删除失败");
                    }
                }
            });
        }

        function postStatus() {
            var params = {
                'userName': 'user_name_new',
                'sexCode': 1,
                'note': 'note_new'
            };
            var url = "./user2/entity";
            $.post({
                url: url,
                contentType: "application/json",
                data: JSON.stringify(params),
                success: function (result, status, jqXHR) {
                    var success = jqXHR.getResponseHeader("success");
                    var status = jqXHR.status;
                    alert("响应头参数是：" + success + ",状态是：" + status);
                    if (result == null || result.id == null) {
                        alert("插入失败");
                        return;
                    }
                    alert("插入失败");
                }
            });
        }
    </script>
</head>
<body>
<h1>测试RESTful下的请求</h1>
</body>
</html>
