<%--
  Created by IntelliJ IDEA.
  User: WU
  Date: 2017/9/25
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>团队-Power</title>
    <link rel="stylesheet" href="../resources/css/mian_css.css"/>
    <link rel="stylesheet" href="../resources/css/main_icono.min.css"/>
    <link rel="stylesheet" href="../resources/css/main_style.css"/>
    <link rel="stylesheet" type="text/css" href="../resources/js/jquery-easyui-1.4.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../resources/js/jquery-easyui-1.4.5/themes/icon.css">
    <link rel="stylesheet" href="../resources/allround_btn_css/style.css">
    <script src="../resources/allround_btn_js/jquery-1.8.3.min.js"></script>
    <script src="../resources/allround_btn_js/script.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/jquery.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $("#ss").hide();
            $(".icono-search").click(function () {
                $("#ss").fadeToggle()
            })

            $("#通知框").hide()
            $(".icon-ok").tooltip()
            $(".icon-more").tooltip()
            $(".icono-comment").click(function () {
                $("#通知框").slideToggle()
                $("#manmenu").hide()
            })
            $("#manmenu").hide()
            $(".icono-gear").click(function () {

                $("#manmenu").fadeToggle()
                $("#通知框").hide()
            })
            $(".icon-filter").tooltip()

            $("#inpersonalsetting").click(function () {
                $("#manmenu").hide()
            })

        })

        /*$("#manmenu1").hover(function(){
         $("#manmenu1").css("color","darkgray")
         $("#manmenu2").css("color","white")
         $("#manmenu3").css("color","white")
         $("#manmenu4").css("color","white")
         })

         $("#manmenu2").hover(function(){
         $("#manmenu1").css("color","white")
         $("#manmenu2").css("color","darkgray")
         $("#manmenu3").css("color","white")
         $("#manmenu4").css("color","white")
         })

         $("#manmenu3").hover(function(){
         $("#manmenu1").css("color","white")
         $("#manmenu2").css("color","white")
         $("#manmenu3").css("color","darkgray")
         $("#manmenu4").css("color","white")
         })

         $("#manmenu4").hover(function(){
         $("#manmenu1").css("color","white")
         $("#manmenu2").css("color","white")
         $("#manmenu3").css("color","white")
         $("#manmenu4").css("color","darkgray")
         })*/

    </script>

    <%--页面加载时遍历团队--%>
    <script type="text/javascript">
        $(document).ready(function () {
            $.ajax({
                type: "POST",
                url: "/user/queryTeam",
                dataType: "json",
                success: function (result) {
                    $.each(result.data, function (n, v) {
                        var op = "<option value=" + v.tId + ">" + v.tName + "</option>"
                        $("#queryTeam").append(op);
                    })

                },
                error: function () {
                    alert("遍历团队错误");
                }
            })

            // 切换团队
            $("#queryTeam").change(function () {
                $.ajax({
                    type: "POST",
                    url: "/user/changeTeam",
                    dataType: "json",
                    data: {
                        tId: $("#queryTeam").val(),
                    },
                    success: function (result) {
                    },
                    error: function () {
                        alert("变换团队失败");
                    }
                })
            })
            //  团队变化时遍历项目
            $("#queryTeam").change(function () {

                $.ajax({
                    type: "POST",
                    url: "/team/ProjectByTid",
                    dataType: "json",
                    success: function (result) {
                        document.getElementById("program_index").src = "program_index.jsp";
//                        document.getElementById('program_index').contentWindow.location.reload(true);
                    },
                    error: function () {
                        alert("遍历项目失败———团队变换时");
                    }
                })
            })

        })
    </script>
    <%--跳转回项目--%>
    <script type="text/javascript">
        function goproject() {
            $.ajax({
                type: "Post",
                url: "/team/ProjectByTid",
                dataType: "json",
                success: function (result) {
                    document.getElementById("program_index").src = "program_index.jsp";
                },
                error: function () {
                    alert("跳转回项目失败了");
                }
            })
        }
    </script>

    <%--跳转到团队时进行判断--%>
    <script type="text/javascript">
        function goteam() {
            $.ajax({
                type: "Post",
                url: "/userandteam/judgeUser",
                dataType: "json",
                data: {
                    tId: $('#queryTeam').val(),
                },
                success: function (result) {
                    if (result.errcode) {
                        if (result.data.type == 1) {
                            document.getElementById("program_index").src = "../team/teamformanger.jsp?tId=" + result.data.tId + "";
                        }
                        if (result.data.type == 0) {
                            document.getElementById("program_index").src = "../team/teamfornumber.jsp?tId=" + result.data.tId + "";
                        }
                    }
                },
                error: function () {
                    alert("跳转到团队失败了");
                }
            })
        }

        function godynamic() {
            $.ajax({
                type: "Post",
                url: "/dynamic/DynamicList",
                dataType: "json",
                data: {
                    tId: $("#queryTeam").val(),
                },
                success: function (result) {
                    if (result.errcode == 1) {
                        document.getElementById("program_index").src = "../dynamic/dynamic.jsp?tId='" + $('#queryTeam').val() + "'";
                    }
                    if (result.errcode == 0) {
                        alert("生成动态列表失败");
                    }
                },
                error: function () {
                    alert("生成动态列表失败11111");
                }
            })
        }

        function goweekly() {
            document.getElementById("program_index").src = "../weekly/weekly.jsp";
        }

        function gopersonalsetting() {
            document.getElementById("program_index").src = "../personal/personal-setting.jsp";
        }
        function gopersonal() {
            document.getElementById("program_index").src = "../personal/personal.jsp";
        }
    </script>

    <style>
        iframe {
            position: absolute;
            height: 1500px;
            width: 1320px;
            margin-top: 70px;
            margin-left: 60px;
            border: solid 1px white;

        }
    </style>
