<%--
  Created by IntelliJ IDEA.
  User: Jiang Lei
  Date: 2020/1/30
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form method="post" action="./request" enctype="multipart/form-data">
    <input type="file" name="file" value="请选择上传文件">
    <input type="submit" value="提交">
</form>
</body>
</html>
