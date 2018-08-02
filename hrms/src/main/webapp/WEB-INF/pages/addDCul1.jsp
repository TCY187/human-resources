<%@ page import="com.iotek.model.Depa" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/8/2
  Time: 23:56
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
    List<Depa> depaList = (List<Depa>) session.getAttribute("culdepaList");
%>
<div id="div1">
    <h1>选择部门</h1>
    <table border="1" cellspacing="0">
        <tr>
            <th>部门名</th>
            <th>选择</th>
        </tr>
        <%
            for (int i = 0; i < depaList.size(); i++) {
        %>
        <tr>
            <td><%=depaList.get(i).getDname()%></td>
            <td>
                <form action="addDCul2" method="post">
                    <input type="hidden" name="did" value="<%=depaList.get(i).getId()%>">
                    <input type="submit" value="选择">
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>
