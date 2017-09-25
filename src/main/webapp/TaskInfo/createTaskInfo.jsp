<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2017/9/5
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建清单</title>
</head>
<body>
<form action="/TaskInfo/addTaskInfo" method="post" >
    <table>
        <tr>
            <td>任务清单名称：<input type="text" name="taskinfoName"></td>
        </tr>
        <tr>
            <td>任务清单描述：<input type="text" name="takinfoDescribe"></td>
        </tr>
        <tr>
            <td>任务清单创建者：<input type="text" name="taskinfoUser"></td>
        </tr>
        <tr>
            <td><input type="submit" name="submit" value="创建清单"></td>
        </tr>
        <a href="/TaskInfo/taskInfoList">查看任务清单列表</a>
    </table>
</form>
</body>
</html>
