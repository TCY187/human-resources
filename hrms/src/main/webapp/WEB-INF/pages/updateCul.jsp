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
    Cul cul = (Cul)session.getAttribute("updateCul");
%>
<div id="div1">
<form action="updateCul1" method="post">
    主题：<input type="text" name="theme1" value="<%=cul.getTheme()%>"/><br/>
    内容：<input type="text" name="content1" value="<%=cul.getContent()%>"/><br/>
    地点：<input type="text" name="address1" value="<%=cul.getAddress()%>"/><br/>
    <input type="submit" value="修改">
</form>
    <a href="msuccess">返回管理员主页</a>
</div>
</body>
</html>
