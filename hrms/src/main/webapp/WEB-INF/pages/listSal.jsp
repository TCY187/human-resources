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
            <th>申请复议</th>
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
            <td>
                <form action="fuyi" method="post">
                    <input type="hidden" name="sid" value="<%=sal.getId()%>">
                    <input type="submit" value="申请复议">
                </form>
            </td>
        </tr>
    </table>
</body>
</html>
