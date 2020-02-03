<%--
  Created by IntelliJ IDEA.
  User: Jiang Lei
  Date: 2020/1/31
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表单定义HTTP动作</title>
</head>
<body>
<form id="form" action="./name" method="post">
    <table>
        <tr>
            <td>用户编号</td>
            <td><input id="id" name="id"></td>
        </tr>
        <tr>
            <td>用户名称</td>
            <td><input id="userName" name="userName"></td>
        </tr>
        <tr>
            <td></td>
            <td align="right">
                <input id="submit" name="submit" type="submit">
            </td>
        </tr>
    </table>
    <input type="hidden" name="_method" id="_method" value="PATCH">
</form>
</body>
</html>
