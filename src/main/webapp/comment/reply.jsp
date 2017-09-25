<%--
  Created by IntelliJ IDEA.
  User: WU
  Date: 2017/9/5
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>模拟回复页面</title>
</head>
<body>
    <form action="/Comment/insert" method="post">
        <p>小王的评论：</p>
        <p>aaaaaaa</p>
        <%--模拟任务ID--%>
        <input type="text" name="taskId" value="1">
        <%--模拟将被评论的人的信息存入表中--%>
        <input type="text" name="bcId" value="2">
        <input type="text" name="buUsername" value="小王">
        <input type="text" name="buId" value="4">
        <br>
        <br>
        <br>
        <input type="text" name="uId" value="2"><BR>
        <input type="text" name="uName" value="小赵"><BR>
        <input type="text" name="cContent"><BR>
        <input type="text" name="type" value="2" hidden><br>
        <input type="submit" value="回复">

    </form>
</body>
</html>
