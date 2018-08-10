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
</div>
</body>
</html>
