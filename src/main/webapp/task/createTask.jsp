<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2017/9/4
  Time: 8:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加任务</title>
</head>
<body>
<form action="/Task/AddTask" method="post" >
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
        <c:if test="${TaskinfoId!=null}">
            <input type="text" name="taskinfoid" value="${TaskinfoId}">
            <input type="text" name="aa" value=1>
        </c:if>
        <tr>
            <td><input type="submit" name="submit" value="添加任务"></td>
        </tr>
        <a href="/Task/TaskList">查看任务列表</a>
    </table>
</form>
</body>
</html>
