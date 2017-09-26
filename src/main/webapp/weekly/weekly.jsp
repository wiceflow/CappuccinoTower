<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2017/9/19
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html>

<head>
    <meta charset="utf-8" />
    <title>周报</title>
    <link rel="stylesheet" href="../resources/css/css.css" />
    <link rel="stylesheet" type="text/css" href="../resources/js/jquery-easyui-1.4.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../resources/js/jquery-easyui-1.4.5/themes/icon.css">
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/jquery.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nifty Modal Window Effects</title>
    <meta name="description" content="Nifty Modal Window Effects with CSS Transitions and Animations" />
    <meta name="keywords" content="modal, window, overlay, modern, box, css transition, css animation, effect, 3d, perspective" />
    <meta name="author" content="Codrops" />
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript">
        /**
         * 获取url中指定变量的值
         * @param paramName [String]变量名
         **/
        function getParam(paramName) {
            // 第二个是可选参数：i表示匹配时大小写不敏感、g表示匹配到一次就停止、m表示多次匹配
            var reg = new RegExp("(^|&)" + paramName + "=([^&]*)(&|$)","i");
            // substr(1)表示从下标1开始截取字符串，相当于删除第一个字符
            var result = window.location.search.substr(1).match(reg);
            if(result != null) {
                // 中文解码
                return decodeURI(result[2]);
            } else {
                return null;
            }
        }


        /**
         * 把毫秒级时间转换成字符串,保留时分秒
         * 格式：yyyy年MM月dd日 hh点mm分ss秒
         * @param date
         * @returns {string}
         */
        function dateFormatDetail(date) {
            var dateStr = new Date(v.date);
            // 重写toString方法
            Date.prototype.toLocaleString = function() {
                return this.getFullYear() + "年" + (this.getMonth() + 1) + "月" + this.getDate() + "日 " + this.getHours() + "点" + this.getMinutes() + "分" + this.getSeconds() + "秒";
            };
            return dateStr.toLocaleString();
        }

        /**
         * 把毫秒级时间转换成字符串
         * 格式：yyyy年MM月dd日
         * @param date
         * @returns {string}
         */
        function dateFormat(date) {
            var dateStr = new Date(date);
            // 重写toString方法
            Date.prototype.toLocaleString = function() {
                return this.getFullYear() + "年" + (this.getMonth() + 1) + "月" + this.getDate() + "日";
            };
            return dateStr.toLocaleString();
        }
        $(document).ready(function(){
            //页面加载时显示当前日期所在周
            $.ajax({
                type:"Post",
                url:"/weekly/weekByday",
                dataType:"json",
                data:{
                    wTime:$("#time1").val(),
                },
                success:function (result) {
                    if(result.errcode==1){
                        $("#bb1").append(dateFormat(result.data)+"-");
                        $("#bb2").append(dateFormat(result.page));
                    }
                },
                error:function (result) {
                    alert("查询失败！！！！");
                }
            })

            //页面加载完成，显示当前日期所在周的周报
            var a = $("#time1").val();
            $.ajax({
                type:"POST",
                url:"/weekly/selectWeekly",
                dataType:"json",
                data:{
                    wTime:a,
                },
                success:function (result) {
                    if(result.errcode==1){
                        //每次点击日期后清空
                        $("#aa1").empty();
                        $("#aa2").empty();
                        $("#aa3").empty();
                        $("#aa4").empty();
                        {
                            //在指定问题后输出周报内容
                            $("#aa1").append(result.data.wSummary),
                                $("#aa2").append(result.data.wChallenge),
                                $("#aa3").append(result.data.wTarget),
                                $("#aa4").append(result.data.wMethod)

                        }
                    }else if(result.errcode==0){
                        $("#aa1").empty();
                        $("#aa2").empty();
                        $("#aa3").empty();
                        $("#aa4").empty();
                    }else if(result.errcode==2){
                        alert("该团队没有创建周报");
                    }
                },
                error:function (result) {
                    alert("周报不存在");
                }
            })
            $('#report_setting').hide()
            $("#report_index").show()

            $("#inreport_setting").click(function(){
                $("#report_setting").fadeIn("fast")
                $("#report_index").fadeOut("fast")
            })

            $("#inreport_index").click(function(){
                $("#report_setting").fadeOut("fast")
                $("#report_index").fadeIn("fast")
            })

            $("#team_add_span").hide()

            $("#team_add").click(function(){
                $("#team_add_span").show()
                $("#team_add").hide()
            })

            $("#team_add_sure").click(function(){
                $("#team_add_span").hide()
                $("#team_add").show()
            })

            $("#team_add_cancel").click(function(){
                $("#team_add_span").hide()
                $("#team_add").show()
            })

            $("#member_add_span").hide()

            $("#member_add").click(function(){
                $("#member_add_span").show()
                $("#member_add").hide()
            })

            $("#member_add_sure").click(function(){
                $("#member_add_span").hide()
                $("#member_add").show()
            })

            $("#member_add_cancel").click(function(){
                $("#member_add_span").hide()
                $("#member_add").show()
            })

            $("#report_setting_span1").hide()
            $("#report_setting_span2").hide()
            $("#report_setting_span3").hide()

            $("#report_setting_p1").hover(function(){
                $("#report_setting_span1").toggle()
            })

            $("#report_setting_p2").hover(function(){
                $("#report_setting_span2").toggle()
            })

            $("#report_setting_p3").hover(function(){
                $("#report_setting_span3").toggle()
            })

        })

        //选择日期，显示该日期所在周的周报
            function aaa() {
                var a = $("#time1").val();
                $.ajax({
                    type:"POST",
                    url:"/weekly/selectWeekly",
                    dataType:"json",
                    data:{
                        wTime:a,
                    },
                    success:function (result) {
                        if(result.errcode==1){
                            //每次点击日期后清空
                            $("#aa1").empty();
                            $("#aa2").empty();
                            $("#aa3").empty();
                            $("#aa4").empty();
                            {
                                //在指定问题后输出周报内容
                                    $("#aa1").append(result.data.wSummary),
                                    $("#aa2").append(result.data.wChallenge),
                                    $("#aa3").append(result.data.wTarget),
                                    $("#aa4").append(result.data.wMethod)

                            }
                        }else if(result.errcode==0){
                            $("#aa1").empty();
                            $("#aa2").empty();
                            $("#aa3").empty();
                            $("#aa4").empty();
                        }else if(result.errcode==2){
                            alert("该团队没有创建周报");
                        }
                    },
                    error:function (result) {
                        alert("周报不存在");
                    }
                })

                //根据所选日期查询该日期所在周
                $.ajax({
                    type:"Post",
                    url:"/weekly/weekByday",
                    dataType:"json",
                    data:{
                        wTime:$("#time1").val(),
                    },
                    success:function (result) {
                        if(result.errcode==1){
                            $("#bb1").empty();
                            $("#bb2").empty();
                            $("#bb1").append(dateFormat(result.data)+"-");
                            $("#bb2").append(dateFormat(result.page));
                        }
                    },
                    error:function (result) {
                        alert("查询失败！！！！");
                    }
                })
            }

            //将所选日期的周报显示在输入框中
            function bbb() {
                var a = $("#time1").val();
            $.ajax({
                type:"Post",
                url:"/weekly/selectWeekly",
                dataType:"json",
                data:{
                    wTime:a,
                },
                success:function (result) {
                    if(result.errcode==1){
                        //每次点击日期后清空
                        $("#tx1").empty();
                        $("#tx2").empty();
                        $("#tx3").empty();
                        $("#tx4").empty();
                        {
                            //在指定问题后输出周报内容
                            $("#tx1").append(result.data.wSummary),
                                $("#tx2").append(result.data.wChallenge),
                                $("#tx3").append(result.data.wTarget),
                                $("#tx4").append(result.data.wMethod)

                        }
                    }else if(result.errcode==2){
                        alert("该团队没有创建周报");
                    }
                },
                error:function (result) {
                    alert("编辑失败");
                }
            })
            }

            //点击更新周报后，将更新内容传入后台进行更新
            function ccc() {
                $.ajax({
                    type:"Post",
                    url:"/weekly/updateWeekly",
                    dataType:"json",
                    data:{
                        wTime:$("#time1").val(),
                        wSummary:$("#tx1").val(),
                        wChallenge:$("#tx2").val(),
                        wTarget:$("#tx3").val(),
                        wMethod:$("#tx4").val(),
                    },
                    success:function (result) {
                        if(result.errcode==1){
                            alert("更新成功!!");
                        }
                    },
                    error:function (result) {
                        alert("更新失败");
                    }
                })
            }

            //跳转至添加周报页面
            function goaddweekly() {
                var a=$("#time1").val();
                location.href="../personal/personal.jsp?wTime=" + a ;
            }

    </script>
