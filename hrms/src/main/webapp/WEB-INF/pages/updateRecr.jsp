<%@ page import="com.iotek.model.Recr" %><%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/8/2
  Time: 17:03
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
<%
    Recr recr = (Recr) session.getAttribute("updateRecr");
%>
<br/>
<br/>
<jsp:include page="/head.jsp"></jsp:include>
<br/>
<div id="div1">
    <form action="updateRecr1" method="post">
        要求：<input type="text" name="desc" value="<%=recr.getDesc()%>"/><br/>
        数量：<input type="number" step="1" name="num" id="num" value="<%=recr.getNum()%>" min="1"><br/>
        <input type="submit" value="确定">
    </form>
</div>
</body>
</html>
