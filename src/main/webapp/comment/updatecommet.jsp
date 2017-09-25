<%--
  Created by IntelliJ IDEA.
  User: WU
  Date: 2017/9/5
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改页面</title>
</head>
<body>
<form action="/Comment/updateComment" method="post">
    <input type="text" name="cId" value="${comment.cId}" hidden >
    <input type="text" name="cContent" value="${comment.cContent}">
    <input type="submit" value="修改">
</form>
</body>
</html>
