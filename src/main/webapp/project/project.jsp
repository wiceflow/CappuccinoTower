<%--
  Created by IntelliJ IDEA.
  User: WU
  Date: 2017/9/11
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>星标项目1</title>
    <link rel="stylesheet" href="../resources/css/jquery.dad.css" />
    <link rel="stylesheet" href="../resources/css/css.css" />
    <link rel="stylesheet" type="text/css" href="../resources/js/jquery-easyui-1.4.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../resources/js/jquery-easyui-1.4.5/themes/icon.css">
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/jquery.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="../resources/js/jquery.dad.min.js"></script>
    <!--<script src="js/jquery-1.11.3.min.js"></script>-->
    <script type="text/javascript">
        $(document).ready(function(){
            $('#btn1').switchbutton({ checked: false })

            $('#newbtn1').switchbutton({ checked: false })
            $('#d1').hide()

            $(".addtask").click(function(){
                $('#d1').slideDown()
            })

            $("#btn1").switchbutton("disable");

            $("#newdiv").hide()

            $("#d2").hide()

            $(".addlist").click(function(){
                $("#d2").slideToggle()
            })

            $("#addtask11").click(function(){
                document.getElementById("newspan").innerHTML = $("#taskinput").val();

            })

            $("#addtask11").click(function(){
                $("#newdiv").slideDown()
            })

            $(".cancellist").click(function(){
                $("#d2").slideToggle()
            })

            $(".canceltask").click(function(){
                $("#d1").slideToggle()
            })

            $('#taskman').menubutton({menu: '#mm1'});

            $("#tasktime").click(function(){
                $('#cc').slideToggle()
            })

            $("#cc").click(function(){
                $('#cc').slideToggle()
            })

            $('#cc').calendar({
                current:new Date()
            });

            $('#cc').hide();

            $("#discussarea").hide();

            $(".discuss").click(function(){
                $("#discussarea").slideDown()
            })

            $("#discussdiv").hide()

            $(".setdiscuss").click(function(){
                document.getElementById("newp1").innerHTML = $("#discusstitle").val(),
                    document.getElementById("newp2").innerHTML = $("#discusscontent").val(),
                    $("#discussarea").slideToggle(300);
                $("#discussdiv").slideToggle(2000)
            })
            $("#newlistdiv").hide()

            $(".addlist1").click(function(){
                document.getElementById("newlisttitle").innerHTML = $("#listtitle").val(),
                    document.getElementById("newlistcontent").innerHTML = $("#listcontent").val(),
                    $("#d2").slideUp(300);
                $("#newlistdiv").slideDown(2000)
                $("#d1").slideDown(2000)
            })

            $(".canceldis").click(function(){
                $("#discussarea").slideToggle()
            })

            $(".videodisscuss").click(function(){
                alert("必须要升级到专业版哦~  50万/年!" )
            })

            $(".newfolder").hide()

            $(".addfolder").click(function(){
                $(".newfolder").fadeIn()
            })

            $("#win1").window({
                width:400,height:150, modal:true, minimizable:false,
                maximizable:false,collapsible:false,title:"将它移动到",resizable:false,
                closed:true
            })

            $("#move1").click(function(){
                $("#win1").window('open');
            })

            $("#movesure1").click(function(){
                $("#win1").window('close');
            })

            $("#movecancel1").click(function(){
                $("#win1").window('close');
            })

            $("#win2").window({
                width:400,height:150, modal:true, minimizable:false,
                maximizable:false,collapsible:false,title:"将它移动到",resizable:false,
                closed:true
            })

            $("#move2").click(function(){
                $("#win2").window('open');
            })

            $("#movesure2").click(function(){
                $('#win2').window('close');
            })

            $("#movecancel2").click(function(){
                $('#win2').window('close');
            })

            $("#win3").window({
                width:400,height:150, modal:true, minimizable:false,
                maximizable:false,collapsible:false,title:"将它移动到",resizable:false,
                closed:true
            })

            $("#move3").click(function(){
                $("#win3").window('open');
            })

            $("#movesure3").click(function(){
                $('#win3').window('close');
            })

            $("#movecancel3").click(function(){
                $('#win3').window('close');
            })

            $("#alert1").window({
                width:400,height:150, modal:true, minimizable:false,
                maximizable:false,collapsible:false,title:"确定要删除吗！？",resizable:false,
                closed:true
            })

            $("#delete1").click(function(){
                $("#alert1").window("open");
            })

            $("#deletesure1").click(function(){
                $("#alert1").window("close");
            })

            $("#deletecancel1").click(function(){
                $("#alert1").window("close");
            })

            $("#movesure1").click(function(){
                $("#file1").hide()
            })

            $("#movesure2").click(function(){
                $("#file2").hide()
            })

            $("#movesure3").click(function(){
                $("#file3").hide()
            })

            $("#deletesure1").click(function(){
                $("#file1").hide()
            })

            $("#alert2").window({
                width:400,height:150, modal:true, minimizable:false,
                maximizable:false,collapsible:false,title:"确定要删除吗！？",resizable:false,
                closed:true
            })

            $("#delete2").click(function(){
                $("#alert2").window("open");
            })

            $("#deletesure2").click(function(){
                $("#alert2").window("close");
            })

            $("#deletecancel2").click(function(){
                $("#alert2").window("close");
            })

            $("#deletesure2").click(function(){
                $("#file2").hide()
            })

            $("#alert3").window({
                width:400,height:150, modal:true, minimizable:false,
                maximizable:false,collapsible:false,title:"确定要删除吗！？",resizable:false,
                closed:true
            })

            $("#delete3").click(function(){
                $("#alert3").window("open");
            })

            $("#deletesure3").click(function(){
                $("#alert3").window("close");
            })

            $("#deletecancel3").click(function(){
                $("#alert3").window("close");
            })

            $("#deletesure3").click(function(){
                $("#file3").hide()
            })

            $("#newfolderdiv1").hide()


            $("#newfoldersure").click(function(){
                $("#newfolderdiv1").hide()
            })

            $("#newfoldercancel").click(function(){
                $("#newfolderdiv1").hide()
            })

            $("#newfoldersure").click(function(){
                document.getElementById("newfolderp1").innerHTML = $("#text1").val()
            })

            $("#newfolderdiv11").hide()

            $("#newfoldersure").click(function(){
                $("#newfolderdiv11").show()
            })

            $("#addfolder").click(function(){
                $("#newfolderdiv1").show()
            })

            $('#win11').window({
                width:300,height:200,minimizable:false,maximizable :false,
                collapsible:false,modal:true,title:"将它移动到",closed:true
            });

            $("#foldermove").click(function(){
                $('#win11').window("open")
            })

            $("#foldermovesure").click(function(){
                $("#win11").window("close")
            })

            $("#foldermovecancel").click(function(){
                $("#win11").window("close")
            })

            $('#alert11').window({
                width:300,height:200,minimizable:false,maximizable :false,
                collapsible:false,modal:true,title:"确定要删除吗！？",closed:true
            });

            $("#folderdelete").click(function(){
                $("#alert11").window("open")
            })

            $("#folderdeletesure").click(function(){
                $("#alert11").window("close")
                $("#newfolderdiv11").hide()
            })

            $("#folderdeletecancel").click(function(){
                $("#alert11").window("close")
            })

            $('#checkallfilewin').window({
                width:1400,height:650,modal:true,minimizable:false,maximizable:false,collapsible:false,
                border:false,shadow:true,resizable:false,title:" 所有文件",closed:true
            });

            $("#ckallfile").click(function(){
                $("#checkallfilewin").window("open")
            })

            $('#allfile').menubutton({
                menu: '#file_upload'
            });

            $("#checkallfilewin").blur(function(){
                alert("fsfs");
            })

            $("#file_movewin1").window({
                width:400,height:150, modal:true, minimizable:false,
                maximizable:false,collapsible:false,title:"将它移动到",resizable:false,closed:true
            })

            $("#file_move1").click(function(){
                $("#file_movewin1").window("open")
            })

            $("#file_movesure1").click(function(){
                $("#file_movewin1").window("close")
            })

            $("#file_movesure1").click(function(){
                $("#file_file1").hide()
            })


            $("#file_movecancel1").click(function(){
                $("#file_movewin1").window("close")
            })

            $("#file_deletewin1").window({
                width:400,height:150, modal:true, minimizable:false,
                maximizable:false,collapsible:false,title:"确定要删除吗！？",resizable:false,closed:true
            })

            $("#file_delete1").click(function(){
                $("#file_deletewin1").window("open")
            })

            $("#file_deletesure1").click(function(){
                $("#file_deletewin1").window("close")
            })

            $("#file_deletesure1").click(function(){
                $("#file_file1").hide()
            })

            $("#file_deletecancel1").click(function(){
                $("#file_deletewin1").window("close")
            })

            $("#file_movewin2").window({
                width:400,height:150, modal:true, minimizable:false,
                maximizable:false,collapsible:false,title:"将它移动到",resizable:false,closed:true
            })

            $("#file_move2").click(function(){
                $("#file_movewin2").window("open")
            })

            $("#file_movesure2").click(function(){
                $("#file_movewin2").window("close")
            })

            $("#file_movesure2").click(function(){
                $("#file_file2").hide()
            })


            $("#file_movecancel2").click(function(){
                $("#file_movewin2").window("close")
            })

            $("#file_deletewin2").window({
                width:400,height:150, modal:true, minimizable:false,
                maximizable:false,collapsible:false,title:"确定要删除吗！？",resizable:false,closed:true
            })

            $("#file_delete2").click(function(){
                $("#file_deletewin2").window("open")
            })

            $("#file_deletesure2").click(function(){
                $("#file_deletewin2").window("close")
            })

            $("#file_deletesure2").click(function(){
                $("#file_file2").hide()
            })

            $("#file_deletecancel2").click(function(){
                $("#file_deletewin2").window("close")
            })

            $("#file_hide1").hide()

            $("#file_file1").hover(function(){
                $("#file_hide1").toggle()
            })

            $("#file_hide2").hide()

            $("#file_file2").hover(function(){
                $("#file_hide2").toggle()
            })

            $("#file_file3").hide()

            $("#file_newfile").click(function(){
                $("#file_file3").show()
            })

            $("#file_hide3").hide()

            $("#file_file3").hover(function(){
                $("#file_hide3").toggle()
            })

            $('#file_otherswin').window({
                width:1400,height:650,modal:true,minimizable:false,maximizable:false,collapsible:false,
                border:false,shadow:true,resizable:false,title:"附件中心",closed:true
            });

            $("#file_others").click(function(){
                $("#file_otherswin").window("open")
            })

            $('#alldiscuss').window({
                width:1400,height:650,modal:true,minimizable:false,maximizable:false,collapsible:false,
                border:false,shadow:true,resizable:false,title:"所有讨论",closed:true
            })

            $('#alldiscuss_menu').menubutton({
                menu: '#alldiscuss_menubody'
            });

            $("#alldiscuss_discussarea").hide()

            $("#alldiscuss_discussclick").click(function(){
                $("#alldiscuss_discussarea").show(),
                    $("#alldiscuss_discussclick").hide()
            })

            $("#alldiscuss_hide").hide()

            $("#alldiscuss_discussset").click(function(){
                $("#alldiscuss_hide").show()
                document.getElementById("alldiscuss_p3").innerHTML = $("#alldiscuss_discusstitle").val()
                $("#alldiscuss_discussarea").hide()
                $("#alldiscuss_discussclick").show()
            })

            $("#alldiscuss_discusscancel").click(function(){
                $("#alldiscuss_discussarea").hide()
                $("#alldiscuss_discussclick").show()
            })

            $("#alldiscuss_div2").hide()

            $("#alldiscuss_p4").click(function(){
                alert("对不起，该讨论太陈旧了，找不到了哦~")
            })

            $("#alldiscuss_p4").click(function(){
                alert("对不起，该讨论太陈旧了，找不到了哦~")
            })

            $(".alldiscuss_ed").click(function(){
                $("#alldiscuss_div1").hide()
                $("#alldiscuss_div2").show()
            })

            $(".alldiscuss_ing").click(function(){
                $("#alldiscuss_div2").hide()
                $("#alldiscuss_div1").show()
            })

            $('#discussinfo1').window({
                width:1400,height:550,modal:true,minimizable:false,maximizable:false,collapsible:false,
                border:false,shadow:true,resizable:false,title:"讨论详情",closed:true
            })

            $("#discussinfo1_comsure1").click(function(){
                document.getElementById("disscussinfo1_p1").innerHTML = $("#discussinfo1_com1").val()
                $("#discussinfo1_new1").show()
            })

            $("#discussinfo1_new1").hide()

            $("#alldiscuss_p1").click(function(){
                $("#discussinfo1").window("open")
            })

            $('#discussinfo2').window({
                width:1400,height:550,modal:true,minimizable:false,maximizable:false,collapsible:false,
                border:false,shadow:true,resizable:false,title:"讨论详情",closed:true
            })

            $("#discussinfo2_comsure1").click(function(){
                document.getElementById("disscussinfo2_p1").innerHTML = $("#discussinfo2_com1").val()
                $("#discussinfo2_new1").show()
            })

            $("#discussinfo2_new1").hide()


            $("#alldiscuss_p2").click(function(){
                $("#discussinfo2").window("open")
            })

            $("#checkalldiscuss").click(function(){
                $("#alldiscuss").window("open")
            })

            $('#allschedule').window({
                width:1400,height:650,modal:true,minimizable:false,maximizable:false,collapsible:false,
                border:false,shadow:true,resizable:false,title:"所有日程",closed:true
            })

            $("#checkallschedule").click(function(){
                $('#allschedule').window("open")
            })

            $('#newschedule').window({
                width:1400,height:650,modal:true,minimizable:false,maximizable:false,collapsible:false,
                border:false,shadow:true,resizable:false,title:"创建日程",closed:true
            })

            $("#inschedule").click(function(){
                $('#newschedule').window("open")
            })

            $("#schedule_save").click(function(){
                $('#newschedule').window("close")
            })

            $("#schedule_cancel").click(function(){
                $('#newschedule').window("close")
            })

            $('#schedule_time1').datetimebox({
                value: '9/6/2017 19:58',
                required: true,
                showSeconds: false
            });

            $('#schedule_time2').datetimebox({
                value: '9/6/2017 19:58',
                required: true,
                showSeconds: false
            });

            $('#module').window({
                width:1420,height:650,modal:true,minimizable:false,maximizable:false,collapsible:false,
                border:false,shadow:true,resizable:false,title:"项目设置",closed:true
            })

            $("#inmodule").click(function(){
                $('#module').window("open")
            })

            $("#setting").click(function(){
                $('#module').window("open")
            })

            $('.jq22').dad();

            $("#module_a1").click(function(){
                $("#module_item1").slideToggle()
            })

            $("#module_a2").click(function(){
                $("#module_item2").slideToggle()
            })

            $("#module_a3").click(function(){
                $("#module_item3").slideToggle()
            })

            $("#module_a4").click(function(){
                $("#module_item4").slideToggle()
            })

            $("#module_a5").click(function(){
                $("#module_item5").slideToggle()
            })

            $('#member').window({
                width:1420,height:650,modal:true,minimizable:false,maximizable:false,collapsible:false,
                border:false,shadow:true,resizable:false,title:"项目成员",closed:true
            })

            $("#inmember").click(function(){
                $('#member').window("open")
            })

            $('#count').window({
                width:1420,height:650,modal:true,minimizable:false,maximizable:false,collapsible:false,
                border:false,shadow:true,resizable:false,title:"统计",closed:true
            })

            $("#incount").click(function(){
                $('#count').window("open")
            })

            $('#clicktask').window({
                width:1420,height:650,modal:true,minimizable:false,maximizable:false,collapsible:false,
                border:false,shadow:true,resizable:false,title:"任务",closed:true
            })

            $("#newspan").click(function(){
                $('#clicktask').window("open")
            })

            $("#newspan").click(function(){
                document.getElementById("taskinput_new").innerHTML = $("#taskinput").val();
            })

            $("#clicktask_explain").hide()

            $("#clicktask_inexplain").click(function(){
                $("#clicktask_hide").fadeToggle()
            })

            $("#clicktask_inexplain").click(function(){
                $("#clicktask_explain").slideDown(1000)
            })

            $("#clicktask_newexplain").hide()

            $("#clicktask_explainsure").click(function(){
                $("#clicktask_explain").slideUp()
                document.getElementById("clicktask_newexplain").innerHTML = $("#clicktask_explain1").val()
                $("#clicktask_newexplain").fadeToggle()
            })



            $("#clicktask_explaincancel").click(function(){
                $("#clicktask_explain").slideUp()
                $("#clicktask_hide").fadeToggle(1000)
            })

            $("#clicktask_com").hide()



            $("#clicktask_delete").hide()

            $("#clicktask_span").hover(function(){
                $("#clicktask_delete").toggle()
            })
            $("#clicktask_delete").click(function(){
                $("#clicktask_span").fadeOut()
            })

            $("#clicktask_comsure").click(function(){
                document.getElementById("clicktask_newcomcontent").innerHTML = $("#clicktask_comcontent").val()
                $("#clicktask_com").slideDown()
            })

            $('#rubbish').window({
                width:1300,height:650,modal:true,minimizable:false,maximizable:false,collapsible:false,
                border:false,shadow:true,resizable:false,title:"回收站",closed:true
            })

            $("#inrubbish").click(function(){
                $('#rubbish').window("open")
            })

            $("#recover1").hide()
            $("#recovera").hover(function(){
                $("#recover1").toggle()
            })

            $("#recover2").hide()
            $("#recoverb").hover(function(){
                $("#recover2").toggle()
            })

            $("#recover3").hide()
            $("#recoverc").hover(function(){
                $("#recover3").toggle()
            })

            $("#recover4").hide()
            $("#recoverd").hover(function(){
                $("#recover4").toggle()
            })

            $('#schedule').window({
                width:1300,height:650,modal:true,minimizable:false,maximizable:false,collapsible:false,
                border:false,shadow:true,resizable:false,title:"项目：晚会",closed:true
            })

            $("#schedule_com").hide()

            $("#schedule_comsure").click(function(){
                document.getElementById("schedule_newcomcontent").innerHTML = $("#schedule_comcontent").val()
                $("#schedule_com").show()
            })

            $("#schedule_delete").hide()

            $("#schedule_span").hover(function(){
                $("#schedule_delete").toggle()
            })

            $("#inschedule1").click(function(){
                $('#schedule').window("open")
            })

        })
    </script>
