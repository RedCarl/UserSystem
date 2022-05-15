<%--
  Created by IntelliJ IDEA.
  User: carl0
  Date: 2022/5/15
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>[Register] Kalos UserSystem</title>
</head>
<body>
<form method="GET" action="register">
    账号: <input type="text" value="" name="id" required>
    <br>
    名称: <input type="text" value="" name="name" required>
    <br>
    密码: <input type="password" value="" name="password" required>
    <br>
    年龄: <input type="text" value="" name="age" required>
    <br>
    性别:
    <input type="radio" value="0" name="sex" required>男
    <input type="radio" value="1" name="sex" required>女
    <br>
    <button type="submit" >
        注册
    </button>
</form>
</body>
</html>
