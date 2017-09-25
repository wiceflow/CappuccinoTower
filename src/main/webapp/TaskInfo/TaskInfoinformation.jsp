<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2017/9/5
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/TaskInfo/updateTaskInfo" method="post">
    <table>
        <tr>
            <td><input type="text" name="taskinfoId" value="${taskinfo1.taskinfoId}" hidden></td>
        </tr>
        <tr>
            <td>任务清单名称：<input type="text" name="taskinfoName" value="${taskinfo1.taskinfoName}"></td>
        </tr>
        <tr>
            <td>任务清单描述：<input type="text" name="takinfoDescribe" value="${taskinfo1.takinfoDescribe}"></td>
        </tr>
        <tr>
            <td><input type="submit" name="submit" value="修改清单"></td>
        </tr>
    </table>
</form>
</body>
</html>
