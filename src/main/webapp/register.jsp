<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2017/8/29
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册用户</title>
</head>
<body>
<form action="/User/register" method="post">
    团队名称：
    <input type="text" name="tName"/>
    你的名字：
    <input type="text" name="uName"/>
    邮箱地址：
    <input type="text" name="uEmail"/>
    密码：
    <input type="text" name="uPassword"/>
    <input type="submit" name="register" value="注册"/>
    已有Tower账户？<a href="login.jsp">直接登录</a>
</form>
</body>
</html>
