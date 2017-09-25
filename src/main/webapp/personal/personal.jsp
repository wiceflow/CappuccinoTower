<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2017/9/22
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="utf-8" />
    <title>我自己</title>
    <link rel="stylesheet" href="../resources/css/css.css" />
    <link rel="stylesheet" href="../resources/css/inserthtml.com.radios.min.css" />
    <link rel="stylesheet" type="text/css" href="../resources/js/jquery-easyui-1.4.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../resources/js/jquery-easyui-1.4.5/themes/icon.css">
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/jquery.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">
        $(document).ready(function() {

            $("#writereport_hide").hide()

            $("#inreport_setting").click(function() {
                $("#writereport_hide").slideToggle()
            })
            $("#writereport_save").click(function() {
                $("#writereport_hide").slideUp()
            })

            $("#personal_writereport").hide()
            $("#personal_task1").click(function() {
                $("#personal_task_span1").fadeOut();
            })
            $("#personal_task2").click(function() {
                $("#personal_task_span2").fadeOut();
            })
            $("#personal_task3").click(function() {
                $("#personal_task_span3").fadeOut();
            })
            $("#personal_task4").click(function() {
                $("#personal_task_span4").fadeOut();
            })
            $("#personal_follow_collect1").hide();
            $("#personal_follow_collect2").hide();
            $("#personal_follow_collect3").hide();
            $("#personal_follow_collect4").hide();
            $("#personal_follow_button1").hover(function() {
                $("#personal_follow_collect1").toggle();
            })
            $("#personal_follow_button2").hover(function() {
                $("#personal_follow_collect2").toggle();
            })
            $("#personal_follow_button3").hover(function() {
                $("#personal_follow_collect3").toggle();
            })
            $("#personal_follow_button4").hover(function() {
                $("#personal_follow_collect4").toggle();
            })
            $("#personal_follow").hide()
            $("#personal_schedule").hide()
            $("#personal_mail").hide()
            $("#personal_a1").css("font-size", "25px")
            $("#personal_a1").css("color", "deepskyblue")
            /*点击任务*/
            $("#personal_a1").hover(function() {
                $("#personal_task").fadeIn( )
                $("#personal_follow").hide()
                $("#personal_schedule").hide()
                $("#personal_writereport").hide()
                $("#personal_mail").hide()
                $("#personal_a1").css("font-size", "25px")
                $("#personal_a1").css("color", "deepskyblue")
                $("#personal_a2").css("font-size", "20px")
                $("#personal_a2").css("color", "white")
                $("#personal_a3").css("font-size", "20px")
                $("#personal_a3").css("color", "white")
                $("#personal_a4").css("font-size", "20px")
                $("#personal_a4").css("color", "white")
                $("#personal_a5").css("font-size", "20px")
                $("#personal_a5").css("color", "white")
            })
            /*点击关注*/
            $("#personal_a2").hover(function() {
                $("#personal_task").hide()
                $("#personal_follow").fadeIn( )
                $("#personal_schedule").hide()
                $("#personal_writereport").hide()
                $("#personal_mail").hide()
                $("#personal_a1").css("font-size", "20px")
                $("#personal_a1").css("color", "white")
                $("#personal_a2").css("font-size", "25px")
                $("#personal_a2").css("color", "deepskyblue")
                $("#personal_a3").css("font-size", "20px")
                $("#personal_a3").css("color", "white")
                $("#personal_a4").css("font-size", "20px")
                $("#personal_a4").css("color", "white")
                $("#personal_a5").css("font-size", "20px")
                $("#personal_a5").css("color", "white")
            })
            /*点击日程*/
            $("#personal_a3").hover(function() {
                $("#personal_task").hide()
                $("#personal_follow").hide()
                $("#personal_schedule").fadeIn( )
                $("#personal_writereport").hide()
                $("#personal_mail").hide()
                $("#personal_a1").css("font-size", "20px")
                $("#personal_a1").css("color", "white")
                $("#personal_a2").css("font-size", "20px")
                $("#personal_a2").css("color", "white")
                $("#personal_a3").css("font-size", "25px")
                $("#personal_a3").css("color", "deepskyblue")
                $("#personal_a4").css("font-size", "20px")
                $("#personal_a4").css("color", "white")
                $("#personal_a5").css("font-size", "20px")
                $("#personal_a5").css("color", "white")
            })
            /*点击周报*/
            $("#personal_a4").hover(function() {
                $("#personal_task").hide()
                $("#personal_follow").hide()
                $("#personal_schedule").hide()
                $("#personal_writereport").fadeIn( )
                $("#personal_mail").hide()
                $("#personal_a1").css("font-size", "20px")
                $("#personal_a1").css("color", "white")
                $("#personal_a2").css("font-size", "20px")
                $("#personal_a2").css("color", "white")
                $("#personal_a3").css("font-size", "20px")
                $("#personal_a3").css("color", "white")
                $("#personal_a4").css("font-size", "25px")
                $("#personal_a4").css("color", "deepskyblue")
                $("#personal_a5").css("font-size", "20px")
                $("#personal_a5").css("color", "white")
            })
            /*点击邮箱*/
            $("#personal_a5").hover(function() {
                $("#personal_task").hide()
                $("#personal_follow").hide()
                $("#personal_schedule").hide()
                $("#personal_writereport").hide()
                $("#personal_mail").fadeIn( )
                $("#personal_a1").css("font-size", "20px")
                $("#personal_a1").css("color", "white")
                $("#personal_a2").css("font-size", "20px")
                $("#personal_a2").css("color", "white")
                $("#personal_a3").css("font-size", "20px")
                $("#personal_a3").css("color", "white")
                $("#personal_a4").css("font-size", "20px")
                $("#personal_a4").css("color", "white")
                $("#personal_a5").css("font-size", "25px")
                $("#personal_a5").css("color", "deepskyblue")
            });
        });
    </script>
