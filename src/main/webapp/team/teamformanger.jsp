<%--
  Created by IntelliJ IDEA.
  User: WU
  Date: 2017/9/21
  Time: 8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <title>管理者团队</title>
    <link rel="stylesheet" href="../resources/css/team.css.css" />
    <link rel="stylesheet" type="text/css" href="../resources/js/jquery-easyui-1.4.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../resources/js/jquery-easyui-1.4.5/themes/icon.css">
    <link rel="stylesheet" href="../resources/css/team.inserthtml.com.radios.min.css" />
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/jquery.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="../resources/js/newjs.js"></script>

    <script type="text/javascript">
        $(document).ready(function(){
            $(".container").hover(function(){
                $(".container").css("color","white")
            })

            $("#team_newgroup").hide()
            $("#team_invite").hide()

//            $("#inteam_newgroup").click(function(){
//                $("#query1").html("");
//                $("#team_invite").hide()
//                $("#team_newgroup").show()
//            })

            $("#inteam_invite").click(function(){
                $("#query1").html("");
                $("#team_newgroup").hide();
                $("#team_invite").show();
            })
        })
    </script>
    <%--遍历团队人员--%>
    <script type="text/javascript">
        $(document).ready(function () {
            $.ajax({
                type:"Post",
                url:"/userandteam/QueryUserByTid",
                dataType:"json",
                data:{
                    tId:${param.tId},
                },
                success:function (result) {
                    $.each(result.data,function (n,v) {
                        $("#topic").html(v.tName);
                        if(v.type==1){
                            $("#query1").append("<a><a href='../user/userfromteam.jsp?uId="+v.uId+"'>"+v.uName+"</a>" +
                                "超级管理员</a>" +
                                "<a style='margin-left:730px;'>"+v.uEmail+"</a><br>")
                        }else{
                            $("#query1").append("<a><a href='../user/userfromteam.jsp?uId="+v.uId+"'>"+v.uName+"</a>" +
                                "</a>" +
                                "<a style='margin-left:800px;'>"+v.uEmail+"</a><br>")
                        }

                    })
                },
                error:function () {
                   alert("遍历组员失败")
                }
            })

        })
    </script>
    <%--遍历分组--%>
    <script type="text/javascript">
        $(document).ready(function () {
            $.ajax({
                type:"Post",
                url:"/group/QueryGroupByTid",
                dataType:"json",
                data:{
                    tId:${param.tId},
                },
                success:function (result) {
                    $.each(result.data,function (n,v) {
                        $("#inteam_group").append("" +
                            "<a class='team_btn' onclick='selectGroup(this)' id='"+v.gId+"'>"+v.gName+"</a>")
                    })
                },
                error:function () {
                    alert("分组名遍历失败");
                }
            })
        })
    </script>

    <%--根据gid进行查询组员--%>
    <script type="text/javascript">
        function selectGroup(obj) {
            var gId=obj.id;
            $.ajax({
                type:"Post",
                url:"/group/SelectUserByGid",
                dataType:"json",
                data:{
                    gId:gId,
                },
                success:function (result) {
                    $("#query1").html("");
                    $("#team_newgroup").hide();
                    $("#team_invite").hide();
                    $.each(result.data,function (n,v) {
                        if(v.type==1){
                            $("#query1").append("<a><a href='../user/userfromteam.jsp?uId="+v.uId+"'>"+v.uName+"</a>" +
                                "超级管理员</a>" +
                                "<a style='margin-left:730px;'>"+v.uEmail+"</a><br>")
                        }else{
                            $("#query1").append("<a><a href='../user/userfromteam.jsp?uId="+v.uId+"'>"+v.uName+"</a>" +
                                "</a>" +
                                "<a style='margin-left:800px;'>"+v.uEmail+"</a><br>")
                        }

                    })
                },
                error:function () {
                    alert("小组成员遍历错误")
                }

            })
        }
    </script>

    <%--按钮所有成员的操作--%>
    <script type="text/javascript">
        function selectteam() {
            $.ajax({
                type:"Post",
                url:"/userandteam/QueryUserByTid",
                dataType:"json",
                data:{
                    tId:${param.tId},
                },
                success:function (result) {
                    $("#query1").html("");
                    $("#team_newgroup").hide();
                    $("#team_invite").hide();
                    $.each(result.data,function (n,v) {
                        if(v.type==1){
                            $("#query1").append("<a><a href='../user/userfromteam.jsp?uId="+v.uId+"'>"+v.uName+"</a>" +
                                "超级管理员</a>" +
                                "<a style='margin-left:730px;'>"+v.uEmail+"</a><br>")
                        }else{
                            $("#query1").append("<a><a href='../user/userfromteam.jsp?uId="+v.uId+"'>"+v.uName+"</a>" +
                                "</a>" +
                                "<a style='margin-left:800px;'>"+v.uEmail+"</a><br>")
                        }

                    })
                },
                error:function () {
                    alert("遍历组员失败")
                }
            })
        }
    </script>

    <%--遍历所有的组员，放到checkbox中等待选择--%>
    <script type="text/javascript">
        function createnewgroup() {
            $.ajax({
                type:"Post",
                url:"/userandteam/QueryUserByTid",
                dataType:"json",
                data:{
                    tId:${param.tId},
                },
                success:function (result) {
                    $("#query1").html("");
                    $("#team_invite").hide();
                    $("#team_newgroup").show();
                    $("#checkboxuser").html("");
                    $.each(result.data,function (n,v) {

                        if(v.type==1){
                            $("#checkboxuser").append("<input type='checkbox' id='checkbox-2-"+v.uId+"' value='"+v.uId+"' name='uId' checked>" +
                                "<label for='checkbox-2-"+v.uId+"' style='height: 10px;width: 50px;text-align: left;font-weight: bold;font-size: 18px;'>"+v.uName+"</label>")
                        }else{
                            $("#checkboxuser").append("<input type='checkbox' id='checkbox-2-"+v.uId+"' value='"+v.uId+"' name='uId'>" +
                                "<label for='checkbox-2-"+v.uId+"' style='height: 10px;width: 50px;text-align: left;font-weight: bold;font-size: 18px;'>"+v.uName+"</label>")
                        }
                    })
                },
                error:function () {
                    alert("遍历组员失败")
                }
            })
        }
    </script>
    
    <%--新建分组--%>
    <script type="text/javascript">
        function addGroup() {
            var arr=[];
            $("input[type='checkbox']:checked").each(function(){
                arr.push(this.value);
            });
            //数组转换成json，都在了，数组和json

            $.ajax({
                type:"Post",
                url:"/group/addGroup",
                dataType:"json",
                data:{
                    tId:${param.tId},
                    uId:arr,
                    gName:$("#gName").val(),
                },
                success:function (result) {
                    if(result.errcode==1){
                        alert("新增分组成功")
                    }
                },
                error:function () {
                    alert("添加分组失败")
                }
            })

        }
    </script>
