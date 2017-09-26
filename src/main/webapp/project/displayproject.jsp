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
//            页面加载时遍历项目信息
            $.ajax({
                type:"Post",
                url:"/project/displayProject",
                dataType:"json",
                data:{
                    pId:${param.pId},
                },
                success:function (result) {
                    $("#project").append("<h2>"+result.data.pName+"</h2><h3>"+result.data.pDescribe+"</h3>")
                },
                error:function () {
                  alert("项目输出错了");
                }
            })
        })
        //页面加载时遍历讨论表
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

        //页面加载时遍历任务
        $(document).ready(function () {
            $.ajax({
                type:"Post",
                url:"/TaskInfo/taskInfoList",
                dataType:"json",
                data:{
                    pId:${param.pId},
                },
                success:function (result) {
                    $.each(result.data,function (n,v) {
                        $("#task3").append("<div><div><h2>" +
                            "<a href='../TaskInfo/displayonetaskinfo.jsp?taskinfoId="+v.taskinfoId+"'>"+v.taskinfoName+"</a>" +
                            "</h2></div><div>" +
                            "<a href='javascript:' onclick='opentask(v.taskinfoId)'>添加任务</a></div>" +
                            "<div id='v.taskinfoId' hidden><input id='taskName' name='taskName'type='text'></div>" +
                            "</div><br>")
                    })
                },
                error:function () {
                  alert("任务遍历失败");
                },
            })
        })
        //页面加载的时候加载文件和文件夹
        $(document).ready(function () {
            $.ajax({
                type:"Post",
                url:"/total/QueryFileByPid",
                dataType:"json",
                data:{
                    pId:${param.pId},
                },
                success:function (result) {
                    $.each(result.data,function (n,v) {
                        if(v.type==0){
                            $("#file3").append("<div id='"+v.fileId+"'>"+v.fileName+"</div>");
                        }
                        if(v.type==1){
                            $("#file3").append("<div id='"+v.folderId+"'><a href=''>"+v.folderName+"</a></div>")
                        }
                    })
                },
                error:function () {
                    alert("文件遍历了失败");
                }
            })
        })
    </script>

    <%--管理任务的开启，关闭和添加————————没写完的 --%>
    <script type="text/javascript">
        function opentaskinfo() {
            $("#task2").show();
        }
        function closetaskinfo() {
            $("#task2").hide();
        }
        function closetask() {
            $("#task1").hide();
        }
        function opentask(val) {
            $("#val").show();
        }
//        任务清单的新建
        function starttaskinfo() {
            $.ajax({
                type:"Post",
                url:"/TaskInfo/addTaskInfo",
                dataType:"json",
                data:{
                    pId:${param.pId},
                    taskinfoName:$("#taskinfoName").val(),
                    takinfoDescribe:$("#takinfoDescribe").val(),
                },
                success:function (result) {
                    $("#task3").before("<div>" +
                        "<a href='../task/displayonetask.jsp?taskinfoId="+result.data.taskinfoId+"'>" +
                        ""+result.data.taskinfoName+"</a></div>");
                },
                error:function () {
                    alert("任务清单错了");
                }
            })
        }

    </script>

    <%--管理讨论的js--%>
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

    <%--上传文件的--%>
    <script type="text/javascript">
        //上传文件的显示和隐藏
        function openfile() {
            $("#file1").show();
        }
        function closefile() {
            $("#file1").hide();
        }
        //新建文件夹的显示和隐藏
        function openfolder() {
            $("#file2").show();
        }
        function closefolder() {
            $("#file2").hide();
        }
//        上传文件
        function doUpload() {
            var formData = new FormData($("#uploadForm")[0]);
            //用form 表单直接 构造formData 对象就不需要下面的append 方法来为表单进行赋值了。
            $.ajax({
                url: "/file/uploadfile",
                type: "Post",
                data: formData,
                async: false,//要求同步 不是不需看你的需求
                cache: false,
                contentType: false,  //必须false才会自动加上正确的Content-Type
                processData: false, //必须false才会避开jQuery对 formdata 的默认处理
                success: function (result) {
                    alert(result.errcode);
                },
                error: function () {
                    alert("上传失败");
                }
            })
        }
//        创建文件夹
        function startfolder() {
            $.ajax({
                type:"Post",
                url:"/Folder/AddFolder",
                dataType:"json",
                data:{
                    folderName:$("#folderName").val(),
                    pId:${param.pId},
                },
                success:function (result) {
                    alert(result.errcode);

                },
                error:function () {
                    alert("文件夹创建错误");
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
    <h3>任务</h3>
    <button onclick="opentaskinfo()">添加任务清单</button>
    <div id="task2" hidden>
        任务清单：<input id="taskinfoName" name="taskinfoName" type="text" >
        任务描述：<input id="takinfoDescribe" name="takinfoDescribe" type="text">
        <button onclick="starttaskinfo()">添加任务清单</button>
        <button onclick="closetaskinfo()">取消</button>
    </div>
    <div id="task3">
        <div id="task1" hidden>
            <input id="taskName" name="taskName" type="text" >
            <button onclick="starttask()">添加任务</button>
            <button onclick="closetask()">取消</button>
        </div>
    </div>
</div>

<div id="discus">
    <h3>讨论</h3>
    <button onclick="openword()">发起讨论</button>
    <div id="discus2" hidden>
        讨论主题：<input id="dTopic" name="dTopic" type="text" >
        讨论内容:<input id="dContent" name="dContent" type="text" >
        <button onclick="startdis()">提交评论</button>
        <button onclick="closediscus()">取消</button>
    </div>
    <div id="discus3">
    </div>
</div>

<div id="file">
    <h3>文件</h3>
    <button onclick="openfile()">上传文件</button><button onclick="openfolder()">创建文件夹</button>
    <div id="file1" hidden>
        <form id= "uploadForm" enctype="multipart/form-data">
            <p>上传文件： <input type="file" name="file"/></p>
            <input type="button" value="上传" onclick="doUpload()"/>
            <button onclick="closefile()">取消</button>
        </form>
    </div>
    <div id="file2" hidden>
        文件夹名：<input id="folderName" type="text" name="folderName" >
        <button onclick="startfolder()">创建文件夹</button>
        <button onclick="closefolder()">取消</button>
    </div>
    <div id="file3"></div>
</div>
</div>
</body>
</html>
