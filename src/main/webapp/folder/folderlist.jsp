<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2017/9/6
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${folderList}" var="folderList">
    <span>${folderList.folderName}</span>
    <a href="/Folder/FolderInfo?folderId=${folderList.folderId}">修改文件夹</a>
    <a href="/Folder/DeleteFolder?folderId=${folderList.folderId}">删除文件夹</a>
</c:forEach>
</body>
</html>
