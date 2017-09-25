<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2017/9/20
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>
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
    <title>Title</title>
    <script type="text/javascript">
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
                        $("#ul1_1").html("");
                        {
                            $("#ul1_1").append("<li>"+result.data.wSummary+"<div>"+result.data.wChallenge+"</div>" +
                                "<div>"+result.data.wTarget+","+result.data.wMethod+"</div></li>")
                        }
                    }
                },
                error:function (result) {
                    alert("没有周报");
                }
            })
        }
    </script>
</head>
<body>
<%
    //   datebox中默认日期为当前时间,以下java代码块用于获取正确格式的当前时间
    SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
    Date beginDate = new Date();
    Calendar date = Calendar.getInstance();
    date.setTime(beginDate);
    date.set(Calendar.DATE,date.get(Calendar.DATE));
    String today = dft.format(date.getTime());  // today即为当前时间
%>
<div id="time">
    <center>
    <input  id="time1" name="createdatetimeStart" value="<%=today%>" style="width: 120px;"
            onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" onclick="aaa()"/>
    </center>
</div>
<div id="div1" class="menu-sep" style="margin-left: 0px;width: 1000px;float: left;">
    <ul id="ul1_1"></ul>
</div>
</body>
</html>
