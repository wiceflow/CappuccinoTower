<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2017/9/7
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/Folder/UpdateFolder" method="post">
<table>
    <tr>
        <td><input type="text " name="folderId" value="${folder1.folderId}"></td>
    </tr>
    <tr>
        <td>文件夹名称：<input type="text" name="folderName" value="${folder1.folderName}"></td>
    </tr>
    <tr>
        <td><input type="submit" name="submit" value="修改"></td>
    </tr>
</table>
</form>
</body>
</html>
