
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2018/12/3
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
</head>
<body>
<h1>新增书本</h1>
${param.message}
<f:form modelAttribute="book" action="${ctx}/book/add1" method="post" >
    书本名称：<f:input path="bname"/><f:errors path="bname"/><br>
    书本价格：<f:input path="bprice"/><f:errors path="bprice"/><br>
    书本类型：<input type="hidden" name="bb" value="提交">
    <f:select path="btype">
        <f:options items="${lst}" itemLabel="bType" itemValue="bValue" ></f:options>
    </f:select><br>
    <input type="submit" value="新增">
</f:form>
</body>
</html>
