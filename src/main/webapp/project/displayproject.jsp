<%--
  Created by IntelliJ IDEA.
  User: WU
  Date: 2017/9/14
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示项目</title>
    <link rel="stylesheet" type="text/css" href="../resources/js/jquery-easyui-1.4.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../resources/js/jquery-easyui-1.4.5/themes/icon.css">
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/jquery.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $.ajax({
                type:"Post",
                url:"/project/displayProject",
                dataType:"json",
                data:{
                    pId:${param.pId},
                },
                success:function (result) {
                    $("#project").append("<h1>"+result.data.pName+"</h1><h3>"+result.data.pDescribe+"</h3>")
                },
                error:function () {
                  alert("项目输出错了");
                }
            })
        })

        $(document).ready(function () {
            $.ajax({
                type:"Post",
                url:"/discus/QueryDiscus",
                dataType:"json",
                data:{
                    pId:${param.pId},
                },
                success:function (result) {
                    $.each(result.data,function (n,v) {
                        $("#discus3").append("<div><div>"+v.uName+"<div>" +
                            "<a href='../discus/discusAndcomment.jsp?discusId="+v.discusId+"'>" +
                            "<h3>"+v.dTopic+"</h3></a></div>" +
                            "<div>"+v.dContent+"</div></div></div>")
                    })
                },
                error:function () {
                    alert("遍历评论错了")
                }
            })
        })
    </script>
    <script type="text/javascript">
        function openword() {
            $("#discus2").show();
        }
        function closediscus() {
            $("#discus2").hide();
        }
        function startdis() {
          $.ajax({
              type:"Post",
              url:"/discus/creatDiscus",
              dataType:"json",
              data:{
                  pId:${param.pId},
                  dTopic:$("#dTopic").val(),
                  dContent:$("#dContent").val(),
              },
              success:function (result) {
                  $("#discus3").before("<div><div>"+result.data.uName+"<div>" +
                      "<a href='../discus/discusAndcomment.jsp?discusId="+result.data.discusId+"'>" +
                      "<h3>"+result.data.dTopic+"</h3></a></div>" +
                      "<div>"+result.data.dContent+"</div></div></div>")
              },
              error:function () {
                  alert("发起评论错了");
              }
          })
        }
    </script>
</head>
<body>
<div>
<div id="project">
</div>

<div id="task">

</div>

<div id="discus">
    <button onclick="openword()">发起讨论</button>
    <div id="discus2" hidden>
    <input id="dTopic" name="dTopic" type="text" >
    <input id="dContent" name="dContent" type="text" >
    <button onclick="startdis()">提交评论</button>
    <button onclick="closediscus()">取消</button>
    </div>
    <div id="discus3">
    </div>
</div>

<div id="file">

</div>
</div>
</body>
</html>
