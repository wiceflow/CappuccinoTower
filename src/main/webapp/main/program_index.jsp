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
    <%--页面开始遍历项目--%>
    <script type="text/javascript">
        $(document).ready(function () {
            $.ajax({
                type:"Post",
                url:"/team/ProjectByTid",
                dataType:"json",
                success:function (result) {
                    $.each(result.data,function (n,v) {
                        $("#projectContext").append("<a href='main_program.jsp?pId="+v.pId+"'" +
                            "class='programe_btn'" +
                            "style='font-size: 30px;'>"+v.pName+"</a><br>")
                    })
                },
                error:function () {
                    alert("遍历项目失败");
                }
            })
        })
    </script>
    
    <%--创建项目--%>
    <script type="text/javascript">
        function createproject() {
            
        }
    </script>
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
                $("#program_index").hide();
                $("#program_newprogram").fadeIn();

            })

            $(".program_backindex").click(function(){
                $("#program_index").fadeIn()
                $("#program_newprogram").hide()
            })
        })
    </script>



    <script type="text/javascript">
        <%--在搜索框中异步模糊查找组员的名称--%>
        $(function(){
            $("<ul id='autocomplete'></ul>").hide().insertAfter("#selectName");
            //不能在这里定义自定义的函数，否则无效！！
        });
        function selectByName() {
            $("#autocomplete").empty();
            var name=$("#selectName").val();
            //判断搜索框是否为空或者是空字符串
            if(name!=null&&name!=("")) {
                $.ajax({
                    type: "Post",
                    url: "/project/selectName",
                    dataType: "json",
                    data:{
                        uName:name,
                    },
                    success: function (result) {
                        var str="";
                        $.each(result.data,function (n,v) {
                            $("#autocomplete").show();
                            str = "<li style='color: white;font-size: 10px;'>"+v.uName+"</input><li>";
                            $("#autocomplete").append(str);
                            $("li").click(function(){
                                //当点击哪个列表时就把它的值load到输入框中
                                $("#selectName").val($(this).text());
                                $("#autocomplete").empty();
                            });
                            //鼠标移到当前元素和移出当前元素的背景色
                            $("li").hover(function(){
                                $(this).addClass("clor");
                            },function(){
                                $(this).removeClass("clor");
                            });
                        })
                    },
                    error: function () {
                        alert("失败");
                    }
                })
            }
        }

//        将查找到的并且选择的名字放到div中
        function sureName() {
            var uname=$("#selectName").val();
            $.ajax({
                type: "Post",
                url: "/project/selectName",
                dataType: "json",
                data: {
                    uName:uname,
                },
                success: function (result) {
                    $("#program_index").hide();
                    $("#program_newprogram").fadeIn();
                    if(result.errcode==1) {
                        $.each(result.data, function (n, v) {
                            $("#divp").append("<input type='checkbox' name='uId' value='"+v.uId+"'/>"+v.uName+"");
                        });
                    }else {
                        alert("未查找到该用户")
                    }
                },
                error:function () {
                    alert("选择名字失败");
                }
            })
        }
//        创建项目
        function createproject() {
            //对项目的公开性radio的取值进行处理
            var fromofispublic=document.getElementsByName("ispublic");
            var ispublic;
            for(var i=0;i<fromofispublic.length;i++){
                if(fromofispublic[i].checked)
                    ispublic=i;
            }
            //对项目中的组员选择进行操作
            var arr=[];
            $("input[type='checkbox']:checked").each(function () {
                arr.push(this.value);
            });
            $.ajax({
                type:"Post",
                url:"/project/putProject",
                dataType:"json",
                data:{
                    pName:$("#create_pName").val(),
                    pDescribe:$("#create_pDescribe").val(),
                    pSensitive:$("#create_pSensitive").val(),
                    ispublic:ispublic,
                    uId:arr,
                },
                success:function (result) {
                    window.location.reload();
                },
                error:function () {
                    alert("创建项目失败");
                }

            })
        }
    </script>
</head>

<body style="background-color: #212121;">

