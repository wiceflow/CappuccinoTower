<%@ page import="com.pojo.Task" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2017/9/4
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/Task/UpdateTask" method="post" >
<table>
    <tr>
        <td><input type="text" name="taskId" value="${task2.taskId}" hidden></td>
    </tr>
    <tr>
        <td>任务名：<input type="text" name="taskName" value="${task2.taskName}"></td>
    </tr>
    <tr>
        <td>任务创建人：<input type="text" name="taskUser" value="${task2.taskUser}"></td>
    </tr>
    <tr>
        <td>任务被指派人：<input type="text " name="taskAssigner" value="${task2.taskAssigner}"></td>
    </tr>
    <tr>
        <td>创建时间：${task2.taskCreatetime}</td>
    </tr>
    <tr>
        <td>状态：<input type="text" name="status" value="${task2.status}"></td>
    </tr>
    <tr>
        <td>任务描述：<input type="text" name="taskDescribe" value="${task2.taskDescribe}"></td>
    </tr>
    <tr>
        <td><input type="submit" name="submit" value="修改任务"></td>
    </tr>
</table>
</form>
</body>
</html>
