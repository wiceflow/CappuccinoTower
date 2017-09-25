<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2017/8/30
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="/file/uploadfile" method="post" enctype="multipart/form-data">
    <table>
        <tr><input type="file" name="file"/></tr>
        <tr><input type="submit" name="submit" value="上传"/></tr>
        <tr>
            <td><a href="/listfile">查看文件列表</a></td>
        </tr>
    </table>
</form>
</body>
</html>