<!--新建项目-->
<div id="program_newprogram" style="margin: 30px;">
    <a class="program_backindex" href="#" style="font-size: 30px;color: pink;text-decoration: none;"></a>
    <a  style="font-size: 30px;color: white;text-decoration: none;">创建新项目</a>
    <br>
    <br>
    <input id="create_pName" type="text" name="pName" placeholder="项目名称" style="resize: none;font-size: 20px;font-family: '微软雅黑';color: pink;background-color: #212121;border-radius:calc(5px);" cols="40" rows="1"/>
    <br>
    <br>
    <input id="create_pDescribe" type="text" name="pDescribe" placeholder="简单描述项目，便于其他人理解（选填）" style="height: 100px;width: 400px;border-radius: calc(5px);resize: none;font-size: 15px;font-family: '微软雅黑';color: pink;background-color: #212121;border-radius:calc(5px);" cols="50" rows="5"/>
    <%--<h2 style="color: white;">是否屏蔽敏感词汇</h2>--%>
    <label style="color: white;font-size: 20px;">
        <input id="create_pSensitive" type="checkbox" name="pSensitive" value="1" class="checked-boom" />是否屏蔽敏感词汇</label>
    </br>
    <%--标准项目（更好地组织、细分和管理任务，适用于一般项目管理）--%>
    <%--<label style="color: white;font-size: 20px;">--%>
        <%--<input type="radio" name="x" class="checked-boom" /> 看板项目（擅长处理流程化任务，适用于产品研发、用户支持等场景）</label>--%>
    <%--</br></br>--%>

    <h2 style="color: white;">项目公开性</h2>
    <label style="color: white;font-size: 20px;">
        <input  type="radio" value="0" name="ispublic" checked="checked" class="checked-boom"  /> 私有项目（仅项目成员可以查看和编辑该项目）</label>
    </br>
    <label style="color: white;font-size: 20px;">
        <input  type="radio" value="1" name="ispublic" class="checked-boom" /> 公开项目（任何人都可以通过链接查看该项目，仅项目成员可以编辑该项目）</label>
    </br></br>

    <h2 style="color: white;">选择项目成员</h2>
    <p style="color: white;font-size: 20px;">管理员可以邀请和移除项目成员，只有被邀请的团队成员才能访问该项目的信息。点击这里查看<a href="#">如何设置成员权限。</a></p>
    <div id="yourmember">
        <span id="divp" style="color: white;font-size: 20px;">
             <input  type="checkbox" name="uId" value="${user.uId}" checked="checked">${user.uName}
        </span>
    </div>
    <%--<input id="mycheckboxk1" type="checkbox" class="checkbix" data-shape="circled" data-text="">--%>
    <%--<span style="color: pink;margin-right: 30px;">BF</span>--%>
    <%--<input id="mycheckboxk2" type="checkbox" class="checkbix" data-shape="circled" data-text="">--%>
    <%--<span style="color: pink;margin-right: 30px;">YG</span>--%>
    <%--<input id="mycheckboxk3" type="checkbox" class="checkbix" data-shape="circled" data-text="">--%>
    <%--<span style="color: pink;">JH</span>--%>
    <br><br>
    <div>
        <div style="color: white;font-size: 20px;">搜索组员</div>
        <div><input type="text" name="uName" id="selectName" onkeyup="selectByName()" style="resize: none;font-size: 20px;font-family: '微软雅黑';color: pink;background-color: #212121;border-radius:calc(5px);" cols="40" rows="1"><button id="selectButton" class="programe_btn program_backindex" onclick="sureName()">添加</button>
        </div>


    </div>
    <br>
    <br>
    <button class="programe_btn program_backindex" onclick="createproject()">创建项目</button>
    <button class="programe_btn program_backindex">取消</button>

</div>

<!-- 项目页面核心内容 -->
<div id="program_index" style="margin: 30px;">
    <div id="项目第一行">
        <button class="programe_btn all" href="#" style="margin-top: 10px;border: none;font-size: 30px;">所有项目</button>
        <button id="program_innewprogram"  class="programe_btn" href="#" style="float: right; margin-top: 10px;margin-right: 10px	;">新建项目</button>
    </div>

    <%--用来存放遍历的项目--%>
    <div id="projectContext" style=" height: 300px;width: 1100px; margin-top: 20px;">
    </div>

    <!--<div style="margin-top: 10px;">
        <button href="#" style="margin-left: 10px;" class="programe_btn">管理项目模块</button>
    </div>-->
</div>
</body>

</html>
