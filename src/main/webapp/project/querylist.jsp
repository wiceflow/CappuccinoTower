<%--
  Created by IntelliJ IDEA.
  User: WU
  Date: 2017/9/1
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>遍历用户项目</title>
</head>
<body>
    <c:forEach items="${projectList}" var="project">
        ${project.pName}<br>
    </c:forEach>
</body>
</html>
