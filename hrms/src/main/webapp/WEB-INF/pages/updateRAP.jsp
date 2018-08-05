<%@ page import="com.iotek.model.RAP" %><%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/8/5
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
</head>
<body>
<%
    RAP rap = (RAP)session.getAttribute("Mrap");
%>
<form action="updateRAP1" method="post">
    金额：<input type="number" step="50" name="updateMoney" id="number" value="<%=rap.getMoney()%>">
    <input type="submit" value="修改">
</form>
</body>
</html>
