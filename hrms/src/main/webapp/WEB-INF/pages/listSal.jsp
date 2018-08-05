<%@ page import="com.iotek.model.Emp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.iotek.model.Sal" %><%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/8/2
  Time: 13:25
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
    Sal sal = (Sal)session.getAttribute("esal");
%>
<div id="div1">
    <h1>工资浏览</h1>
    <table border="1" cellspacing="0">
        <tr>
            <th>姓名</th>
            <th>时间</th>
            <th>基本薪资</th>
            <th>绩效薪资</th>
            <th>加班薪资</th>
            <th>奖惩薪资</th>
            <th>社保</th>
            <th>总薪资</th>
            <th>备注</th>
        </tr>
        <tr>
            <td><%=sal.getEmp().getUname()%></td>
            <td><%=sal.getMonthtime()%></td>
            <td><%=sal.getJsal()%></td>
            <td><%=sal.getPfsal()%></td>
            <td><%=sal.getOversal()%></td>
            <td><%=sal.getRapsal()%></td>
            <td><%=sal.getSssal()%></td>
            <td><%=sal.getSal()%></td>
            <td><%=sal.getIntro()%></td>
        </tr>
    </table>
</body>
</html>
