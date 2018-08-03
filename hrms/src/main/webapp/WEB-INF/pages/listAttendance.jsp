<%@ page import="com.iotek.model.Attendance" %>
<%@ page import="java.util.List" %><%--
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
    List<Attendance> attendanceList = (List<Attendance>) session.getAttribute("attendanceList");
    int totalPages= (int) session.getAttribute("attendancetotalPages");
%>
<div id="div1">
    <h1>考勤记录一览</h1>
    <table border="1" cellspacing="0">
        <tr>
            <th>id</th>
            <th>日期</th>
            <th>上班时间</th>
            <th>下班时间</th>
            <th>状态</th>
        </tr>
        <%
            for (int i = 0; i < attendanceList.size(); i++) {
        %>
        <tr>
            <td><%=attendanceList.get(i).getId()%></td>
            <td><%=attendanceList.get(i).getTime()%></td>
            <td><%=attendanceList.get(i).getOntime()%></td>
            <td><%=attendanceList.get(i).getOfftime()%></td>
            <td><%=attendanceList.get(i).getState()%></td>
        </tr>
        <%
            }
        %>
    </table>
    <%
        for (int i = 1; i <=totalPages; i++) {
    %>
    <a href="getAttendanceByEid?currentPage=<%=i%>"><%=i%></a>
    <%
        }
    %>
</div>
</body>
</html>
