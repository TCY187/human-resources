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
<div>
<form action="getGetCV" method="post">
    <input type="submit" value="查看投递简历">
</form>
<form action="getmanInt" method="post">
    <input type="submit" value="查看面试邀请">
</form>
<form action="getRecr" method="post">
    <input type="submit" value="查看招聘信息">
</form>
<form action="operateDepa" method="post">
    <input type="submit" value="查看在职员工">
</form>
<form action="getquitEmp" method="post">
    <input type="submit" value="查看离职员工">
</form>
<form action="aboutCul" method="post">
    <input type="submit" value="查看相关培训">
</form>
<form action="payMoney" method="post">
    <input type="submit" value="进行薪资结算">
</form>
<form action="zhuanzheng" method="post">
    <input type="submit" value="进行员工转正">
</form>
    <form action="gzfy" method="post">
        <input type="submit" value="查看工资复议">
    </form>
    <br/><span>${gzfyerror}</span>
<br/><span>${payMoneyerror}</span>
</div>
</body>
</html>
