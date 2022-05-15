<%--
  Created by IntelliJ IDEA.
  User: carl0
  Date: 2022/5/15
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>[Main] Kalos UserSystem</title>
</head>
<body>
<table border="1">
    <tr>
        <td>账户</td>
        <td>名称</td>
        <td>密码(加密)</td>
        <td>年龄</td>
        <td>性别</td>
        <td>注册时间</td>
    </tr>
    <c:forEach items="${userList.list}" var="s">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.password}</td>
            <td>${s.age}</td>
            <td>${s.sex}</td>
            <td>${s.regtime}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
