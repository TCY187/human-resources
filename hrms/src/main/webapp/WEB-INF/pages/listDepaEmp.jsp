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
    <style>
        #div1{
            width: 800px;
            margin-left: auto;
            margin-right: auto;
            margin-top: -300px;
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
<%
    List<Emp> empList = (List<Emp>) session.getAttribute("empdepaList");
    int totalPages= (int) session.getAttribute("empdepatotalPages");
%>
<div id="div1">
    <h1>职位浏览</h1>
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
    <a href="getEmpByDepa?currentPage=<%=i%>"><%=i%></a>
        <%
        }
    %>
</body>
</html>
