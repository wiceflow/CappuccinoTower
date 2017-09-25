<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2017/9/4
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>成功</h1>
<input type="text" name="taskid" value="${taskid}" hidden>
<a href="/Task/Taskinformation?taskid=${taskid}">查看该任务详情</a>
<br>
<br>
<input type="text" name="taskinfoid" value="${TaskinfoId}" hidden>
<a href="/TaskInfo/TaskInfoinformation?taskinfoid=${TaskinfoId}">查看该任务清单详情</a>
<br>
<br>

</body>
</html>
