<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/8/3
  Time: 11:31
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
    <script language="javascript">
        function clockoff() {
            if (!confirm("确认要下班打卡吗？")) {
                window.event.returnValue = false;
            }
        }
    </script>
</head>
<body>
<a href="getEmpByEmp">个人信息</a>
<a href="clockon">上班打卡</a>
<a href="clockoff"  onClick="clockoff()">下班打卡</a>
<a href="getAttendanceByEid">考勤查询</a>
<a href="getRAPByEid">奖惩查询</a>
<a href="getSalByEid">工资查询</a>
<a href="getCulByEid">培训查询</a>
<a href="empgetDepa">部门查询</a>
<br/><span>${clockerror}</span>
<br/><span>${salerror}</span>
</body>
</html>
