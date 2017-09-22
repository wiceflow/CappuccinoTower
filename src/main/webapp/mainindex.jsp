<%--
  Created by IntelliJ IDEA.
  User: WU
  Date: 2017/9/11
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>所有项目的项目</title>
    <link rel="stylesheet" href=resources/index.css" />
    <link rel="stylesheet" type="text/css" href="resources/js/jquery-easyui-1.4.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="resources/js/jquery-easyui-1.4.5/themes/icon.css">
    <script type="text/javascript" src="resources/js/jquery-easyui-1.4.5/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="resources/js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $.ajax({
                type:"Post",
                url:"/project/ListByUid",
                dataType:"json",
                data:{
                    uId:${user.uId},
                },
                success:function (result) {
                    $.each(result.data,function (n,v) {
                        $("#div2").append("<a href='project/displayproject.jsp?pId="+v.pId+"'>"+v.pName+"</a><br>")
                    })
                },
                error:function () {
                    alert("oooooo");
                }

            })
        })
    </script>
</head>

<body>
<!-- 项目页面核心内容 -->
<div >


    <div id="div1">
        <a href="#" style="color: black;background-color: pink;" class="all">所有项目</a>
        <a href="/project/createproject.jsp" style="float: right;color: blue;margin-top: 10px;margin-right: 10px	;">新建项目</a>
    </div>

    <div id="div2" style=" height: 300px;width: 1100px; margin-top: 20px;">
    </div>

    <div style="margin-top: 10px;">
        <a href="#" class="p1" style="margin-left: 10px;" >管理项目模块</a>
    </div>
</div>
</body>
</html>
