<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2017/9/5
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${taskinfoList}" var="taskinfoList">
    <span>${taskinfoList.taskinfoName}</span>
    <a href="/TaskInfo/TaskInfoinformation?taskinfoid=${taskinfoList.taskinfoId}">修改任务</a>
    <a href="/TaskInfo/deleteTaskInfo?taskinfoid=${taskinfoList.taskinfoId}">删除</a>
</c:forEach>
</body>
</html>