</head>
<body>
<div id="schedule">
    <div style="margin: 30px;">
        <img src="img/fzl.jpg" height="50px" />
        <span style="font-size: 20px;margin-left: 10px;">第一天日程:吃饭</span>
        <span style="color:grey;margin-left: 10px;">9月4日 - 9月28日</span>
        <p>提醒：<span style="color: grey;">提前一小时</span></p>
        <p>邀请：<span style="color: grey;">BF</span></p>
        <div class="menu-sep" style="margin-left: 0px;margin-bottom: 10px;"></div>

        <div id="schedule_com" >  <!--日程-新评论展示-->
            <span id="schedule_span">
					<img src="img/fzl.jpg" style="height: 30px;" />
					<a href="#">小明</a> <a style="color: black;" id="schedule_newcomcontent"></a>
					<a id="schedule_delete" style="color: grey; margin-left: 200px;" href="#">删除</a>
					</span>
        </div>
        <br>
        <div> <!--日程-编辑的评论框-->
            <img src="img/fzl.jpg" style="height: 30px;" />
            <textarea id="schedule_comcontent" placeholder="点击发表评论" style="height: 20px;width: 200px;resize: none;border-radius: calc(5px);"></textarea><br>
            <button id="schedule_comsure" style="background-color: lightgreen;">发表评论</button>
        </div>
    </div>
