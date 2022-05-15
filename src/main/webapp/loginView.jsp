<%--
  Created by IntelliJ IDEA.
  User: carl0
  Date: 2021/9/28
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>[Login] Kalos UserSystem</title>
</head>
<body>
<form method="GET" action="login">
    <input type="text" value="654" name="id" required>
    <br>
    <input type="password" value="12345678" name="password" required>
    <br>
    <button type="submit" >
        <span>登录</span>
    </button>
</form>
</body>
</html>
