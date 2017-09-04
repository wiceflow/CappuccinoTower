<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2017/8/29
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人设置</title>
</head>
<body>
<form action="/User/update" method="post">
    <input type="file" name="uploadpicture" value="上传新头像"/>
    <table>
        <tr>
            <td><input ></td>
        </tr>
        <tr>
            <td>名字</td>
        </tr>
        <tr>
            <td><input type="text" name="uName"/></td>
        </tr>
        <tr>
            <td>邮箱</td>
        </tr>
        <tr>
            <td><<input type="text" name="uEmail"/></td>
        </tr>
        <tr>
            <td>密码</td>
        </tr>
        <tr>
            <td><input type="password" name="uPassword"/></td>
        </tr>
        <tr>
            <<input type="submit" name="submit" value="保存"/>
        </tr>
    </table>
</form>
</body>
</html>
