<%@ page import="com.iotek.model.Emp" %>
<%@ page import="java.util.List" %><%--
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
    List<Emp> empList = (List<Emp>) session.getAttribute("empemppList");
    int totalPages= (int) session.getAttribute("empempptotalPages");
%>
<div id="div1">
    <h1>员工浏览</h1>
    <table border="1" cellspacing="0">
        <tr>
            <th>姓名</th>
            <th>性别</th>
            <th>出生年月</th>
            <th>手机号</th>
            <th>邮箱</th>
        </tr>
        <%
            for (int i = 0; i < empList.size(); i++) {
        %>
        <tr>
            <td><%=empList.get(i).getUname()%></td>
            <td><%=empList.get(i).getSex()%></td>
            <td><%=empList.get(i).getBirth()%></td>
            <td><%=empList.get(i).getPhone()%></td>
            <td><%=empList.get(i).getEmail()%></td>
        </tr>
        <%
            }
        %>
    </table>
        <%
        for (int i = 1; i <=totalPages; i++) {
    %>
    <a href="empgetEmpByPosition?currentPage=<%=i%>"><%=i%></a>
        <%
        }
    %>
    <a href="esuccess">返回员工主页</a>
</body>
</html>
