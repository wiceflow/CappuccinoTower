<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2017/9/4
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${tasklist}" var="tasklist">
    <span>${tasklist.taskName}</span>
    <a href="/Task/Taskinformation?taskid=${tasklist.taskId}">修改任务</a>
    <a href="/Task/TaskDelete?taskid=${tasklist.taskId}">删除</a>
</c:forEach>
</body>
</html>