</head>

<body style="background-color: #212121">
<div style="margin: 30px;">
    <br>
    <br>
    <br>
    <br>
    <div class="menu-sep" style="margin-left: 0px;"></div>
    <a id="personal_a1" style="margin-right: 30px;cursor: pointer;font-size: 20px;color: white;">任务</a>
    <a id="personal_a2" style="margin-right: 30px;cursor: pointer;font-size: 20px;color: white;">关注</a>
    <a id="personal_a3" style="margin-right: 30px;cursor: pointer;font-size: 20px;color: white;">日程</a>
    <a id="personal_a4" style="margin-right: 30px;cursor: pointer;font-size: 20px;color: white;">周报</a>
    <a id="personal_a5" style="cursor: pointer;font-size: 20px;color: white;">邮件</a>
    <br>
    <div class="menu-sep" style="margin-left: 0px;"></div>
    <p style="text-align: center;font-size: 30px;font-weight: bold;">

        <!--邮件-->
        <div id="personal_mail">
    <p style="color: deepskyblue;">510024166-12186151@mailer.tower.im是你的私人收件箱地址。你可以从邮箱、Evernote、微博客户端、百度网盘等应用，转发内容到这个地址，把重要的内容收集到 Tower，或者移动到项目里，跟团队分享和协作。</p>
    <button class="personal_btn" href="#">查看详细使用帮助</button>
</div>
<!--邮件-->

<!--日程-->
<div id="personal_schedule">

    <button class="personal_btn" style="border: none;font-weight: bold;font-size: 30px;">
        <</button>
    <p style="color: deepskyblue; text-align: center;font-size: large;font-size: 30px;font-weight: 600;margin-top: -15px;display: inline;">2017 九月</p>
    <button class="personal_btn" style="border: none;font-weight: bold;font-size: 30px;">></button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button class="personal_btn" style="height: 30px;width: 80px;">创建日程</button>
</div>
<!--日程-->

<!--关注-->
<div id="personal_follow">

</div>
<!--关注-->

