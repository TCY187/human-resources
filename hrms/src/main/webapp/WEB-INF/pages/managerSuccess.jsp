<%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/7/29
  Time: 18:09
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
<form action="getGetCV" method="post">
    <input type="submit" value="查看简历">
</form>
</body>
</html>
