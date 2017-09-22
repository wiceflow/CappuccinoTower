<%--
  Created by IntelliJ IDEA.
  User: WU
  Date: 2017/8/30
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询后</title>
</head>
<body>
<form action="/project/putProject" method="post">
    <c:forEach items="${listUser}" var="user">
        <input type="checkbox" name="uId" value="${user.uId}">
        <span>${user.uName}</span>
    </c:forEach>
    <br>
    <input type="submit" value="添加">
</form>
</body>
</html>
