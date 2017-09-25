<%@ page import="java.util.List" %>
<%@ page import="com.pojo.File" %>
<%@ page import="com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList" %><%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2017/8/31
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看文件列表</title>
    <script type="text/javascript">

    </script>
</head>
<body>
<%
    List<File> list = (List<File>) request.getSession().getAttribute("fileList");
    for(int i=0;i<list.size();i++)
    {
        out.println(list.get(i).getFileName());%>
<input type="button" value="下载" onclick="javascript:window.location='/file/downloadfile?fileid=<%= list.get(i).getFileId() %>'" />
<%
    }
%>
</body>
</html>