</head>

<body style="background-color:#212121;">

<iframe id="program_index" src="http://localhost:8080/main/program_index.jsp"
        frameborder="0" scrolling="no"></iframe>


<div style="margin-left: 100px;margin-top: 30px;">


    <%--<div class="back" style="z-index: 1000;">--%>
    <%--<div class="menu-back">--%>
    <%--<select id="queryTeam" class="nav-links">--%>
    <%--</select>--%>
    <%--</div>--%>
    <%--</div>--%>

    <div style="margin-left: 40px;display: inline-block">
        <select id="queryTeam"
                style="background-color: #212121;color: grey;width: 120px;height: 50px;font-size: 30px;text-align: center;font-weight: bold;border-color: white;padding-left: 15px">
        </select>
    </div>

    <%--最上面的菜单栏的五个菜单--%>
    <div style="margin-left: 40px;display: inline-block">
        <div class="link mission-link" style="margin:10px;cursor: pointer;display: inline-block">
            <a class="button" data-title="" style="font-size: 30px;color: pink" onclick="goproject()">
                <span class="line line-top"></span>
                <span class="line line-right"></span>
                <span class="line line-bottom"></span>
                <span class="line line-left"></span>
                项目
            </a>
        </div>

        <div class="link mission-link" style="margin:10px;cursor: pointer;display: inline-block">
            <a class="button" data-title="" style="color: #ffdd4d;font-size: 30px;" onclick=godynamic()>
                <span class="line line-top"></span>
                <span class="line line-right"></span>
                <span class="line line-bottom"></span>
                <span class="line line-left"></span>
                动态
            </a>
        </div>

        <div class="link mission-link" style="margin:10px;cursor: pointer;display: inline-block">
            <a class="button" data-title="" style="font-size: 30px;color: #0ABD6A;" onclick=goweekly()>
                <span class="line line-top"></span>
                <span class="line line-right"></span>
                <span class="line line-bottom"></span>
                <span class="line line-left"></span>
                周报
            </a>
        </div>

        <div class="link mission-link" style="margin:10px;cursor: pointer;display: inline-block">
            <a class="button" data-title="" style="font-size: 30px;color:slateblue;" onclick=goteam()>
                <span class="line line-top"></span>
                <span class="line line-right"></span>
                <span class="line line-bottom"></span>
                <span class="line line-left"></span>
                团队
            </a>
        </div>

        <div class="link mission-link" style="margin:10px;cursor: pointer;display: inline-block">
            <a class="button" data-title="" style="font-size: 30px;color:deepskyblue;" onclick="gopersonal()">
                <span class="line line-top"></span>
                <span class="line line-right"></span>
                <span class="line line-bottom"></span>
                <span class="line line-left"></span>
                我自己
            </a>
        </div>


    </div>


    <%--<span style="margin-left: 40px;">--%>
    <%--<a href="#" style="color: grey;margin-left: 40px;font-size: 25px;">项目</a>--%>
    <%--<a href="#" style="color: grey;margin-left: 40px;font-size: 25px;" onclick=godynamic()>动态</a>--%>
    <%--<a href="#" style="color: grey;margin-left: 40px;font-size: 25px;" onclick=goweekly()>周报</a>--%>
    <%--<a href="#" style="color: grey;margin-left: 40px;font-size: 25px;" onclick="goteam()>团队</a>--%>
    <%--<a href="#" style="color: grey;margin-left: 40px;font-size: 25px;">我自己</a>--%>
    <%--</span>--%>

    <div style="display: inline-block;">
        <span style="margin-left: 0px;"><i class="icono-comment" style="cursor: pointer;margin-left: 40px;"></i></span>
        <!--<button class="icon-man" style="height: 20px;width: 20px;background-color: white;margin-left: 23px;" title="个人"></button>-->
        <span><i class="icono-gear spin" style="cursor: pointer;margin-left: 10px;"></i></span>
        <span><i class="icono-search" style="cursor: pointer;margin-left: 10px;"></i></span>
    </div>

    <!--搜索框-->
    <span id="ss" style="">
		<textarea
                style="position: absolute;margin-top: 30px;margin-left: 5px; resize: none;height: 20px;border-radius: calc(5px);background-color: #212121;color: darkgray;"
                placeholder="请输入搜索内容"></textarea>
		<button class="main_btn" style="font-family: '微软雅黑';position: absolute;margin-top: 30px;margin-left: 170px;"><b>搜索</b></button>
		</span>
    </span>
    </span>

    <!-- 通知框 -->
    <div id="通知框" style=" position:absolute;color: white;width: 400px;margin-left: 750px;z-index: 5000;
			margin-top: 20px;border-color: white;border-style:solid ;
			border-width: 1px;background-color:black;">
        <div id="通知框第一行">
            <span style="float: left;font-family: '微软雅黑';font-size: 25px;margin: 10px;">通知</span>
            <span style="float: right;margin: 10px;">
					<span><i class="icono-reset spin" style="cursor: pointer;" title="全部标记为已读"></i></span>
					<span><i class="icono-signIn" style="cursor: pointer;" title="设置通知发送方式"></i></span>

                <!--<button style="height: 20px;width: 20px;background-color: white;" class="icon-ok" title="全部标记为已读"></button>-->
                <!--<button style="height: 20px;width: 20px;background-color: white;" class="icon-more"  ></button>-->
				</span>
            </br>
            <div class="menu-sep" style="width: 400px;margin-left: -1px;margin-top: 30px;"></div>

        </div>
        <div id="通知框核心内容">
            <p style="color: white;text-align: center;">- 没有新通知 -</p>
            <div class="menu-sep" style="width: 400px;margin-left: -1px;"></div>
            <p style="text-align: center;"><a href="#" style="color: white;">查看全部</a></p>
        </div>

    </div>


    <!--头像下拉菜单-->
    <div id="manmenu" style="margin-left: 970px;margin-top: 20px; position:absolute;padding: 10px;
				background-color: black;border: solid;border-color: white;border-width: 0.3px;">
        <a href="#" id="inpersonalsetting" style="color: white;margin: 10px;"
           onclick="gopersonalsetting()">个人设置</a>><br>
        <%--<a href="#" id="manmenu2" style="color: white;margin: 10px;">通知设置</a><br>--%>
        <%--<a href="#" id="manmenu3" style="color: white;margin: 10px;">我的关注</a><br>--%>
        <div class="menu-sep" style="width: 70px;margin-left: 00px;margin: 10px;"></div>
        <a href="#" id="manmenu4"
           style="color: white;margin-left: 15px;margin: 10px;text-align: center;margin-bottom: 10px;">退出</a>
    </div>


    </p>
</div>
</div>
</body>
</html>