</head>

<body style="background-color: #212121;">
<div style="margin: 90px;">
    <div class="container">
        <a id="topic" style="font-size: 35px;"></a>
    </div>
    <br>
    <a id="inteam_group">
    <button class="team_btn" id="inteam_team" onclick="selectteam()">所有成员</button>
    </a>
    <button class="team_btn" id="inteam_invite" style="margin-left:650px;">邀请新成员</button>
    <button class="team_btn" id="inteam_newgroup" style="" onclick="createnewgroup()">新建分组</button>
    <div class="menu-sep" style="margin-left: 0px;margin-top: 20px;margin-bottom: 20px;width: 1000px;"></div>
</div>

<%--遍历组员--%>
<div id="query" >
    <div id="query1" style="color: slateblue;font-weight: bold; margin-left: 80px;margin-top: -60px;margin-bottom: 10px;"></div>
</div>
<%--遍历分组成员--%>
<div id="selectgroup">
    <div id="selectgroup1"></div>
</div>
<!--新建分组-->
<div id="team_newgroup" style="margin-left: 80px;margin-top: -60px;">
    <div class="container">
        <a style="font-size: 25px;">新建成员分组</a></div>
    <br>
    <input id="gName" placeholder="成员分组名称" style="margin-top: 10px; color:slateblue;background-color: #212121; margin-left: 10px;border-radius: calc(5px); resize: none;height: 25px;width: 300px;"></input>
    <br>
    <br>
    <div class="container">
        <a style="margin-left: 0px;font-size: 25px;color: white;">选择成员</a>
    </div>
    <br><br>&nbsp;&nbsp;
    <div id="checkboxuser">

    </div>

    <div class="menu-sep" style="margin-left: 10px;margin-top: 20px;margin-bottom: 20px;width: 1000px;"></div>
    <button class="team_btn"  style="margin-left: 10px;width: 170px;border-color: #212121;">邀请新成员加入分组</button><br>
    <button class="team_btn"  style="margin-left: 40px;" onclick="addGroup()">保存设置</button>

</div>

<div id="team_invite">
    <div id="text" style="color: slateblue;font-weight: bold; margin-left: 80px;margin-top: -60px;margin-bottom: 10px;">
        > 添加新成员<span id="cursor"> █</span>
    </div>
    <div class="container" style="margin-left: 80px;">
        <a style="font-size: 20px;">通过邮件邀请，无需审核</a></div><br>
    <a style="font-size: 15px;color: grey;margin-left: 90px;">你可以预先设置好访问权限，发送邀请给指定的邮箱，对方只需进行个人账户设置即可直接加入团队，无需等待审批。</a>
    <br>
    <button class="team_btn"  style="margin-left: 90px;margin-top: 20px;width: 180px;">通过邮件邀请新成员</button>
    <br><br>
    <div class="container" style="margin-left: 80px;">
        <a style="font-size: 20px;">通过微信扫码，邀请好友</a></div><br>
    <a style="font-size: 15px;color: grey;margin-left: 90px;">用微信扫描二维码获取邀请函，转发给微信好友/群，即可邀请他们加入你的团队。</a>
</div>

</div>
</body>

</html>