<%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/8/8
  Time: 13:14
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
    <style>
        #div1{
            margin-left: auto;
            margin-right: auto;
            margin-top: 100px;
            padding-top: 100px;
            background-image: url("/pic/register.jpg");
            width: 800px;
            height: 400px;
            text-align: center;
        }
    </style>
</head>
<body>
<br/>
<br/>
<jsp:include page="/head.jsp"></jsp:include>
<br/>
<div id="div1">
    <h2>管理员登录</h2>
    <form action="manlogin" method="post">
        账号：<input type="text" name="mname"/><br/>
        密码：<input type="password" name="mpass"/><br/>
        <input type="submit" value="登录">
    </form>
    <span>${manlogerror}</span>
    <span>${manclogerror}</span>
</div>
</body>
</html>
