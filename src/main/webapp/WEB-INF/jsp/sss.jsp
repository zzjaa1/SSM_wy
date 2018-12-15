<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2018/12/2
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
</head>
<body>path:${pageContext.request.contextPath}
<img src="${pageContext.request.contextPath}/WEB-INF/images/1.jpg">
<a href="${ctx}/book/toAdd"><t:message code="label.msg"/> </a>
<form action="${ctx}/book/bookFile" method="post" enctype="multipart/form-data">
    <input type="hidden" name="bookId" value="${requestScope.bookId}">
    <input type="file" name="img">
    <input type="submit" value="上传">
</form>
<shiro:hasPermission name="bookmanager:book:query">
<a href="${ctx}/book/list1">分页查询返回json</a>
</shiro:hasPermission>

<shiro:hasRole name="管理员">
<h1>系统管理</h1>
<ul>
    <li>用户新增</li>
    <li>用户查询</li>
    <li>用户修改</li>
    <li>用户删除</li>
</ul>
</shiro:hasRole>
</body>
</html>
