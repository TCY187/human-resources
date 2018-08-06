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
<form action="getmanInt" method="post">
    <input type="submit" value="查看面试">
</form>
<form action="getRecr" method="post">
    <input type="submit" value="查看招聘信息">
</form>
<form action="operateDepa" method="post">
    <input type="submit" value="查看在职员工">
</form>
<form action="getquitEmp" method="post">
    <input type="submit" value="查看离职职员工">
</form>
<form action="aboutCul" method="post">
    <input type="submit" value="相关培训">
</form>
<form action="payMoney" method="post">
    <input type="submit" value="薪资结算">
</form>
<form action="zhuanzheng" method="post">
    <input type="submit" value="员工转正">
</form>
<br/><span>${payMoneyerror}</span>
</body>
</html>
