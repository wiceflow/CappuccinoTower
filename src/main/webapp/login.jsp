<%--
  Created by IntelliJ IDEA.
  User: BF
  Date: 2017/8/29
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="resources/js/jquery-3.1.1.js"></script>
    <script type="text/javascript">
        function aa() {
            var count = $('#uname').val();
            var pwd = $('#psw').val();
            var a = 1;
            $.post(
                '${pageContext.request.contextPath}/User/login',
                {
                    uName: count,
                    uPicture: pwd,
                    aaa: a
                },
                function (text, status) {
                    if (text==true)
                    {
                        alert("登录成功");
                    }
                    if (text==false)
                    {
                        alert("登录失败");
                    }
                }
            )
        }
    </script>
</head>
<body>
    <input type="text" id="uname">
    <input type="text" id="psw">
    <button onclick="aa()"></button>
</body>
</html>
