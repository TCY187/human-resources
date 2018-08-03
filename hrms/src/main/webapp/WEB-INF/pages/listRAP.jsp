<%@ page import="com.iotek.model.Attendance" %>
<%@ page import="java.util.List" %>
<%@ page import="com.iotek.model.RAP" %><%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/8/3
  Time: 18:34
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
    List<RAP> rapList = (List<RAP>) session.getAttribute("rapList");
    int totalPages= (int) session.getAttribute("raptotalPages");
%>
<div id="div1">
    <h1>奖惩记录一览</h1>
    <table border="1" cellspacing="0">
        <tr>
            <th>id</th>
            <th>日期</th>
            <th>金额</th>
            <th>缘由</th>
        </tr>
        <%
            for (int i = 0; i < rapList.size(); i++) {
        %>
        <tr>
            <td><%=rapList.get(i).getId()%></td>
            <td><%=rapList.get(i).getTime()%></td>
            <td><%=rapList.get(i).getMoney()%></td>
            <td><%=rapList.get(i).getIntro()%></td>
        </tr>
        <%
            }
        %>
    </table>
    <%
        for (int i = 1; i <=totalPages; i++) {
    %>
    <a href="getRAPByEid?currentPage=<%=i%>"><%=i%></a>
    <%
        }
    %>
</div>
</body>
</html>
