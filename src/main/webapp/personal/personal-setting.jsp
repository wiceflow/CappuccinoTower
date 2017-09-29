<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2017/9/26
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人设置</title>
</head>
<body>
<head>
    <meta charset="utf-8" />
    <title>个人设置</title>
    <link rel="stylesheet" href="../resources/css/css.css" />
    <link rel="stylesheet" href="../resources/bright_css/style.css" type="text/css" />

    <link rel="stylesheet" type="text/css" href="../resources/js/jquery-easyui-1.4.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../resources/js/jquery-easyui-1.4.5/themes/icon.css">
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/jquery.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">
        $(document).ready(function(){
            $.ajax({
                type:"Post",
                url:"/user/selectUser",
                dataType:"json",
                success:function (result) {
                    if(result.errcode==1){
                        $("#nickname").append(result.data.uName);
                        $("#email").append(result.data.uEmail);
                        $("#password").append(result.data.uPassword);
                    }else if(result.errcode==0){
                        alert("个人信息加载失败");
                    }
                },
                error:function () {
                    alert("个人信息显示失败");
                }
            })
        })

        function updateUser() {
            $.ajax({
                type:"Post",
                url:"/user/update",
                dataType:"json",
                data:{
                    uName:$("#nickname").val(),
                    uEmail:$("#email").val(),
                    uPassword:$("#password").val(),
                },
                success:function (result) {
                    if(result.errcode==1){
                        alert("更新成功！");
                    }
                },
                error:function () {
                    alert("更新失败！");
                }
            })
        }
    </script>
</head>

<body style="background-color: #212121;">

<div style="text-align: center;">
    <br />
    <img src="../resources/images/fzl2.jpg" style="height: 100px;"/>
    <br><br>
    <div>
        <button class="ps_btn" style="font-size: 30px;">选择新头像</button>
        <p style="color: gray;">你可以选择png / jpg图片作为头像</p>
    </div>
</div>
<br /><br /><br />


<table align="center" cellpadding="10" style="margin-top: -50px;" >
    <tr>
        <td>
                 <span style="color: white;float: left;font-size: 20px;">昵称</span>&nbsp;
                <textarea cols="20" rows="1" id="nickname" style="text-align: center;resize: none;color:#FF1177;font-size: 20px;border-radius: calc(5px);background-color: #212121"></textarea>

        </td>
    </tr>

    <tr>
        <td>	<span style="color: white;float: left;font-size: 20px;">邮箱</span>&nbsp;
            <textarea  cols="20" rows="1" id="email" style="text-align: center;font-size: 20px;resize: none;color:#FF1177;border-radius: calc(5px);background-color: #212121"></textarea>
        </td>
    </tr>

    <tr>
        <td>
            <span style="font-size: 20px;color: white;float: left">密码</span>&nbsp;
            <textarea   cols="20" rows="1" id="password"  style="text-align: center;font-size: 20px;resize: none;color:#FF1177;border-radius: calc(5px);background-color: #212121"></textarea>
        </td>
    </tr>

    <tr>
        <td><div style="text-align: center;">
            <button class="ps_btn" style="font-size: 30px;" onclick="updateUser()">保存	</button>
        </div>
        </td>
    </tr>
</table>
<div id="bright_container" style="text-align: center;margin-top: 20px;">
    <p style="display: inline;"><a style="cursor:no-drop; font-size: 25px;color: #FF1177;font-family: '微软雅黑';" href="#">
        个人设置<br>
        <span style="font-size: 25px;font-family: 'iceland';color: #FF1177;" >Personal Setting</span>
    </a></p>
    <p style="display: inline;"><a style="font-size: 25px;font-family: 'iceland';color: #FF1177;" href="#">
        Quit<br>
        <span style="font-size: 25px;font-family: '微软雅黑';" >退出团队</span>
    </a></p>
</div>
</body>
</body>
</html>
