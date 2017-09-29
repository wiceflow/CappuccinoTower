<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2017/9/28
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<head>
    <meta charset="utf-8" />
    <title>任务1（任务名称）</title>
    <link rel="stylesheet" href="../resources/task_dist/css/checkbix.min.css">
    <link rel="stylesheet" type="text/css" href="../resources/task_css/checked.min.css" >
    <link rel="stylesheet" type="text/css" href="../resources/task_css/task_css.css" >
    <!--日期框-->
    <script type="text/javascript" src="../resources/task_js/jquery-easyui-1.4.5/jquery.min.js"></script>
    <script type="text/javascript" src="../resources/task_js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../resources/task_js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" type="text/css" href="../resources/task_js/jquery-easyui-1.4.5/themes/default/easyui.css">
    <!--日期框-->
    <script src="../resources/task_dist/js/checkbix.min.js"></script>
    <script>
        Checkbix.init();
    </script>
    <script type="text/javascript">
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


        $(document).ready(function () {
            $.ajax({
                type:"Post",
                url:"/Task/selectTask",
                dataType:"json",
                data:{
                    taskId:${param.operateId},
                },
                success:function (result) {
                    if(result.errcode==1){
                        $("#tName").append(result.data.task.taskName);
                        $("#tAssigner").append(result.data.taskAssigner.uName);
                        $("#tUser").append(result.data.taskUser.uName);
                        $("#tTime").append(dateFormat(result.data.task.taskCreatetime));
                        $("#tfTime").append(dateFormat(result.data.task.taskFinishtime));
                    }
                },
                error:function () {
                    alert("查询任务错误！！");
                }
            })
        })

    </script>
</head>

<body style="background-color: #212121;">
<div>

    <span  style="color: pink; ">任务名称：</span>
    <br><br><br>
    <span  id="tName" style="color: pink; "></span>
    <br><br><br>
    <span style="color: grey; ">任务创建人：</span><br><br>
    <span id="tUser" style="color: pink;"></span>
    <br><br><br>
    <span style="color: grey; ">被指派成员</span><br><br>
    <span id="tAssigner" style="color: pink;"></span>

    <!--日历-->
    <br><br><br>
    <span style="color: grey; ">创建时间:</span>
    <span id="tTime" style="color: pink; "></span>
    <br><br><br>
    <span style="color: grey; ">截止日期:</span>
    <span id="tfTime" style="color: pink; "></span>
    <br><br>
    <div class="menu-sep" style="margin-left: 0px;"> </div>
    <p  style="color:white ;">PG ONE :我同意 (这是一条新的评论)</p>
    <br>
    <textarea placeholder="发表评论 " style=" calc(5px);margin-left: 0px; background-color: #212121;resize: none;border-radius: calc(5px);color: pink;height: 30px;font-size: 20px; "></textarea>
    <br>
    <button id="task_comsure" class="tk_btn" style="margin-top: 5px; font-size: 15px; ">评论</button>
</div>
</body>
</body>
</html>
