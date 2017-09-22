<%--
  Created by IntelliJ IDEA.
  User: WU
  Date: 2017/9/11
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新建项目</title>
    <script type="text/javascript" src="../resources/js/jquery-3.1.1.js"></script>
    <script type="text/javascript">
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
                          str = "<li>"+v.uName+"</input><li>";
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


        function sureName() {
            var uname=$("#selectName").val();
            $.ajax({
                type: "Post",
                url: "/project/selectName",
                dataType: "json",
                data: {
                    uName:uname,
                },
                success: function (result2) {
                    $.each(result2.data,function (n,v){


                    })
                },
                error:function () {
                    alert("失败2");
                }
            })
        }
    </script>
    <%--样式--%>
    <style type="text/css">
        li{
            list-style:none;
            padding-top:2px;
            width:150px;

        }
        ul{
            margin-top:5px;
            margin-left:-40px;
        }
        a{
            text-decoration:none;
            color:#5C5C5C;
        }
        .clor{
            background-color:#ADADAD;
        }

    </style>


</head>
<body>
<form action="/project/putProject" method="post">
    <div>
        <tr>
            <td>项目名称</td>
            <td><input type="text" name="pName"></td>
        </tr>
        <br>
        <tr>
            <td>项目描述</td>
            <td><input type="text" name="pDescribe"></td>
            <td><input type="checkbox" name="pSensitive" value="1">是否屏蔽敏感词汇</td>
        </tr>
        <br>
        <tr>
            <td>是否公开</td>
            <td><input type="radio" value="0" name="ispublic" checked="checked">公开</td>
            <td><input type="radio" value="1" name="ispublic">私密</td>
        </tr>
        <br>
        <tr>
            <td>勾选组员</td>
            <div id="div2">
                <span id="divp">
                    <input type="checkbox" name="uId" value="${user.uId}" checked="checked">${user.uName}
                </span>
            </div>
        </tr>
        <br>
        <tr>
            <input type="submit" value="提交">
        </tr>
    </div>
</form>
 <tr >
    <td >搜索组员</td>
    <td >
        <input type="text" name="uName" id="selectName" onkeyup="selectByName()">

    </td>
    <td><button id="selectButton" onclick="sureName()">添加</button></td>
</tr>

</body>
</html>
