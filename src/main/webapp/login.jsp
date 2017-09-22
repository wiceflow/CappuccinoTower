<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<title>登录页面</title>
<head>
    <title>Tower登录</title>
    <script type="text/javascript" src="resources/js/jquery-3.1.1.js"></script>
    <link rel="stylesheet" href="resources/css/login.css"/>
    <link rel="stylesheet" type="text/css" href="resources/js/jquery-easyui-1.4.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="resources/js/jquery-easyui-1.4.5/themes/icon.css">
    <script type="text/javascript" src="resources/js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
    <%--将注释转换成中文--%>
    <script type="text/javascript" src="resources/js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $("input").each(function () {
                //保存当前文本框的值
                var vdefault = this.value;
                //获得焦点时，如果值为默认值，则设置为空
                $(this).focus(function () {
                    if (this.value == vdefault) {
                        this.value = "";
                    }
                });
                //失去焦点时，如果值为空，则设置为默认值
                $(this).blur(function () {
                    if (this.value == "") {
                        this.value = vdefault;
                    }
                });
            });
            $("#a2").hide()
            $("#a1").hover(function () {
                $("#a2").fadeIn()
            })
        })
        function login() {
            var loginEmail = $("#loginEmail").val();
            var loginPsw = $("#loginPsw").val();
            $.post(
                '${pageContext.request.contextPath}/user/login',
                {
                    uEmail:loginEmail,
                    uPassword:loginPsw,
                    loginType:2
                },
                function (date) {
                    if (date.errcode==0)
                        alert("date.info");
                    else if (date.errcode==1)
                        alert("密码错误");
                    else if (date.errcode==2) {
                        alert(date.data.uName+ " 欢迎您");
                        location.href = "main.jsp";
                    }
                },"json"
            )
        }
        function register() {
            location.href = "register.jsp"
        }
    </script>

</head>
<body style="background-color: black;text-align: center;">
<div style="text-align: center;color:coral;font-size:80px;font-family: '微软雅黑';margin-top: 50px;">
    <b>Power</b>
</div>
<div>
    <form id="ff" style="text-align: center;">
        <table align="center" cellpadding="10">
            <tr>
                <td>
                    <input name="email" class="easyui-textbox"
                           data-options="required:true,validType:'email'"
                           value="请输入登录邮箱"
                           id="loginEmail"
                           style="height: 30px;width: 300px;color:darkgrey;font-weight: bold;">
                </td>
            </tr>

            <tr>
                <td>
                    <input name="password" class="easyui-textbox"
                           data-options="required:true"
                           value="请输入密码"
                           id="loginPsw"
                           style="height: 30px;width: 300px;color: darkgrey;font-weight: bold;">
                </td>
            </tr>

        </table>
    </form>
</div>

<div style="text-align: center;margin-bottom:20px;margin-top: -70px; ">
    <a href="#" class="button" style="color: black;margin-bottom: 20px;" onclick="login()"><b>登录</b></a>
</div>
<p style="color: grey;text-align: center;margin-top: 20px;">
    <a id="a2" href="#" style="color: grey;" onclick="register()">立即注册→</a></br>
    <span id="a1">没有power账户？</span>

</p>
<div>
    <p style="margin-top: 280px;text-align: center;font-family:tahoma;font-size: 15px;">
        <span style="color: lightskyblue;">C</span>
        <span style="color: plum;">a</span>
        <span style="color: lightskyblue;">p</span>
        <span style="color: plum;">p</span>
        <span style="color: lightskyblue;">u</span>
        <span style="color: plum;">c</span>
        <span style="color: lightskyblue;">c</span>
        <span style="color: plum;">i</span>
        <span style="color: lightskyblue;">n</span>
        <span style="color: plum;">o</span>
        <span style="color: orangered;">®</span>
    </p>
</div>

</body>
</html>
