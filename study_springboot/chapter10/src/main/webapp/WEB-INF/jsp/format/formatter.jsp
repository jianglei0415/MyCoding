<%--
  Created by IntelliJ IDEA.
  User: Jiang Lei
  Date: 2020/1/30
  Time: 1:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>格式化</title>
</head>
<body>
<form action="./commit" method="post">
    <table>
        <tr>
            <td>日期（yyyy-MM-dd）</td>
            <td>
                <input type="text" name="date" value="2020-01-30"/>
            </td>
        </tr>
        <tr>
            <td>金额（#,###.##)</td>
            <td>
                <input type="text" name="number" value="1,234,567.89"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="submit" value="提交"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
