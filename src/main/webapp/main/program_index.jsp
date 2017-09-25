<%--
  Created by IntelliJ IDEA.
  User: WU
  Date: 2017/9/25
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <title>xxxx的项目</title>
    <link rel="stylesheet" href="../resources/css/program_index_css.css" />
    <link rel="stylesheet" href="../resources/css/program_index_icono.min.css" />
    <link rel="stylesheet" href="../resources/css/program_index_style.css" />
    <link rel="stylesheet" type="text/css" href="../resources/js/jquery-easyui-1.4.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../resources/js/jquery-easyui-1.4.5/themes/icon.css">
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/jquery.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>

    <script src="demo/highlight.min.js"></script>

    <script src="../resources/program_index_dist/js/checkbix.min.js"></script>

    <link rel="shortcut icon" href="../resources/js/jquery-easyui-1.4.5/demo/favicon.png">

    <link rel="apple-touch-icon image_src" href="demo/favicon.png">

    <link rel="author" href="humans.txt">

    <link rel="stylesheet" href="demo/highlight-9.5.0.min.css">

    <link rel="stylesheet" href="../resources/program_index_dist/css/checkbix.min.css">

    <link rel="stylesheet" href="demo/demo.css">

    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">

    <link rel="stylesheet" type="text/css" href="../resources/css/program_index_checked.min.css">

    <script>
        Checkbix.init();
    </script>

    <style type="text/css">
        .pd50 {
            padding: 50px 0;
        }
        .mt50 {
            margin-top: 50px;
        }
        .t-center {
            text-align: center;
        }
    </style>

    <script type="text/javascript">
        $(document).ready(function() {
            $(".icono-heart").click(function() {
                $(".pb").slideUp()
                $(".all").click(function() {
                    $(".pb").slideDown()
                })
            })
            $("#star1").click(function() {
                window.location.href = "http://127.0.0.1:8020/power-program-setting/index.html"
            })

            $("#program_newprogram").hide()

            $("#program_innewprogram").click(function(){
                $("#program_index").hide()
                $("#program_newprogram").fadeIn()
            })

            $(".program_backindex").click(function(){
                $("#program_index").fadeIn()
                $("#program_newprogram").hide()
            })
        })
    </script>
</head>

<body style="background-color: #212121;">

<!--新建项目-->
<div id="program_newprogram" style="margin: 30px;">
    <a class="program_backindex" href="#" style="font-size: 30px;color: pink;text-decoration: none;">卡布奇诺的项目</a>
    <a  style="font-size: 30px;color: white;text-decoration: none;">> 创建新项目</a>
    <br>
    <br>
    <textarea placeholder="项目名称" style="resize: none;font-size: 20px;font-family: '微软雅黑';color: pink;background-color: #212121;border-radius:calc(5px);" cols="40" rows="1"></textarea>
    <br>
    <textarea placeholder="简单描述项目，便于其他人理解（选填）" style="resize: none;font-size: 15px;font-family: '微软雅黑';color: pink;background-color: #212121;border-radius:calc(5px);" cols="50" rows="5"></textarea>

    <h2 style="color: white;">项目类型</h2>
    <label style="color: white;font-size: 20px;">
        <input type="radio" name="x" class="checked-boom"  /> 标准项目（更好地组织、细分和管理任务，适用于一般项目管理）</label>
    </br>
    <label style="color: white;font-size: 20px;">
        <input type="radio" name="x" class="checked-boom" /> 看板项目（擅长处理流程化任务，适用于产品研发、用户支持等场景）</label>
    </br></br>

    <h2 style="color: white;">项目公开性</h2>
    <label style="color: white;font-size: 20px;">
        <input type="radio" name="x" class="checked-boom"  /> 私有项目（仅项目成员可以查看和编辑该项目）</label>
    </br>
    <label style="color: white;font-size: 20px;">
        <input type="radio" name="x" class="checked-boom" /> 公开项目（任何人都可以通过链接查看该项目，仅项目成员可以编辑该项目）</label>
    </br></br>

    <h2 style="color: white;">选择项目成员</h2>
    <p style="color: white;font-size: 20px;">管理员可以邀请和移除项目成员，只有被邀请的团队成员才能访问该项目的信息。点击这里查看<a href="#">如何设置成员权限。</a></p>

    <input id="mycheckboxk1" type="checkbox" class="checkbix" data-shape="circled" data-text="">
    <span style="color: pink;margin-right: 30px;">BF</span>
    <input id="mycheckboxk2" type="checkbox" class="checkbix" data-shape="circled" data-text="">
    <span style="color: pink;margin-right: 30px;">YG</span>
    <input id="mycheckboxk3" type="checkbox" class="checkbix" data-shape="circled" data-text="">
    <span style="color: pink;">JH</span>

    <br><br>
    <button class="programe_btn program_backindex">创建项目</button>
    <button class="programe_btn program_backindex">取消</button>

</div>

<!-- 项目页面核心内容 -->
<div id="program_index" style="margin: 30px;">
    <div id="项目第一行">
        <button class="programe_btn all" href="#" style="margin-top: 10px;border: none;font-size: 30px;">所有项目</button>
        <button id="program_innewprogram"  class="programe_btn" href="#" style="float: right; margin-top: 10px;margin-right: 10px	;">新建项目</button>
    </div>

    <div id="项目内容" style=" height: 300px;width: 1100px; margin-top: 20px;">
        <button href="#" class="programe_btn" style="font-size: 20px;" id="star1">星标项目A</button>
        <button href="#" class="programe_btn" style="font-size: 20px;margin-left: 10px;">星标项目B</button>
        <br>
        <button href="#" class="programe_btn" style="font-size: 20px;margin-top: 10px;">星标项目C</button>
        <br>
        <br>
        <button href="#" class="programe_btn pb" style="font-size: 20px;">其余项目D</a>
            <button href="#" class="programe_btn pb" style="font-size: 20px; margin-left: 10px;">其余项目E</button>
    </div>

    <!--<div style="margin-top: 10px;">
        <button href="#" style="margin-left: 10px;" class="programe_btn">管理项目模块</button>
    </div>-->
</div>
</body>

</html>