</div>

<div id="clicktask">  	<!--新任务点击弹窗-->
    <div style="margin: 30px;">
        <input  id="newbtn1" class="easyui-switchbutton" data-options="onText:'Finished',offText:'Unfinished'"
                style="width: 90px;">
        <a id="taskinput_new" style="color: black;font-weight: bolder;"></a>
        <span style="font-family: '微软雅黑';color: red;">将任务指派给：</span>
        <select class="easyui-combobox" name="state" style="width:120px;">
            <option>小BF</option>
            <option>大YG</option>
            <option>小鸡仔</option>
            <option>吊床boy</option>
            <option>庭阳</option>
            <option>大大豪</option>
        </select>
        <span style="font-family: '微软雅黑';color: red;">截止完成时间：</span>
        <input class="easyui-datetimebox" value="10/11/2012 2:3:56" style="width:200px">
        <br><br>
        <span id="clicktask_newexplain"></span>
        <span id="clicktask_hide">
				<span>添加</span><a id="clicktask_inexplain" href="#" style="color: purple;"><b>任务描述</b></a>
				</span></br><br>

        <div id="clicktask_explain">    <!--CLICKTASK里的添加任务说明下拉DIV-->
            <textarea id="clicktask_explain1" style="width: 500px;height: 200px;border-radius: calc(10px);border-width:3px ; resize: none;" placeholder="补充说明（可选）"></textarea></br>
            <button id="clicktask_explainsure" style="background-color: lightgreen;">保存修改</button>
            <button id="clicktask_explaincancel"style="background-color: #000000;color: pink;">取消</button>
        </div>
        <br>
        <div class="menu-sep" style="margin-left: 0px;"></div>

        <div id="clicktask_com" >  <!--新评论展示-->
            <span id="clicktask_span">
					<img src="img/fzl.jpg" style="height: 30px;" />
					<a href="#">小明</a> <a style="color: black;" id="clicktask_newcomcontent"></a>
					<a id="clicktask_delete" style="color: grey; margin-left: 200px;" href="#">删除</a>
					</span>
        </div>
        <br>
        <div> <!--编辑的评论框-->
            <img src="img/fzl.jpg" style="height: 30px;" />
            <textarea id="clicktask_comcontent" placeholder="点击发表评论" style="height: 20px;width: 200px;resize: none;border-radius: calc(5px);"></textarea><br>
            <button id="clicktask_comsure" style="background-color: lightgreen;">发表评论</button>
        </div>
        <br />
        <a style="color: lightskyblue;" href="#">关注</a>
        <a style="color: lightskyblue;" href="#">编辑</a>
        <a style="color: lightskyblue;" href="#">复制</a>
        <a style="color: lightskyblue;" href="#">移动</a>
        <a href="#">删除</a>
    </div>