</head>

<body style="background-color: #212121;">
<%
    //   datebox中默认日期为当前时间,以下java代码块用于获取正确格式的当前时间
    SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
    Date beginDate = new Date();
    Calendar date = Calendar.getInstance();
    date.setTime(beginDate);
    date.set(Calendar.DATE,date.get(Calendar.DATE));
    String today = dft.format(date.getTime());  // today即为当前时间
%>
<div style="margin: 30px;">
    <a id="inreport_index" aria-label='word' class='h-button centered' data-text='周报总览' href='#' style="text-align: center; font-size: 30px;">
        <span>R</span>
        <span>e</span>
        <span>p</span>
        <span>o</span>
        <span>r</span>
        <span>t</span>

    </a>
    <p style="text-align: center;font-size: 30px;color: #0abd6a;font-weight: bold;">
        <a href="#" class="report_btn" style="font-weight: bold;font-size: 30px;">
            </a>
        <span id="report_indate"><input  id="time1" name="createdatetimeStart" value="<%=today%>" style="width: 120px;"
                                         onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" onclick="aaa()"/></span>
            <a class="report_btn" href="#" style="font-weight: bold;font-size: 30px;"></a>

    </p>
    <p style="text-align: center;font-size: 20px; color: gray;">
        <span id="bb1"></span>
        <span id="bb2"></span>
    </p>

