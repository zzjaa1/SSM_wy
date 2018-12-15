<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2018/12/12
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%@include file="/common/head.jsp"%></title>
</head>
<body>
<h1>用户登录</h1>
<br>
${message}
<br>
<form action="${ctx}/user/login" method="post">
    <label>用户账号</label><input type="text" name="username"><br>
    <label>用户密码</label><input type="text" name="password"><br>
    <input type="submit" value="登录">
</form>


</body>
</html>
