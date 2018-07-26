<%@ page import="com.iotek.model.CV" %><%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/7/26
  Time: 15:07
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
    CV cv = (CV)session.getAttribute("cvDetail");
%>
<div id="div1">
    <h1><%=cv.getCvname()%></h1>
    <table border="1" cellspacing="0">
        <tr>
            <th>姓名</th>
            <th><%=cv.getUname()%></th>
            <th>性别</th>
            <th><%=cv.getSex()%></th>
            <th>出生日期</th>
            <th><%=cv.getBirth()%></th>
        </tr>
        <tr>
            <th>籍贯</th>
            <th><%=cv.getBp()%></th>
            <th>邮箱</th>
            <th><%=cv.getEmail()%></th>
            <th>联系电话</th>
            <th><%=cv.getPhone()%></th>
        </tr>
        <tr>
            <th>学历</th>
            <th><%=cv.getEdu()%></th>
            <th>毕业学校</th>
            <th><%=cv.getSchool()%></th>
            <th>专业</th>
            <th><%=cv.getMajor()%></th>
        </tr>
        <tr>
            <th>工作经验</th>
            <th colspan="3"><%=cv.getHobg()%></th>
        </tr>
        <tr>
            <th>自我评价</th>
            <th colspan="3"><%=cv.getSelfeval()%></th>
        </tr>
    </table>
    <a href="success">返回主页</a>
</div>
</body>
</html>
