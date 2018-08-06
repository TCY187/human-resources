<%@ page import="com.iotek.model.Depa" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/8/2
  Time: 10:27
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
    List<Depa> depaList = (List<Depa>) session.getAttribute("empdepaList1");
    int totalPages= (int) session.getAttribute("empdepatotalPages");
%>
<div id="div1">
    <h1>部门浏览</h1>
    <table border="1" cellspacing="0">
        <tr>
            <th>id</th>
            <th>部门名</th>
            <th>查看相关职位</th>
        </tr>
        <%
            for (int i = 0; i < depaList.size(); i++) {
        %>
        <tr>
            <td><%=depaList.get(i).getId()%></td>
            <td><%=depaList.get(i).getDname()%></td>
            <td>
                <form action="empgetPositionByDepa" method="post">
                    <input type="hidden" name="did1" value="<%=depaList.get(i).getId()%>">
                    <input type="submit" value="查看职位">
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <%
        for (int i = 1; i <=totalPages; i++) {
    %>
    <a href="empgetDepa?currentPage=<%=i%>"><%=i%></a>
    <%
        }
    %>
    <span>${operateDepaerror}</span>
    <a href="esuccess">返回员工主页</a>
</div>
</body>
</html>
