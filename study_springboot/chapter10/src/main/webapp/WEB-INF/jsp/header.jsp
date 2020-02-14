<%--
  Created by IntelliJ IDEA.
  User: Jiang Lei
  Date: 2020/1/31
  Time: 0:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取请求头参数</title>
    <script src="../../js/jquery-3.2.0.js"></script>
    <script type="text/javascript">
        $.post({
            url:"./user",
            headers:{id:'2'},
            success:function (user) {
                if(user==null||user.id==null){
                    alert("获取失败");
                    return;
                }
                alert("id="+user.id+", user_name="+user.userName+", note="+user.note);
            }
        });
    </script>
</head>
<body>

</body>
</html>
