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
    
    <script type="text/javascript">
         $(document).ready(function () {
             $.ajax({
                 type:"Post",
                 url:"/dynamic/DynamicList",
                 dataType:"json",
                 data:{
                     tId:${param.tId},
                 },
                 success:function (result) {
                        $.each(result.data,function (n,v) {
                            $("#ul1_1").append("<li><h1>"+v.pName+"</h1><div>"+v.date+"</div>" +
                                "<div>"+v.uname+":"+v.action+"</div></li>")
                        })
                     },
                     error:function () {
                         alert("失败");
                     }

             })
         })
    </script>
    <script type="text/javascript">
        $(document).ready(function () {
           $("#select1")
            $.ajax({
                type:"POST",
                url:"/dynamic/projectByUid",
                dataType:"json",
                data:{
                    uId:${user.uId},
                },
                success : function(result) {// result为返回的数据
                  $.each(result.data,function (n,v) {
                      var op="<option value="+v.pName+">"+v.pName+"</option>"
                      $("#select1").append(op);
                  })

                  },
                error:function () {
                    alert("错了")
                }
                })


            $("#select1").change(function () {
                 $.ajax({
                     type:"POST",
                     url:"/dynamic/dynamicByPid",
                     dataType:"json",
                     data:{
                         pName:$("#select1").val(),
                         uName:$("#select2").val(),
                     },
                     success:function (result) {
                         if(result.errcode==1){
                             $("#ul1_1").html("");
                             $.each(result.data,function (n,v) {
                                 $("#ul1_1").append("<li><h1>"+v.pName+"</h1><div>"+v.date+"</div>" +
                                     "<div>"+v.uname+":"+v.action+"</div></li>")
                             })
                         }else{
                             alert("显示失败！")
                         }
                     }
                 })
            })

            $("#select2")
            $.ajax({
                type:"POST",
                url:"/dynamic/userByTid",
                dataType:"json",
                data:{
                    tId:${param.tId},
                },
                success:function (result) {//result为返回的数据
                    $.each(result.data,function (n,v) {
                        var op1="<option value="+v.uName+">"+v.uName+"</option>"
                        $("#select2").append(op1);
                    })

                },
                error:function () {
                    alert("错了1111")
                }
            })

            $("#select2").change(function () {
                $.ajax({
                    type:"POST",
                    url:"/dynamic/dynamicByPid",
                    dataType:"json",
                    data:{
                        pName:$("#select1").val(),
                        uName:$("#select2").val(),
                    },
                    success:function (result) {
                        if(result.errcode==1){
                            $("#ul1_1").html("");
                            $.each(result.data,function (n,v) {
                                $("#ul1_1").append("<li><h1>"+v.pName+"</h1><div>"+v.date+"</div>" +
                                    "<div>"+v.uname+":"+v.action+"</div></li>")
                            })
                        }else{
                            alert("显示失败1111")
                        }
                    }
                })
            })



        });

    </script>
    <style>

    </style>
</head>
<body style="margin: 20px;">
<p>筛选动态:</p>
<select id="select1">
    <option value='0'>所有项目...</option>
</select>
<select id="select2">
    <option value="0">所有成员</option>

</select>
<br><br><br>
<div id="div1" class="menu-sep" style="margin-left: 0px;width: 1000px;float: left;">
    <ul id="ul1_1"></ul>
</div>



</body>
</html>

