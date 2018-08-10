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
    <style>
        div{
            width: 1000px;
            margin-left: auto;
            margin-right: auto;
        }
        tr{
            width: 200px;
            height: 30px;
            text-align: center;
        }
        td{
            width: 200px;
            height: 30px;
            text-align: center;
        }
        h1{
            background-color: red;
            margin: 0 auto;
            text-align: center
        }
    </style>
</head>
<body>
<br/>
<br/>
<jsp:include page="/head.jsp"></jsp:include>
<br/>
<%
    RAP rap = (RAP)session.getAttribute("Mrap");
%>
<div id="div1">
<form action="updateRAP1" method="post">
    金额：<input type="number" step="50" name="updateMoney" id="number" value="<%=rap.getMoney()%>">
    <input type="submit" value="修改">
</form>
</div>
</body>
</html>
