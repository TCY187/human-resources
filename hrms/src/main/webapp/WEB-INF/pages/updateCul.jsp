<%@ page import="com.iotek.model.Cul" %><%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/8/3
  Time: 2:56
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
    Cul cul = (Cul)session.getAttribute("updateCul");
%>
<form action="updateCul1" method="post">
    主题：<input type="text" name="theme1" value="<%=cul.getTheme()%>"/><br/>
    内容：<input type="text" name="content1" value="<%=cul.getContent()%>"/><br/>
    地点：<input type="text" name="address1" value="<%=cul.getAddress()%>"/><br/>
    <input type="submit" value="修改">
</form>
</body>
</html>
