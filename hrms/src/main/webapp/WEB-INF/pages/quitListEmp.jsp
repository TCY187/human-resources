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
    List<Emp> empList = (List<Emp>) session.getAttribute("quitempList");
    int totalPages= (int) session.getAttribute("quitemptotalPages");
%>
<div id="div1">
    <h1>离职员工浏览</h1>
    <table border="1" cellspacing="0">
        <tr>
            <th>id</th>
            <th>姓名</th>
            <th>身份证号</th>
            <th>部门</th>
            <th>职位</th>
        </tr>
        <%
            for (int i = 0; i < empList.size(); i++) {
        %>
        <tr>
            <td><%=empList.get(i).getId()%></td>
            <td><%=empList.get(i).getUname()%></td>
            <td><%=empList.get(i).getCardno()%></td>
            <td><%=empList.get(i).getDepa().getDname()%></td>
            <td><%=empList.get(i).getPosition().getPname()%></td>
        </tr>
        <%
            }
        %>
    </table>
        <%
        for (int i = 1; i <=totalPages; i++) {
    %>
    <a href="getquitEmp?currentPage=<%=i%>"><%=i%></a>
        <%
        }
    %>
    <br/><span>${stateerror}</span>
</body>
</html>
