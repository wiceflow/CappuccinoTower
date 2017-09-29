<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2017/9/12
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>动态 - power</title>
    <link rel="stylesheet" href="../resources/css/css.css"/>
    <link rel="stylesheet" type="text/css" href="../resources/js/jquery-easyui-1.4.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../resources/js/jquery-easyui-1.4.5/themes/icon.css">
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/jquery.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>
    <!--SELECT-->
    <link rel="stylesheet" type="text/css" href="../resources/select_css/default.css">
    <link rel="stylesheet" href="../resources/select_css/combo.select.css">
    <!--SELECT-->
    <script src="http://www.jq22.com/jquery/1.11.1/jquery.min.js"></script>
    <script type="text/javascript">
        /**
         * 把毫秒级时间转换成字符串,保留时分秒
         * 格式：yyyy年MM月dd日 hh点mm分ss秒
         * @param date
         * @returns {string}
         */
        function dateFormatDetail(date) {
            var dateStr = new Date(v.date);
            // 重写toString方法
            Date.prototype.toLocaleString = function () {
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
            Date.prototype.toLocaleString = function () {
                return this.getFullYear() + "年" + (this.getMonth() + 1) + "月" + this.getDate() + "日";
            };
            return dateStr.toLocaleString();
        }
        //打开动态页面，自动遍历当前团队所有动态
        $(document).ready(function () {
            $.ajax({
                type: "Post",
                url: "/dynamic/DynamicList",
                dataType: "json",
                data: {
                    tId:${param.tId},
                },
                success: function (result) {
                    $.each(result.data, function (n, v) {
                        $("#ul1_1").append("<li>" + "<h1>" + v.pName + "</h1>" +
                            "<span style='font-size: 20px;color: grey;font-family: 'Microsoft YaHei', sans-serif'>" +
                            dateFormat(v.date) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                            "</span>" +
                            "<span class='weekcontent'>" + v.uname + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "</span>" + ": " +
                            "<span class='weekcontent'>"  + v.action +"<a  href='#' onclick=gohref('"+v.operateId+"','"+v.table+"')>"+v.aaName+"</a>" + "</span>" +
                            "</div></li>")
                    })
                },
                error: function () {
                    alert("失败");
                }
            })
        })



        function gohref(a,b) {
            $.ajax({
                type:"Post",
                url:"/dynamic/hyperlink",
                dataType:"json",
                data:{
                    operateId:a,
                    table:b,
                },
                success:function (result) {
                    if(result.errcode==1){

                        if(result.data.type==1){
                            location.href="../main/task_index.jsp?operateId='"+a+"'";
                        }else if(result.data.type==2){
                            alert(result.data.discus.dTopic);
                        }else if(result.data.type==3){
                            alert(result.data.comment.cComment);
                        }else if(result.data.type==4){
                            alert(result.data.file.fileName);
                        }else if(result.data.type==5){
                            alert(result.data.folder.folderName);
                        }else if(result.data.type==6){
                            alert(result.data.team.tName);
                        }else if(result.data.type==7){
                            location.href="../weekly/weekly11.jsp?operateId='"+a+"'";
                        }
                    }
                }
            })
        }
    </script>
    <script type="text/javascript">
        //打开动态页面，在select1中遍历用户在该团队中所有项目
        $(document).ready(function () {
            $("#select1")
            $.ajax({
                type: "POST",
                url: "/dynamic/projectByTid",
                dataType: "json",
                data: {
                    tId:${param.tId},
                },
                success: function (result) {// result为返回的数据
                    $.each(result.data, function (n, v) {
                        var op = "<option value=" + v.pName + ">" + v.pName + "</option>"
                        $("#select1").append(op);
                    })

                },
                error: function () {
                    alert("错了")
                }
            })


            //点击select1中的项目执行该方法，显示被点击项目的动态列表
            $("#select1").change(function () {
                $.ajax({
                    type: "POST",
                    url: "/dynamic/dynamicByPid",
                    dataType: "json",
                    data: {
                        pName: $("#select1").val(),
                        uName: $("#select2").val(),
                    },
                    success: function (result) {
                        if (result.errcode == 1) {
                            $("#ul1_1").html("");
                            $.each(result.data, function (n, v) {
                                $("#ul1_1").append("<li>" + "<h1>" + v.pName + "</h1>" +
                                    "<div id='weekdate' style='font-size: 20px;color: grey;'>" +
                                    dateFormat(v.date) +
                                    "</div>" +
                                    "<div >" +
                                    "<a name='v.operateId' >" +
                                    v.uname + ": " +
                                    v.aaName +
                                    v.action +
                                    "</a></div></li>")
                            })
                        } else {
                            alert("显示失败！")
                        }
                    }
                })
            })

            ////打开动态页面，在select2中遍历该团队中所有组员
            $("#select2")
            $.ajax({
                type: "POST",
                url: "/dynamic/userByTid",
                dataType: "json",
                data: {
                    tId:${param.tId},
                },
                success: function (result) {//result为返回的数据
                    $.each(result.data, function (n, v) {
                        var op1 = "<option value=" + v.uName + ">" + v.uName + "</option>"
                        $("#select2").append(op1);
                    })

                },
                error: function () {
                    alert("错了1111")
                }
            })

            //点击select2中的组员执行该方法，显示被点击组员的动态列表
            $("#select2").change(function () {
                $.ajax({
                    type: "POST",
                    url: "/dynamic/dynamicByPid",
                    dataType: "json",
                    data: {
                        pName: $("#select1").val(),
                        uName: $("#select2").val(),
                    },
                    success: function (result) {
                        if (result.errcode == 1) {
                            $("#ul1_1").html("");
                            $.each(result.data, function (n, v) {
                                $("#ul1_1").append("<li>" +
                                    "<h1>" + v.pName + "</h1>" +
                                    "<div id='weekdate' style='font-size: 20px;color: grey;'>" +
                                    dateFormat(v.date) +
                                    "</div>" +
                                    "<div >" +
                                    v.uname + ": " +
                                    v.action +
                                    "</div></li>")
                            })
                        } else {
                            alert("显示失败1111")
                        }
                    }
                })
            })
        });

    </script>

    <style>
        body {
            background-color: #212121;
        }


        .weekcontent{
            font-size: 20px;
            color: grey;
            font-family: "Microsoft YaHei", sans-serif;
        }
        h1 {
            font-size: 30px;
            color: white;

        }

    </style>
</head>
<body style="margin: 20px;">
<p>筛选动态:</p>
<div style="float:left;">
    <select id="select1">
        <option value='0'>所有项目</option>
    </select>
</div>

<div style="float:left;">
    <select id="select2">
        <option value="0">所有成员</option>
    </select>
</div>

<br><br><br>
<div id="div1" class="menu-sep" style="margin-left: 0px;width: 1000px;float: left;">
    <ul id="ul1_1"></ul>
</div>


</body>
</html>