</div>

<div style="text-align: right;margin-top: -180px;">

    <a onclick="goaddweekly()" class="report_btn">写周报</a>

</div>
<div class="menu-sep" style="margin-top: 130px;"></div>

<!--周报设置DIV-->
<div id="report_setting" style="margin-left: 260px;">
    <div class="container">
        <h3 style="color: white;">周报模版设置</h3></div>
    <p style="color: grey;">可以根据团队 / 小组 / 成员 三个不同层级，分别设置周报模板</p>
    <div class="container">
        <h3 style="color: white;">团队级模板</h3></div>
    <p style="color: grey;">团队所有成员，需要填写的内容</p>

    <p id="report_setting_p1" style="color:white;height:30px;width: 600px; font-size: 17px;">&nbsp;&nbsp;本周工作成果总结，说说你对自己点赞或失望的地方。
    </p>
    <textarea  id="tx1" style="resize: none;height:30px;width: 600px;border-radius:5px;background-color: #212121;color: #0ABD6A;border-color:#0ABD6A;"></textarea>
    <p id="report_setting_p2" style="color:white;height:30px;width: 600px; font-size: 17px;">&nbsp;&nbsp;有遇到挑战或者困难么？希望团队怎么帮助你？

    </p>
    <textarea  id="tx2" style="resize: none;height:30px;width: 600px;border-radius:5px;background-color: #212121;color: #0ABD6A;border-color:#0ABD6A;"></textarea>
    <p id="report_setting_p3" style="color:white;height:30px;width: 600px; font-size: 17px;">&nbsp;&nbsp;下周的工作目标是什么？只许说一个。

    </p>
    <textarea  id="tx3" style="resize: none;height:30px;width: 600px;border-radius:5px;background-color: #212121;color: #0ABD6A;border-color:#0ABD6A;"></textarea><br>
    <p id="report_setting_p4" style="color:white;height:30px;width: 600px; font-size: 17px;">&nbsp;&nbsp;你觉得采取哪些措施，会对你提升工作效率有帮助

    </p>
    <textarea id="tx4" style="resize: none;height:30px;width: 600px;border-radius:5px;background-color: #212121;color: #0ABD6A;border-color:#0ABD6A;"></textarea><br>
    <button class="report_btn" id="weeklyUpdate" onclick="ccc()">保存周报</button>
    <br>
    <span id="team_add_span">
				<textarea placeholder="编辑周报新问题" style="color: #0ABD6A;background-color: #212121;resize: none;width: 300px;height: 20px;"></textarea><br>
				<button id="team_add_sure" class="report_btn" >添加</button>
				<button id="team_add_cancel" class="report_btn">取消</button>
			</span>
    </br>
    <div class="container">
        <h3 style="color:white">小组级模块</h3></div>
    <p style="color: grey;">指定小组的成员，需要填写的内容
    <p style="color: grey;">团队内还没有小组，<button class="report_btn">点击这里新建小组。</button></p>
    </br>
    <div class="container">
        <h3 style="color: white;">成员级模块</h3></div>
    <p style="color: grey;">指定的成员，需要填写的内容</p>
    <p style="color: grey;">还没有成员级的模板</p>
    <button class="report_btn" id="member_add" >+添加一条</button>
    <br>
    <span id="member_add_span">&nbsp;&nbsp;
				<select style="width: 70px;" class="easyui-combobox">
					<option>BF</option>
					<option>YG</option>
					<option>JH</option>
				</select>
				<textarea placeholder="输入成员问题" style="float: left; height: 20px; font-size: 15px;background-color: #212121;color: #0ABD6A;resize: none;" ></textarea>&nbsp;
					<button class="report_btn" id="member_add_sure">添加</button>
				<button id="member_add_cancel" class="report_btn">取消</button>
			</span>-
