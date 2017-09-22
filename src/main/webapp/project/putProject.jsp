<%--
  Created by IntelliJ IDEA.
  User: WU
  Date: 2017/8/29
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src="../resources/js/jquery-3.1.1.js"></script>
    <title>输入项目信息</title>
</head>
<body>
<form action="/project/putProject" method="post">
    <div>
        <tr>
            <td>项目名称</td>
            <td><input type="text" name="pName"></td>
        </tr>
        <br>
        <tr>
            <td>项目描述</td>
            <td><input type="text" name="pDescribe"></td>
            <td><input type="checkbox" name="pSensitive" value="1">是否屏蔽敏感词汇</td>
        </tr>
        <br>
        <tr>
            <td>是否公开</td>
            <td><input type="radio" value="0" name="ispublic" checked="checked">公开</td>
            <td><input type="radio" value="1" name="ispublic">私密</td>
        </tr>
        <br>
        <tr>
        </tr>
        <br>
        <tr>
            <c:forEach items="${listUser}" var="user">
               <input type="checkbox" name="uId" value="${user.uId}">
                <span>${user.uName}</span>
            </c:forEach>
        </tr>
        <br>
        <div>

        </div>
        <br>
      <tr>
          <input type="submit" value="提交">
      </tr>


    </div>
</form>
</body>
</html>
