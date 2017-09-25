<%--
  Created by IntelliJ IDEA.
  User: WU
  Date: 2017/9/4
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>显示评论</title>
</head>
<body>
<div>
   <c:forEach items="${commentList}" var="comment">
       <%--没有被回复的评论--%>
        <c:if test="${comment.buId==0}">
            <div id="${comment.cId}">
                <div id="${comment.uId}">
                    <c:if test="${comment.uId==1}">
                        <a href="/Comment/selectCommentByID?cid=${comment.cId}" ><button>修改</button></a>
                        <a href="/Comment/deleteComment?cid=${comment.cId}"><button>删除</button></a>
                    </c:if>
                    ${comment.uName}评论：<br>
                    <div>
                        <p>回复于：<fmt:formatDate
                                type="date"
                                value="${comment.cTime}"
                                pattern="yyyy-MM-dd HH:mm:ss"/>
                        </p>
                        <p>${comment.cContent}</p>
                    </div>
                    <button value="回复">回复</button>
                </div>
            </div>
            <br>
            <br>
        </c:if>
       <%--有被回复的评论--%>
       <c:if test="${comment.buId!=0}">
           <div id="${comment.cId}">
               <div id="${comment.uId}">
                   <%--判断是否是自己的写的评论  那个1是从session中取出来用户的ID--%>
                   <c:if test="${comment.uId==1}">
                       <a href="/Comment/selectCommentByID?cid=${comment.cId}" ><button>修改</button></a>
                       <a href="/Comment/deleteComment?cid=${comment.cId}"><button>删除</button></a>
                   </c:if>
                   ${comment.uName}评论 ${comment.buUsername}<br>
                   <div>
                       <p>回复于：<fmt:formatDate
                               type="date"
                               value="${comment.cTime}"
                               pattern="yyyy-MM-dd HH:mm:ss"/>
                       </p>
                       <p>${comment.cContent}</p>
                   </div>
                       <button value="回复">回复</button>
               </div>
           </div>
           <br>
           <br>
       </c:if>
   </c:forEach>
</div>
</body>
</html>
