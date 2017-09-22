<%--
  Created by IntelliJ IDEA.
  User: WU
  Date: 2017/8/31
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src="../resources/js/jquery-3.1.1.js"></script>
    <title>修改页面</title>
</head>
<body>
    <form action="/project/updateProject" method="post">
        <input name="pId" value="${project.pId}" type="hidden">
        项目名称：<input name="pName" value="${project.pName}"><br>
        项目描述:<input name="pDescribe" value="${project.pDescribe}">
        <c:if test="${project.pSensitive==0}">
            <input type="checkbox" name="pSensitive" value="1" >是否屏蔽敏感词汇
        </c:if>
        <c:if test="${project.pSensitive==1}">
            <input type="checkbox" name="pSensitive" value="1" checked="checked">是否屏蔽敏感词汇
        </c:if>
        <br>

        <input type="submit" value="修改">
    </form>

</body>
</html>