<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2017/9/6
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建文件夹</title>
</head>
<body>
<form action="/Folder/AddFolder" method="post" >
    <table>
        <tr>
            <td>文件夹名：<input type="text" name="folderName"></td>
        </tr>
        <tr>
            <td><input type="submit" name="submit" value="创建"></td>
        </tr>
        <tr>
            <td><a href="/Folder/FolderList?folderId=${folderId}">查看文件夹列表</a></td>
        </tr>
    </table>
</form>
</body>
</html>
