<%--
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
</head>
<body>
<div id="div1">
    <form action="addDCul1" method="post">
        主题：<input type="text" name="theme"/><br/>
        内容：<input type="text" name="content"/><br/>
        地点：<input type="text" name="address"/><br/>
        开始：<input type="date" name="betime"/><br/>
        结束：<input type="date" name="entime"/><br/>
        <input type="submit" value="下一步">
    </form>
</div>
</body>
</html>
