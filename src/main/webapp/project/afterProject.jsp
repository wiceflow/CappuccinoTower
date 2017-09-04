<%--
  Created by IntelliJ IDEA.
  User: WU
  Date: 2017/8/29
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建成功</title>
</head>
<body>
项目ID：${pId}<br>
项目名成：${ProjectName}<BR>
项目描述: ${ProjectDescribe}<BR>
<a href="/project/selectProjectById?pId=${pId}"><button>修改</button></a><br>
<a href="/project/deleteProject?pId=${pId}"><button>删除</button></a>
</body>
</html>
