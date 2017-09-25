<%--
  Created by IntelliJ IDEA.
  User: WU
  Date: 2017/9/4
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评论表</title>
</head>
<body>
    <form action="/Comment/insert" method="post">
        模拟自己的ID：<input type="text" name="uId" value="2">
        模拟任务ID：<input type="text" name="taskId" value="2">
        模拟用户名uName:<input type="text" name="uName" value="小赵">

        评论内容：<input type="text" name="cContent">
        <input type="text" name="type" value="0" hidden>
        评论: <input type="submit" value="评论">
    </form>
    <a href="/Comment/queryComment?taskid=1">显示评论</a>

</body>
</html>
