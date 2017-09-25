<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2017/9/4
  Time: 11:08
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
            <td>任务名：<input type="text" name="taskName"></td>
        </tr>

        <tr>
            <td>任务创建人：<input type="text" name="taskUser"></td>
        </tr>
        <tr>
            <td>任务被指派人：<input type="text " name="taskAssigner" ></td>
        </tr>
        <tr>
            <td>状态：<input type="text" name="status"></td>
        </tr>
        <tr>
            <td>任务描述：<input type="text" name="taskDescribe"></td>
        </tr>
        <tr>
            <td><input type="submit" name="submit" value="修改任务"></td>
        </tr>
    </table>
</form>
</body>
</html>
