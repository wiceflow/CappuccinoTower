<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>注册页面</title>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="resources/css/register.css"/>
    <link rel="stylesheet" type="text/css" href="resources/js/jquery-easyui-1.4.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="resources/js/jquery-easyui-1.4.5/themes/icon.css">
    <script type="text/javascript" src="resources/js/jquery-easyui-1.4.5/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
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
            $("#a3").hover(function () {
                $("#a2").fadeToggle()
            })
        })
        function register2() {
            var tName = $("#td1").val();
            var uName = $("#td2").val();
            var uEmail = $("#td3").val();
            var uPassword = $("#td4").val();

            $.post(
                '${pageContext.request.contextPath}/user/register',
                {
                    uName: uName,
                    uEmail:uEmail,
                    uPassword:uPassword,
                    tName: tName,
                },
                function (date, status) {
                    alert("注册成功");
                }

            )
        }
    </script>

</head>
<body style="background-color: black;text-align: center;">
<div>
    <div style="text-align: center;color:pink;font-size:80px;font-family: '微软雅黑';margin-top: 50px;">
        <b>Power</b>
    </div>
    <form id="ff" style="text-align: center;">
        <table align="center" cellpadding="10">
            <tr>
                <td>
                    <input name="teamname"
                           id="td1"
                           class="easyui-textbox"
                           data-options="required:true"
                           value="请输入团队名称"
                           style="height: 30px;width: 300px;"
                    >

                </td>
            </tr>

            <tr>
                <td>
                    <input name="name" class="easyui-textbox"
                           data-options="required:true"
                           id="td2"
                           value="请输入你的名字"
                           style="height: 30px;width: 300px;font-weight: bold;">
                </td>
            </tr>

            <tr>
                <td>
                    <input name="email" class="easyui-textbox"
                           data-options="required:true,validType:'email'"
                           id="td3"
                           value="请输入有效邮箱，例如：510024166@qq.com"
                           style="height: 30px;width: 300px;color:darkgrey;font-weight: bold;">
                </td>
            </tr>

            <tr>
                <td>
                    <input name="password" class="easyui-textbox"
                           data-options="required:true"
                           id="td4"
                           value="请设置密码(至少包含6个字符)"
                           style="height: 30px;width: 300px;color: darkgrey;font-weight: bold;">
                </td>
            </tr>


        </table>
    </form>

    <div style="text-align: center;margin-bottom:20px;margin-top: -70px; ">
        <a href="#" class="button" style="color: black;margin-bottom: 20px;" onclick="register2()"><b>完成注册</b></a>
    </div>
    <p style="color: grey;text-align: center;margin-top: 20px;" id="a3">
        <a id="a2" href="login.jsp" style="color: grey;">直接登录→</a>
        </br>
        <span id="a1">已有power账户？</span></p>
    <p style="margin-top: 200px;text-align: center;font-family:tahoma;font-size: 15px;">
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
