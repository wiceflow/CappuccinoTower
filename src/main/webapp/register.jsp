<%--
  Created by IntelliJ IDEA.
  User: WU
  Date: 2017/9/8
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="../resources/css/register.css"/>
    <script type="text/javascript" src="../resources/js/jquery-3.1.1.js"></script>
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
            });
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
    <script type="text/javascript">
        $(document).ready(function (e) {
            $("#td2").blur(function(e) {
                if ($("#td2").val() != "请输入你的名字") {

                    $.ajax({
                        type: "Post",
                        url: "/user/login",
                        dataType: "json",
                        data: {
                            uName: $("#td2").val(),
                            uPassword: 000000000000,
                            loginType: 1,
                        },
                        success: function (date) {
                            if (date.errcode == 0) {
                                $("#td21").html("该用户名可以使用");
                                $("#td21").css({"color": "#F00"});
                            }
                            if (date.errcode == 1) {
                                $("#td21").html("该用户名已经存在");
                                $("#td21").css({"color": "#F00"});
                            }
                        },
                        error: function () {
                            alert("错误信息")
                        }
                    })
                }//if的结束
            })

            //验证邮箱是否合法
            $("#td3").blur(function () {
                if($("#td3").val()!="请输入有效邮箱，例如：510024166@qq.com"){
                    var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
                    if(!reg.test($("#td3").val())){
                        $("#td31").html("邮箱格式不正确");
                        $("#td31").css({"color": "#F00"});
                    }
                    else{
                        $.ajax({
                            type:"Post",
                            url:"/user/login",
                            dataType:"json",
                            data:{
                                uEmail:$("#td3").val(),
                                uPassword: 0000000000,
                                loginType: 2,
                            },
                            success:function (date) {
                                if(date.errcode==0){
                                    $("#td31").html("邮箱可以使用");
                                    $("#td31").css({"color": "#F00"});
                                }
                                if(date.errcode==1){
                                    $("#td31").html("该邮箱已被注册");
                                    $("#td31").css({"color": "#F00"});
                                }
                            },
                            error:function () {
                                alert("错误信息")
                            }
                        })
                    }

                }
            })

            //验证密码是否符合要求
            $("#td4").blur(function () {
                var password=$("#td4").val();
                if(password.length<6){
                    $("#td41").html("密码长度要大于6");
                    $("#td41").css({"color": "#F00"});
                }else{
                    $("#td41").html("密码可以使用");
                    $("#td41").css({"color": "#F00"});
                }
            })


        })
    </script>
</head>
<body style="background-color:#212121;text-align: center;">
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
                           style="height: 30px;width: 300px;background-color:#212121;font-size:15px;border-radius: 5px;color: pink;font-weight:bolder "
                    >
                </td>
            </tr>

            <tr>
                <td>
                    <input name="name" class="easyui-textbox"
                           data-options="required:true"
                           id="td2"
                           value="请输入你的名字"
                           style="border-radius: 5px;height: 30px;width: 300px;font-size:15px;color:pink;background-color:#212121;font-weight: bold;">
                    <span id="td21" style="position: absolute"></span>
                </td>

            </tr>

            <tr>
                <td>
                    <input name="email" class="easyui-textbox"
                           data-options="required:true,validType:'email'"
                           id="td3"
                           value="请输入有效邮箱，例：510024166@qq.com"
                           style="border-radius: 5px;height: 30px;width: 300px;font-size:15px;color:pink;background-color:#212121;font-weight: bold;">
                    <span id="td31" style="position: absolute"></span>
                </td>

            </tr>

            <tr>
                <td>
                    <input name="password" class="easyui-textbox"
                           data-options="required:true"
                           id="td4"
                           value="请设置密码(至少包含6个字符)"
                           style="border-radius: 5px;height: 30px;width: 300px;font-size:15px;color: pink;background-color:#212121;font-weight: bold;">
                    <span id="td41" style="position: absolute"></span>
                </td>

            </tr>


        </table>
    </form>

    <div style="text-align: center;margin-bottom:20px;margin-top: -70px; ">
        <a href="#" class="button" style="color: black;margin-bottom: 20px;" onclick="register2()"><b>完成注册</b></a>
    </div>
    <p style="color: grey;text-align: center;margin-top: 20px;" id="a3">
        <a  id="a2" href="login.jsp" style="font-size:20px;color: grey;">直接登录→</a>
        </br>
        <span style="font-size: 20px" id="a1">已有power账户？</span></p>

</div>
</body>
</html>
