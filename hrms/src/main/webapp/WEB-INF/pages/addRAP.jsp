<%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/8/5
  Time: 23:17
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
<div id="div1">
    <form action="saveRAP1" method="post">
        金额：<input type="number" step="50" name="money" id="number" value="0"><br/>
        原因：<input id="man" type="radio" checked="checked" name="intro" value="结算错误"/>结算错误
        <input id="woman" type="radio"  name="intro" value="其他"/>其他
        <input type="submit" value="添加">
    </form>
</div>
</body>
</html>