</div>

<div id="rubbish">   <!--回收站 垃圾桶-->
    <div style="margin: 30px;">
        <h2>回收站</h2>
        <p style="color: grey;">项目中被删除的任务、讨论、文件和附件都能在这里找到并恢复。</p><br>
        <div class="menu-sep" style="margin-left: 0px;"></div>
        <span style="font-size: 30px;color: grey;">09/08</span>
        <span style="margin-right: 20px;">周五</span>
        <span style="color: lightskyblue;">09:11</span>
        <span style="font-weight: bolder;">小明</span>
        <span>删除了：</span>
        <span id="recovera">
					<a  href="#" style="font-weight: bolder;">晚会</a>
					<a id="recover1" href="#" style="font-weight: bolder;color: grey;margin-left: 50px;">恢复</a>
					</span>
        <br>
        <div class="menu-sep" style="margin-left: 0px;"></div>
        <span style="font-size: 30px;color: grey;">09/08</span>
        <span style="margin-right: 20px;">周五</span>
        <span style="color: lightskyblue;">08:01</span>
        <span style="font-weight: bolder;">小娜</span>
        <span>删除了：</span>
        <span id="recoverb">
					<a  href="#" style="font-weight: bolder;">今晚吃啥</a>
					<a id="recover2" href="#" style="font-weight: bolder;color: grey;margin-left: 50px;">恢复</a>
					</span>
        <br>
        <div class="menu-sep" style="margin-left: 0px;"></div>
        <span style="font-size: 30px;color: grey;">09/07</span>
        <span style="margin-right: 20px;">周四</span>
        <span style="color: lightskyblue;">19:16</span>
        <span style="font-weight: bolder;">小明</span>
        <span>删除了：</span>
        <span id="recoverc" >
					<a href="#" style="font-weight: bolder;">晚会前期准备的问题</a>
					<a id="recover3" href="#" style="font-weight: bolder;color: grey;margin-left: 50px;">恢复</a>
					</span>
        <br>
        <div class="menu-sep" style="margin-left: 0px;"></div>
        <span style="font-size: 30px;color: grey;">09/06</span>
        <span style="margin-right: 20px;">周三</span>
        <span style="color: lightskyblue;">20:41</span>
        <span style="font-weight: bolder;">小明</span>
        <span>删除了：</span>
        <span id="recoverd">
					<a href="#" style="font-weight: bolder;">AJAX的优化问题</a>
					<a id="recover4" href="#" style="font-weight: bolder;color: grey;margin-left: 50px;">恢复</a>
					</span>
        <br>

    </div>
</div>

<div id="count"><!--待处理任务（统计）-->
    <div style="margin: 30px;">
        <div id="count_a">
            <div id="count_a1" >待处理任务(10)</div>
            <div id="count_a2"
                 style="cursor:pointer;
						 onclick="location.href='#'>延误的任务(20)</div>
            <div id="count_a3">总共任务数(12)</div>
        </div>

        <h2>进展</h2>
        <div class="menu-sep" style="margin-left: 0px;margin-top: 15px;margin-bottom: 15px;"></div>
        <span>晚会后期准备   </span>
        <button style="width: 300px;height: 20px;background-color: gpalegreen;border-radius: calc(5px);"></button>
        <span style="color: grey;">0/1</span>
        <div class="menu-sep" style="margin-left: 0px;margin-top: 15px;margin-bottom: 15px;"></div>

        <span>晚会前期准备   </span>
        <button style="width: 300px;height: 20px;background-color: mediumspringgreen;border-radius: calc(5px);"></button>
        <span style="color: grey;">1/1</span>
        <div class="menu-sep" style="margin-left: 0px;margin-top: 15px;margin-bottom: 15px;"></div>

        <span>晚会灯光问题   </span>
        <button style="width: 300px;height: 20px;background-color: mediumspringgreen;border-radius: calc(5px);"></button>
        <span style="color: grey;">1/1</span>
        <div class="menu-sep" style="margin-left: 0px;margin-top: 15px;margin-bottom: 15px;"></div>

        <span>晚会赞助商   </span>
        <button style="width: 300px;height: 20px;background-color: gpalegreen;border-radius: calc(5px);"></button>
        <span style="color: grey;">0/1</span>
        <div class="menu-sep" style="margin-left: 0px;margin-top: 15px;margin-bottom: 15px;"></div>

        <span>晚会主持人   </span>
        <button style="width: 300px;height: 20px;background-color: mediumspringgreen;border-radius: calc(5px);"></button>
        <span style="color: grey;">1/1</span>
        <div class="menu-sep" style="margin-left: 0px;margin-top: 15px;margin-bottom: 15px;"></div>

        <span>晚会操机   </span>
        <button style="width: 300px;height: 20px;background-color: gpalegreen;border-radius: calc(5px);"></button>
        <span style="color: grey;">0/1</span>
        <div class="menu-sep" style="margin-left: 0px;margin-top: 15px;margin-bottom: 15px;"></div>

        <br>
        <h2>贡献</h2>
        <p style="color: grey;">截至目前，共有 2 位成员对项目做出了贡献，产生 3 条讨论，上传 3 个文件。</p>
        <div class="menu-sep" style="margin-left: 0px;margin-top: 15px;margin-bottom: 15px;"></div>
        <img src="img/fzl.jpg" style="height: 30px;" /><span style="font-size: 15px;">小明   </span><button title="小明完成了5条任务" style="width: 100px;height: 20px;background-color: mediumseagreen;border-radius: calc(5px);">5</button>
        <div class="menu-sep" style="margin-left: 0px;margin-top: 15px;margin-bottom: 15px;"></div>
        <img src="img/fzl2.jpg" style="height: 30px;" /><span style="font-size: 15px;">小娜   </span><button title="小娜完成了2条任务" style=" width: 40px;height: 20px;background-color: mediumseagreen;border-radius: calc(5px);">2</button>

    </div>