</div>
<!--主页面-->
<div id="report_index">
    <img src="images/fzl2.jpg" height="50px" style=" margin-left: 50px;margin-top: 30px;" />
    <br>
    <a href="#" class="report_btn" style="margin-left: 60px;font-weight: bold;">邓超</a>
    <div style="margin-left: 250px;margin-top: -110px;margin-bottom: 10px;">
        <div class="container" >
            <h3 style="color:0#0ABD6A;">本周周报</h3></div>
        <div id="p1" style="font-weight: bold;color: #0ABD6A;"><span>"本周工作成果总结，说说你对自己点赞或失望的地方。"</span><br>
            <span style="color: grey;" id="aa1"></span>
        </div>

        <div id="p2" style="font-weight: bold;color: #0ABD6A;"><span>"有遇到挑战或者困难么？希望团队怎么帮助你？"</span><br>
            <span style="color: grey;" id="aa2"></span>
        </div>

        <div id="p3" style="font-weight: bold;color: #0ABD6A;"><span>"下周的工作目标是什么？只许说一个。"</span><br>
            <span style="color: grey;" id="aa3"></span>
        </div>

        <div id="p4" style="font-weight: bold;color: #0ABD6A"><span>"你觉得采取哪些措施，会对你提升工作效率有帮助？"</span><br>
            <span style="color: grey;" id="aa4"></span>
        </div>

        <br>
        <span style="color: grey;">勇郭</span>
        <span style="color: grey;">，创建于</span>
        <span style="color: grey;">2017年9月8日</span>
        <button id="inreport_setting" class="report_btn" onclick="bbb()">查看详情</button>
    </div>
    <br>
    <div class="menu-sep" style="margin-left:0px ;"></div>
    <div class="container" style="margin-left: 250px;">
        <h3 style="color: white;">他们本周无周报记录</h3>
    </div>
</div>
</div>

</body>
</html>