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
    <meta charset="utf-8" />
    <title>团队-Power</title>
    <link rel="stylesheet" href="../resources/css/mian_css.css" />
    <link rel="stylesheet" href="../resources/css/main_icono.min.css" />
    <link rel="stylesheet" href="../resources/css/main_style.css" />
    <link rel="stylesheet" type="text/css" href="../resources/js/jquery-easyui-1.4.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../resources/js/jquery-easyui-1.4.5/themes/icon.css">
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/jquery.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">
        $(document).ready(function(){
            $("#ss").hide();
            $(".icono-search").click(function(){
                $("#ss").fadeToggle()
            })

            $("#通知框").hide()
            $(".icon-ok").tooltip()
            $(".icon-more").tooltip()
            $(".icono-comment").click(function(){
                $("#通知框").slideToggle()
                $("#manmenu").hide()
            })
            $("#manmenu").hide()
            $(".icono-gear").click(function(){

                $("#manmenu").fadeToggle()
                $("#通知框").hide()
            })
            $(".icon-filter").tooltip()

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
                type:"POST",
                url:"/user/queryTeam",
                dataType:"json",
                success : function (result) {
                    $.each(result.data,function (n,v) {
                        var op="<option value="+v.tId+">"+v.tName+"</option>"
                        $("#queryTeam").append(op);
                    })

                },
                error:function () {
                    alert("遍历团队错误");
                }
            })

            // 切换团队
            $("#queryTeam").change(function () {
                $.ajax({
                    type:"POST",
                    url:"/user/changeTeam",
                    dataType:"json",
                    data:{
                        tId:$("#queryTeam").val(),
                    },
                    success:function (result) {
                    },
                    error:function () {
                        alert("变换团队失败");
                    }
                })
            })
            //  团队变化时遍历项目
            $("#queryTeam").change(function () {

                $.ajax({
                    type:"POST",
                    url:"/team/ProjectByTid",
                    dataType:"json",
                    success:function (result) {
                        document.getElementById("program_index").src="program_index.jsp";
//                        document.getElementById('program_index').contentWindow.location.reload(true);
                    },
                    error:function () {
                        alert("遍历项目失败———团队变换时");
                    }
                })
            })

        })
    </script>
    <%--跳转到团队时进行判断--%>
    <script type="text/javascript">
        function goteam() {
            $.ajax({
                type:"Post",
                url:"/userandteam/judgeUser",
                dataType:"json",
                data:{
                    tId:$('#queryTeam').val(),
                },
                success:function (result) {
                    if(result.errcode){
                        if(result.data.type==1){
                            document.getElementById("program_index").src="../team/teamformanger.jsp?tId="+result.data.tId+"";
                        }
                        if(result.data.type==0){
                            document.getElementById("program_index").src="../team/teamfornumber.jsp?tId="+result.data.tId+"";
                        }
                    }
                },
                error:function () {
                    alert("跳转到团队失败了");
                }
            })
        }
    </script>

    <style>
        iframe{
            position: absolute;height:1500px;width: 1320px;
            margin-top: 70px;margin-left: 60px;

        }
    </style>
</head>

<body style="background-color:#212121;">

<iframe  id="program_index" src="http://localhost:8080/main/program_index.jsp"
         frameborder="0" scrolling="no"></iframe>


<div style="margin-left: 100px;margin-top: 30px;">


    <div class="back" style="z-index: 1000;">
        <div class="menu-back">
            <select id="queryTeam" class="nav-links">
            </select>
        </div>
    </div>


    <span style="margin-left: 40px;">
    		<a href="#" style="color: pink;margin-left: 40px;font-size: 25px;">项目</a>
    		<a href="#" style="color: #ffdd4d;margin-left: 40px;font-size: 25px;">动态</a>
    		<a href="#" style="color: #0abd6a;margin-left: 40px;font-size: 25px;">周报</a>
    		<a href="#" style="color: slateblue;margin-left: 40px;font-size: 25px;" onclick="goteam()">团队</a>
    		<a href="#" style="color: deepskyblue;margin-left: 40px;font-size: 25px;">我自己</a>
    		</span>


    <span style="margin-left: 30px;"><i class="icono-comment" style="cursor: pointer;margin-left: 400px;"></i></span>
    <!--<button class="icon-man" style="height: 20px;width: 20px;background-color: white;margin-left: 23px;" title="个人"></button>-->
    <span><i class="icono-gear spin" style="cursor: pointer;margin-left: 10px;"></i></span>
    <span><i class="icono-search" style="   cursor: pointer;margin-left: 10px;"></i></span>


    <!--搜索框-->
    <span id = "ss">
		<textarea style="position: absolute;margin-top: 3px;margin-left: 5px; resize: none;height: 20px;border-radius: calc(5px);background-color: #212121;color: darkgray;" placeholder="请输入搜索内容"></textarea>
		<button class="main_btn" style="font-family: '微软雅黑';position: absolute;margin-top: 3px;margin-left: 170px;"><b>搜索</b></button>
		</span>
    </span>
    </span>

    <!-- 通知框 -->
    <div id="通知框" style=" position:absolute;color: white;width: 400px;margin-left: 750px;z-index: 5000;
			margin-top: 20px;border-color: white;border-style:solid ;
			border-width: 1px;background-color:black;" >
        <div id="通知框第一行">
            <span style="float: left;font-family: '微软雅黑';font-size: 25px;margin: 10px;">通知</span>
            <span style="float: right;margin: 10px;">
					<span><i class="icono-reset spin" style="cursor: pointer;"title="全部标记为已读"></i></span>
					<span><i class="icono-signIn" style="cursor: pointer;" title="设置通知发送方式"></i></span>

                <!--<button style="height: 20px;width: 20px;background-color: white;" class="icon-ok" title="全部标记为已读"></button>-->
                <!--<button style="height: 20px;width: 20px;background-color: white;" class="icon-more"  ></button>-->
				</span>
            </br>
            <div class="menu-sep" style="width: 400px;margin-left: -1px;margin-top: 30px;"></div>

        </div>
        <div id="通知框核心内容" >
            <p style="color: white;text-align: center;">- 没有新通知 -</p>
            <div class="menu-sep" style="width: 400px;margin-left: -1px;"></div>
            <p style="text-align: center;"><a href="#" style="color: white;">查看全部</a></p>
        </div>

    </div>


    <!--头像下拉菜单-->
    <div id="manmenu" style="margin-left: 970px;margin-top: 20px; position:absolute;padding: 10px;
				background-color: black;border: solid;border-color: white;border-width: 0.3px;">
        <a href="#" id="manmenu1" style="color: white;margin: 10px;">个人设置</a><br>
        <a href="#" id="manmenu2" style="color: white;margin: 10px;">通知设置</a><br>
        <a href="#" id="manmenu3" style="color: white;margin: 10px;">我的关注</a><br>
        <div class="menu-sep" style="width: 70px;margin-left: 00px;margin: 10px;"></div>
        <a href="#" id="manmenu4" style="color: white;margin-left: 15px;margin: 10px;text-align: center;margin-bottom: 10px;">退出</a>
    </div>



    </p>
</div>
</div>
</body>
</html>