</div>

<div id="member">  <!--成员(0)-->
    <div style="margin: 30px;">
        <span style="font-size: 20px;"><b>项目成员</b></span>
        <button style="border-radius: calc(3px);margin-left: 10px;">编辑</button>
        <a href="#" style="float: right;">退出项目</a>
        <br/><br/>
        <div style="display: inline;">
            <button style="background-color: white;height: 90px;"><img  src="img/fzl.jpg" style="height: 50px;"/><p>小明</p><p style="color: gray;">管理员</p></button>
        </div>
        <div style="display: inline;" >
            <button style="background-color: white;height: 90px;"><img  src="img/fzl2.jpg" style="height: 50px;"/><p>小娜</p><p style="color: gray;">管理员</p></button>
        </div>

    </div>
</div>

<div style="width: 1000px;border: solid;border-color: deeppink;">
    <div>  	<!--项目设置第一行-->
        <span style="color: pink;">项目名</span>
        <p style="color: pink;">项目描述</p>
        <p style=" text-align: right;margin-top: -50px;"> <a id="incount" href="#">待处理任务（10）</a> </span
            <span> | </span>
            <span> <a id="inmember" href="#">成员（2）</a> </span
            <span> | </span>
            <span> <a id="setting" href="#">设置</a> </span>
        </p>
        <div class="menu-sep" style="width: 1000px; margin-top: 30px;margin-left: 0px;"></div>
    </div>

    <div>   <!--项目设置：任务-->

        <span style="color: lightgreen;">任务</span>

        <span>
		<a href="javascript:void(0)" class="easyui-menubutton addtask"
           data-options="menu:'#task'" style="color:red;">添加任务 </a>
		<div id="task" style="width:300px;">
   		<div class="addtask">添加任务</div>
   		<div class="addlist">添加清单</div>
		</div>
			</span>

        <p style="text-align: right;margin-top: 10px;margin-left: 300px;" >
            <!--	<a href="#">a</a>
                <a href="#">b</a>
                <a href="#">c</a>-->
        </p>

        <div id="newlistdiv">  <!--新增清单P-->
            <p id="newlisttitle" style="margin: 10px;font-size: 30px;color: darkblue;font-weight: bold">qqq</p>
            <div class="menu-sep" style="width: 1000px; margin-top: 0px;margin-left: 0px;"></div>
            <p id="newlistcontent" style="margin: 10px;color: grey;">fff</p>
        </div>

        <!-- 最原始新添加的任务DIV -->
        <div id="newdiv">
				<span> <input  id="btnnew" class="easyui-switchbutton" data-options="onText:'Finished',offText:'Unfinished'"
                               style="width: 90px;">
				</span>
            <a href="#" id="newspan" style="color: black;"></a>
        </div>



        <div id="d2">
            <textarea id="listtitle" style="width: 500px;height: 20px;border: none;resize: none;"placeholder="输入清单名称"></textarea></br>
            <div class="menu-sep" style="margin-left: 0px;width: 500px;"></div>
            <textarea id="listcontent" style="width: 500px;height: 20px;border: none;resize: none;" placeholder="补充说明（可选）"></textarea></br>
            <button class="addlist1" style="background-color: lightgreen;">保存，开始添加任务！</button>
            <button class="cancellist"style="background-color: #000000;color: pink;">取消</button>
        </div>

        <div id="d1">
            <input  id="btn1" class="easyui-switchbutton" data-options="onText:'Finished',offText:'Unfinished'"
                    style="width: 90px;">
            <input id="taskinput" value="任务描述" style="color: grey;"
                   onFocus="if(value==defaultValue){value='';}"
                   onblur="if(value==''){value=defaultValue}"
            />
            <span style="font-family: '微软雅黑';color: red;">将任务指派给：</span>
            <select class="easyui-combobox" name="state" style="width:120px;">
                <option>小BF</option>
                <option>大YG</option>
                <option>小鸡仔</option>
                <option>吊床boy</option>
                <option>庭阳</option>
                <option>大大豪</option>
            </select>
            <span style="font-family: '微软雅黑';color: red;">截止完成时间：</span>
            <input class="easyui-datetimebox" value="10/11/2012 2:3:56" style="width:200px">
            <div>
                <button id="addtask11" style="background-color: lightgreen;">添加任务</button>
                <button class="canceltask"style="background-color: #000000;color: pink;">取消</button>
            </div>
        </div>
        <br>
    </div>

    <div>   <!---项目设置：讨论--->
        <div class="menu-sep" style="width: 1000px; margin-top: -20px;margin-left: 0px;"></div>
        <span style="color: lightgreen;">讨论</span>

        <a href="javascript:void(0)" class="easyui-menubutton discuss"
           data-options="menu:'#discuss'" style="color:red;">发起讨论 </a>
        <div id="discuss" style="width:150px;">
            <div class="discuss">发起讨论</div>
            <div class="videodisscuss">发起视频讨论（Pro）</div> </div>
        <br>

        <div id="discussdiv">  <!--新增讨论P-->
            <p id="newp1" style="margin: 10px;font-size: 30px;font-weight: bold"><b></b></p>
            <div class="menu-sep" style="width: 1000px; margin-top: 0px;margin-left: 0px;"></div>
            <p id="newp2" style="margin: 10px;color: grey;"></p>
        </div>
        <div id="discussarea">
   		<textarea id="discusstitle" name="editor" placeholder="话题"
                  style="width: 800px;height:20px;resize: none;";"></textarea></br>
            <textarea id="discusscontent" name="editor" placeholder="说点什么..."
                      style="height: 200px;width: 800px;resize: none;"></textarea></br>
            <button class="setdiscuss" style="background-color: lightgreen;">发起讨论</button>
            <button class="canceldis" style="background-color: #000000;color: pink;">取消</button>
        </div>
        <a id="checkalldiscuss" href="#" style="color: deepskyblue;">查看全部讨论</a>
    </div>

    <!--所有讨论-->
    <div id="alldiscuss">
        <div style="margin-left: 10px;" >
            <a href="javascript:void(0)" id="alldiscuss_menu">选择讨论类型</a>
            <div id="alldiscuss_menubody" style="width:150px">
                <div class="alldiscuss_ing">正在进行的讨论</div>
                <div class="alldiscuss_ed">已经结束的讨论</div>
            </div>

            <div id="alldiscuss_div1">
                <div>  <!--点击此处发起讨论-->
                    <textarea id="alldiscuss_discussclick" placeholder="点击此处发起讨论"style="width: 800px;height:20px;resize: none;";"></textarea>
                </div>

                <div id="alldiscuss_discussarea">
                    <textarea id="alldiscuss_discusstitle" placeholder="话题"style="width: 800px;height:20px;resize: none;";"></textarea></br>
                    <textarea id="alldiscuss_discusscontent" placeholder="说点什么..."
                              style="height: 200px;width: 800px;resize: none;"></textarea></br>
                    <button id="alldiscuss_discussset" style="background-color: lightgreen;">发起讨论</button>
                    <button id="alldiscuss_discusscancel" style="background-color: #000000;color: pink;">取消</button>
                </div>

                <br><br>
                <!--这个是新添加的讨论-->
                <div id="alldiscuss_hide">
                    <p><img style="height: 30px;width: 30px;" src="img/fzl.jpg"/>
                        小明
                        <a href="#" id="alldiscuss_p3" style="font-weight: bold;"></a>

                    <p style="float: right;margin-top: -40px;margin-right: 10px;">刚刚</p>
                    </p>
                </div>
                <div class="menu-sep" style="margin-left: 0px;"></div>

                <p><img style="height: 30px;width: 30px;" src="img/fzl.jpg"/>
                    小明
                    <a href="#" id="alldiscuss_p1" style="font-weight: bold;">今晚开黑怎么样呀！！！！</a>
                <p style="float: right;margin-top: -40px;margin-right: 10px;">5小时前</p>
                </p>
                <div class="menu-sep" style="margin-left: 0px;"></div>
                <p><img style="height: 30px;width: 30px;"src="img/fzl2.jpg"/>
                    小红
                    <a href="#" id="alldiscuss_p2" style="font-weight: bold;">你们觉得新来的老板咋样??</a>
                <p style="float: right;margin-top: -40px;margin-right: 10px;">16小时前</p>
                </p>

            </div>

            <div id="alldiscuss_div2"> <!--点击此处发起讨论-->
                <p><img style="height: 30px;width: 30px;" src="img/fzl.jpg"/>
                    小明
                    <a href="#" id="alldiscuss_p4" style="font-weight: bold;">明天愚人节如何捉弄人！？</a>
                <p style="float: right;margin-top: -40px;margin-right: 10px;">6年5个月前</p>
                </p>
                <div class="menu-sep" style="margin-left: 0px;"></div>
                <p><img style="height: 30px;width: 30px;"src="img/fzl2.jpg"/>
                    小红
                    <a href="#" id="alldiscuss_p5" style="font-weight: bold;">我们公司未来十年要如何发展呢？</a>
                <p style="float: right;margin-top: -40px;margin-right: 10px;">16年前</p>
                </p>
            </div>

            <div id="discussinfo1">
                <div id="dis1"> <!--第一个讨论今晚开黑-->
                    <h1 href="#" style="font-weight: bold;">今晚开黑怎么样呀！！！！</h1>
                    <a href="#">关注</a>
                    <a href="#">编辑</a>
                    <a href="#">移动</a>
                    <a href="#">删除</a>
                    <p id="discussinfo1_new1">
                        <img style="height: 30px;width: 30px;" src="img/fzl.jpg"/>
                        小明  <span style="color: gray;">刚刚</span>
                        <a id="disscussinfo1_p1" style="color: black;"></a>
                    </p>
                    <div class="menu-sep" style="margin-left: 0px;"></div>
                    <div style="margin-top: 10px;">  <!--点击此处评论-->
                        <p>
                            <img style="height: 30px;width: 30px;" src="img/fzl.jpg"/>
                            小明  <span style="color: gray;">5小时前</span>
                            <a style="color: black;">好呀！！！！</a>
                        </p>
                        <div class="menu-sep" style="margin-left: 0px;"></div>
                        <textarea id="discussinfo1_com1" placeholder="点击此处评论"style="width: 800px;height:20px;resize: none;";"></textarea><br>
                        <button id="discussinfo1_comsure1" style="background-color: lightgreen" >发表评论</button>
                    </div>
                </div>
            </div>

            <div id="discussinfo2">
                <div id="dis1"> <!--你们觉得新老板咋样-->
                    <h1 href="#" style="font-weight: bold;">你们觉得新老板咋样呀！</h1>
                    <a href="#">关注</a>
                    <a href="#">编辑</a>
                    <a href="#">移动</a>
                    <a href="#">删除</a>
                    <p id="discussinfo2_new1">
                        <img style="height: 30px;width: 30px;" src="img/fzl.jpg"/>
                        小明  <span style="color: gray;">刚刚</span>
                        <a id="disscussinfo2_p1" style="color: black;"></a>
                    </p>
                    <div class="menu-sep" style="margin-left: 0px;"></div>
                    <div style="margin-top: 10px;">  <!--点击此处评论-->
                        <p>
                            <img style="height: 30px;width: 30px;" src="img/fzl.jpg"/>
                            小明  <span style="color: gray;">5小时前</span>
                            <a style="color: black;">好凶哦</a>
                        </p>
                        <div class="menu-sep" style="margin-left: 0px;"></div>
                        <textarea id="discussinfo2_com1" placeholder="点击此处评论"style="width: 800px;height:20px;resize: none;";"></textarea><br>
                        <button id="discussinfo2_comsure1" style="background-color: lightgreen" >发表评论</button>
                    </div>
                </div>
            </div>

        </div>
    </div>

    <br><br><br>
    <div>   <!---项目设置：文件--->

        <div class="menu-sep" style="width: 1000px; margin-top: -50px;margin-left: 0px;"></div>
        <span style="color: lightgreen;">文件</span>
        <a href="javascript:void(0)" class="easyui-menubutton uploadfile"
           data-options="menu:'#file'" style="color:red;">上传文件 </a>
        <div id="file" style="width:150px;">
            <div class="uploadfile">上传文件</div>
            <div class="addfolder">创建文件夹</div> </div>
        </span>
        <p style="text-align: right;margin-top: -10px;">
            <!--<a href="#">a</a>
            <a href="#">b</a>
            <a href="#">c</a>-->
        </p>

        <br><br>
        <div style="float: left;text-align: center;margin-top: -40px;" id="file1">
            <button style="height: 50px;width: 100px;">参考资料</button>
            </br><a href="#">下载</a> <a href="#" id="move1">移动</a> <a href="#" id="delete1">删除</a>
            </a>
        </div>

        <div style="float: left;text-align: center;margin-left: 30px;margin-top: -40px;" id="file2">
            <button style="height: 50px;width: 100px;margin-left: 0px;">设计图</button>
            </br>	<a href="#">下载</a> <a href="#" id="move2">移动</a> <a href="#" id="delete2">删除</a>
            </a>
        </div>

        <div style="float: left;text-align: center;margin-left: 30px;margin-top: -40px;" id="file3">
            <button style="height: 50px;width: 100px;margin-left: 0px;">需求文档</button>
            </br><a href="#">下载</a> <a href="#" id="move3">移动</a> <a href="#" id="delete3">删除</a>
            </a>
        </div>

        <div class="newfolder" style="float: left;text-align: center;margin-left: 30px;margin-top: -40px;">
            <button style="height: 50px;width: 100px;margin-left: 0px;">新建的文件夹</button>
            </br><a href="#">下载</a> <a href="#" id="move4">移动</a> <a href="#" id="delete4">删除</a>
            </a>
        </div>
        </br></br></br></br></br></br>
        <div style="margin-top: -70px;">
            <a id="ckallfile" href="#" style="color: cornflowerblue;">查看全部文件</a></br>
            <a id="file_others" href="#" style="color: cornflowerblue;">附件中心</a>
        </div>

        <div id="win1">
            <br>
            <a href="#">设计图</a></br></br>
            <a href="#">需求文档</a></br></br>
            <button id="movesure1" style="background-color: lightgreen" >移动</button>
            <button id="movecancel1">取消</button>
        </div>

        <div id="win2">
            <br>
            <a href="#">参考资料</a></br></br>
            <a href="#">需求文档</a></br></br>
            <button id="movesure2" style="background-color: lightgreen" >移动</button>
            <button id="movecancel2">取消</button>
        </div>

        <div id="win3">
            <br>
            <a href="#">参考资料</a></br></br>
            <a href="#">设计图</a></br></br>
            <button id="movesure3" style="background-color: lightgreen" >移动</button>
            <button id="movecancel3">取消</button>
        </div>

        <div id="alert1">
            <br>
            <p>注意：文件夹和里面的文件将一同被删除。请谨慎操作！</p>
            <button id="deletesure1" style="background-color: lightgreen" >确定</button>
            <button id="deletecancel1">取消</button>
        </div>

        <div id="alert2">
            <br>
            <p>注意：文件夹和里面的文件将一同被删除。请谨慎操作！</p>
            <button id="deletesure2" style="background-color: lightgreen" >确定</button>
            <button id="deletecancel2">取消</button>
        </div>

        <div id="alert3">
            <br>
            <p>注意：文件夹和里面的文件将一同被删除。请谨慎操作！</p>
            <button id="deletesure3" style="background-color: lightgreen" >确定</button>
            <button id="deletecancel3">取消</button>
        </div>


        <!--文件-所有文件-->
        <div id="checkallfilewin"> <!--大win框 所有文件-->
            <span>文件</span>
            <a href="javascript:void(0)" id="allfile"
               class="easyui-menubutton allfile" data-options="menu:'#file_upload'">文件上传</a>
            <div id="file_upload" style="width:150px">
                <div>上传文件</div>
                <div id="file_newfile">创建文件夹</div>
            </div>
            <br><br>

            <div style="float:left" id="file_file1">
                <button style="height: 70px;width: 100px;margin-left: 20px;">需求文档</button>
                <br>
                <span id="file_hide1">
					<a href="#" style="margin-left: 20px;">下载</a>
					<a href="#" id="file_move1" style=" margin-left: 10px;">移动</a>
					<a href="#" id="file_delete1" style=" margin-left: 10px;">删除</a>
					</span>
            </div>
            <div style="float:left" id="file_file2">
                <button style="height: 70px;width: 100px;margin-left: 20px;">设计图</button>
                <br>
                <span id="file_hide2">
					<a href="#" style="margin-left: 20px;">下载</a>
					<a href="#" id="file_move2" style="margin-left: 10px;">移动</a>
					<a href="#" id="file_delete2" style="margin-left: 10px;">删除</a>
					</span>
            </div>

            <div style="float:left" id="file_file3">
                <button style="height: 70px;width: 100px;margin-left: 20px;">新建文件夹</button>
                <br>
                <span id="file_hide3">
					<a href="#" style="margin-left: 20px;">下载</a>
					<a href="#" id="file_move3" style=" margin-left: 10px;">移动</a>
					<a href="#" id="file_delete3" style=" margin-left: 10px;">删除</a>
					</span>

            </div>

            <div id="file_movewin1">
                </br>
                <select class="easyui-combobox">
                    <option>设计图</option>
                </select>
                </br></br></br></br></br>
                <button id="file_movesure1" style="background-color: lightgreen">移动</button>
                <button id="file_movecancel1">取消</button>
            </div>

            <div id="file_deletewin1">
                <br>
                <p>注意：文件夹和里面的文件将一同被删除。请谨慎操作！</p>
                <button id="file_deletesure1" style="background-color: lightgreen" >确定</button>
                <button id="file_deletecancel1">取消</button>
            </div>

            <div id="file_movewin2">
                </br>
                <select class="easyui-combobox">
                    <option>需求文档</option>
                </select>
                </br></br></br></br></br>
                <button id="file_movesure2" style="background-color: lightgreen">移动</button>
                <button id="file_movecancel2">取消</button>
            </div>

            <div id="file_deletewin2">
                <br>
                <p>注意：文件夹和里面的文件将一同被删除。请谨慎操作！</p>
                <button id="file_deletesure2" style="background-color: lightgreen" >确定</button>
                <button id="file_deletecancel2">取消</button>
            </div>

        </div>

        <div id="file_otherswin"> <!--大win框 附件中心-->
            <div style="margin-left: 10px;">
                <h1>附件中心</h1>
                <p style="color: gray;">项目中的所有附件，会按上传的先后顺序显示在这里，方便集中查看和整理到文件夹。</p>
                <span >按类型筛选：</span>
                <select class="easyui-combobox" >
                    <option>所有类型</option>
                    <option>图片</option>
                    <option>多媒体</option>
                    <option>Ofiice</option>
                    <option>文档</option>
                    <option>其他</option>
                </select>
                <button class="icon-search" id="file_others_search" style="height: 25px;width: 25px;float: left;"></button>
                <textarea id="text1" placeholder="按文件名或标签搜索" style="resize:none;height: 20px;float:left;"></textarea>
            </div>
        </div>

    </div>
    <br>

    <div>   <!--项目设置：文档-->
        <div class="menu-sep" style="width: 1000px; margin-top: 30px;margin-left: 0px;margin-top: -10px;"></div>
        <span style="color: lightgreen;">文档</span>
        <a href="javascript:void(0)" class="easyui-menubutton folder"
           data-options="menu:'#folder'" style="color:red;">创建文档 </a>
        <div id="folder" style="width:150px;">
            <div class="folder">普通文档</div>
            <div class="mkfolder">Markdown文档</div>
            <div class="menu-sep"></div>
            <div id="addfolder">创建文档夹</div>
        </div>
        <br><br>

        <div id="newfolderdiv1">
            <textarea id="text1" placeholder="创建文件名为" style="resize:none;height: 25px;"></textarea><br>
            <button id="newfoldersure" style="background-color: lightgreen">创建</button>
            <button id="newfoldercancel">取消</button>
        </div>

        <div id="newfolderdiv11" style="background-color: yellowgreen;height: 150px;width: 150px;">
            <p id="newfolderp1" style="margin-left: 60px;"></p>
            <br><br><br><br><br><br>
            <a href="#">查看</a>
            <a href="#" id="foldermove">移动</a>
            <a href="#" id="folderdelete">删除</a>
        </div>

        <div id="win11">
            </br>
            <select class="easyui-combobox">
                <option>晚会</option>
                <option>熟悉Power</option>
            </select>
            </br></br></br></br></br>
            <button id="foldermovesure" style="background-color: lightgreen">移动</button>
            <button id="foldermovecancel">取消</button>
        </div>

        <div id="alert11">
            <br>
            <p>注意：文件夹和里面的文件将一同被删除。请谨慎操作！</p>
            <button id="folderdeletesure" style="background-color: lightgreen" >确定</button>
            <button id="folderdeletecancel">取消</button>
        </div>

    </div>

    <div>   <!--项目设置：日程-->

        <div id="newschedule">  <!--创建日程WIN-->
            <div style="margin: 30px;">

                <textarea placeholder="在这里输入日程内容" style="resize: none;height: 20px;width: 400px;margin-bottom: 20px;"></textarea>				<tr>
                <br>

                <span class="schedulespan">开始:</span>
                <input id="schedule_time1" type="text" style="width: 150px;"></input>
                <br><br>

                <span class="schedulespan">结束:</span>
                <input id="schedule_time2" type="text"  style="width: 150px;"></input>
                <br><br>

                <span class="schedulespan">重复:</span>
                <select class="easyui-combobox">
                    <option>不重复</option>
                    <option>每日</option>
                    <option>每周</option>
                    <option>每月</option>
                    <option>每年</option>
                    <option>隔周</option>
                </select>
                <br><br>

                <span class="schedulespan">提醒:</span>
                <select class="easyui-combobox">
                    <option>不提醒</option>
                    <option>提前一小时</option>
                    <option>提前一天</option>
                    <option>提前一周</option>
                </select>
                <br><br>

                <span class="schedulespan">地点:</span>
                <input />
                <br><br>

                <button id="schedule_save" style="background-color: lightgreen;">创建</button>
                <button id="schedule_cancel"style="background-color: #000000;color: pink;">取消</button>

            </div>
        </div>

        </br></br>
        <div class="menu-sep" style="width: 1000px; margin-top: -30px;margin-left: 0px;margin-top: -10px;"></div>
        </br>
        <a href="#">日程</a> <button id="inschedule" >创建日程</button>
        </br></br>
        <span>9月4日~9月5日</span> <a id="inschedule1" href="#">第一天日程：吃饭</a>
        <br>
        <p>参与人：YG、BF、V</p>
        <div class="menu-sep"style="width: 1000px; margin-top: -30px;margin-left: 0px;margin-top: -10px;"></div>

        </br>

        <a id="checkallschedule" href="#" style="color: cornflowerblue;">查看全部日程</a>
        </br></br>
        <div class="menu-sep" style="width: 1000px; margin-top: 30px;margin-left: 0px;margin-top: -10px;"></div>
        </br>
        <a id="inmodule" href="#">模块设置</a>
        <p style="text-align: right;margin-top: -20px;margin-right: 10px;">
            <button id="inrubbish" class="icon-cancel " style="height: 20px;width: 20px;"></button>
        </p>

        <div id="allschedule">
            <div style="margin:30px ;">
                <button >创建日程</button>
                <p style="text-align: center;font-size: large;font-weight: 600;margin-top: -15px;display: inline;">2017 九月</p>
                <button><</button><button>></button>
                <br><br><br>
                <p>9月4日 - 9月28日</p>
                <a href="#">第一天行程:吃饭</a>
                <p style="color: grey;">参与人：BF、庭阳等</p>
                <div class="menu-sep" style="margin-left: 0px;"></div>
            </div>
        </div>

        <div id="module">
            <div style="margin: 30px;">
                <textarea style="resize: none;height: 20px;width: 300px;border-radius: calc(5px);">晚会标题</textarea><br>
                <textarea style="width: 300px;resize: none;height: 150px;border-radius: calc(5px)">晚会内容</textarea>
                <h1>项目类型</h1>
                <form>
                    <label>
                        <input type="radio" name="btn"  />
                        标准项目
                    </label>
                    <span style="color: grey;">更好的组织、细分和管理任务，适用于一般项目管理</span>
                    <br>
                    <label>
                        <input type="radio" name="btn" />
                        看板项目
                    </label>
                    <span style="color: grey;">擅长处理流程化任务，适用于产品研发，用户支持等场景</span>
                </form>
                <button class="module_save" style="background-color: lightgreen;margin-top: 20px;">保存设置</button>
                <br><br>
                <div class="menu-sep" style="margin-left: 0px;"></div>
                <h1>调整项目模块</h1>
                <p style="color: gray;">你可以拖动模块调整位置，隐藏的模块可随时恢复	</p>

                <div>    <!--拖动模块DIV-->
                    <div class="jq22" style="margin-left: 20px;">
                        <div id="module_item1" class="module_item module_item1"><span>日程</span></div>
                        <div id="module_item2" class="module_item module_item2"><span>任务</span></div>
                        <div id="module_item3" class="module_item module_item3"><span>文档</span></div>
                        <div id="module_item4" class="module_item module_item4"><span>讨论</span></div>
                        <div id="module_item5" class="module_item module_item5"><span>文件</span></div>
                    </div>
                    <label>
                        <p>选择需要隐藏的模块</p>
                        <input id="module_a1" type="checkbox" />日程<br>
                        <input id="module_a2" type="checkbox" />任务<br>
                        <input id="module_a3" type="checkbox" />文档<br>
                        <input  id="module_a4"type="checkbox" />讨论<br>
                        <input id="module_a5" type="checkbox" />文件<br>
                    </label>
                    <br />
                    <span style="color: grey;">*讨论模块最近显示</span>
                    <select class="easyui-combobox">
                        <option>5条</option>
                        <option>10条</option>
                        <option>20条</option>
                    </select>
                    <br>
                    <h1>归档项目</h1>
                    <p style="color: grey;">项目归档后，所有的内容将变为只读，不能再修改。你只能通过激活操作，将项目重新恢复正常。</p>
                    <button>了解，归档这个项目</button>

                    <h1>删除项目</h1>
                    <p style="color: grey;">项目删除后，所有的内容也将被立刻删除，不能恢复。请谨慎操作。</p>
                    <button>了解，删除这个任务</button>
                </div>

            </div>
        </div>




    </div>
</body>
</html>