<!--周报-->
<div id="personal_writereport">
    <button class="personal_btn" style="border:none;font-weight:bold;font-size:30px;">
        <</button>
    <p style="color: deepskyblue; text-align: center;font-size:30px;font-weight: 600;margin-top: -15px;display: inline;">2017 九月</p>
    <button class="personal_btn" style="font-size:30px;font-weight:bold;border:none;">></button>
    <a id="inreport_setting" href="#" style="color: deepskyblue;font-weight: bold;">谁可以看到我的周报▼</a>
    <br>
    <span id="writereport_hide">
								<p style="color: grey;">从团队成员中选择谁可以看到你的周报</p>
								<input type="checkbox" id="checkbox-2-1"  />
								<label for="checkbox-2-1" style="height: 10px;width: 50px;text-align: left;font-weight: bold;font-size: 18px;">BF</label>
							<input type="checkbox" id="checkbox-2-2"  />
								<label for="checkbox-2-2" style="height: 10px;width: 50px;text-align: left;font-weight: bold;font-size: 18px;">YG</label>
							<input type="checkbox" id="checkbox-2-3"  />
								<label for="checkbox-2-3" style="height: 10px;width: 50px;text-align: left;font-weight: bold;font-size: 18px;">JX</label>

				<br>
				<br>
				<button id="writereport_save" class="personal_btn" style="margin-bottom: 10px;">保存查看者</button>
				</span>
    <br>
    <div class="menu-sep" style="margin-left: 0px;margin-bottom: 20px;"></div>

    <div class="container">
        <a style="color: white;font-weight: bold;font-size: 25px;">本周完成的任务</a>

    </div>
    <br>
    <div class="container" style="margin-top: 30px;">
        <a style="margin-top: 30px;color: white;font-weight: bold;font-size: 25px;">本周周报</a>
    </div>

    <p style="color: lightgrey;font-weight: bold;">本周工作成果总结，说说你对自己点赞或失望的地方。</p>
    <textarea placeholder="我这周表现很棒" style="color: deepskyblue; background-color: #212121; resize:none;border-radius: calc(5px); height:25px;width: 400px;font-size: 15px;"></textarea>
    <p style="color:lightgrey;font-weight: bold;	">有遇到挑战或者困难么？希望团队怎么帮助你？</p>
    <textarea placeholder="没有困难" style="color: deepskyblue; background-color: #212121; resize:none;border-radius: calc(5px); height:25px;width: 400px;font-size: 15px;"></textarea>
    <p style="color: lightgrey;	font-weight: bold;">下周的工作目标是什么？只许说一个。</p>
    <textarea placeholder="晋级总经理" style="color: deepskyblue; background-color: #212121; resize:none;border-radius: calc(5px); height:25px;width: 400px;font-size: 15px;"></textarea>
    <p style="color: lightgrey;font-weight: bold;">你觉得采取哪些措施，会对你提升工作效率有帮助？</p>
    <textarea placeholder="加班" style="color: deepskyblue; background-color: #212121; resize:none;border-radius: calc(5px); height:25px;width: 400px;font-size:15px;"></textarea>

    <br>
    <br>

    <button class="personal_btn">发布周报</button>
    <button class="personal_btn">取消</button>
    <div class="menu-sep" style="margin-left: 0px;margin-top: 20px;margin-bottom: 20px;"></div>
    <img src="img/fzl4.jpg" height="50px" />
    <textarea style="resize:none;border-radius: calc(5px);color: deepskyblue; background-color: #212121; height:25px;width: 400px;" placeholder="点击此处发表评论"></textarea>
    <br>
    <button class="personal_btn" style="margin-top: 20px;">发布评论</button>
    <button class="personal_btn">取消</button>
</div>
<!--周报-->

<!--任务-->
<div id="personal_task" >
    <div class="back">
        <a href="#" class="btn-back">
            <div style="background-color: darkgrey">
            </div>
            <span style="font-size: 15px;">所有项目(All Projects)</span>
        </a>
        <div class="menu-back">
            <ul class="nav-links">
                <li><a href="#">项目1</a></li>
                <li><a href="#">项目2</a></li>
                <li class="active"><a href="#">项目X</a></li>
            </ul>
            <!--<ul class="nav-links">
              <li><a href="#">My Account</a></li>
              <li><a href="#">Privacy Policy</a></li>
              <li><a href="#">Support / Help</a></li>
            </ul>-->
        </div>
    </div>
    <div class="container" style="height: 40px;">
        <h3  style="color: white;" >新任务</h3>
    </div>
    <p style="color: darkgrey;height: 40px;">当前没有新任务</p>

    <br>
    <div class="container" style="height: 40px;">
        <h3 style="color: white;">今天</h3>
    </div>
    <p style="color: darkgrey;">今日任务请放入这里</p>


    <br>
    <div class="container" style="height: 40px;">
        <h3 style="color: white;">接下来</h3>
    </div>
    <p style="color: darkgrey;">已确定的任务请放入这里</p>


    <br>
    <div class="container" style="height: 40px;">
        <h3 style="color: white;">以后</h3>
    </div>
    <p style="color: darkgrey;">待考虑的任务请放入这里</p>

    <br>
    <br>
    <button class="personal_btn" href="#">查看已完成的任务</button>
    <button class="personal_btn" href="#" style="margin-left: 30px;">查看添加的任务</button>
</div>
<!--任务-->

</div>
</body>

