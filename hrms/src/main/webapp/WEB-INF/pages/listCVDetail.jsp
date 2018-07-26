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
    <form action="updateCV" method="post">
        <h1><input type="text" name="cvname" value="<%=cv.getCvname()%>"></h1>
        <table border="1" cellspacing="0">
            <tr>
                <th>姓名</th>
                <th><input type="text" name="uname" value="<%=cv.getUname()%>"></th>
                <th>性别</th>
                <th><input type="text" name="sex" value="<%=cv.getSex()%>"></th>
                <th>出生日期</th>
                <th><input type="date" name="birth1" value="<%=cv.getBirth()%>"></th>
            </tr>
            <tr>
                <th>籍贯</th>
                <th><input type="text" name="bp" value="<%=cv.getBp()%>"></th>
                <th>邮箱</th>
                <th><input type="text" name="email" value="<%=cv.getEmail()%>"></th>
                <th>联系电话</th>
                <th><input type="text" name="phone" value="<%=cv.getPhone()%>"></th>
            </tr>
            <tr>
                <th>学历</th>
                <th><input type="text" name="edu" value="<%=cv.getEdu()%>"></th>
                <th>毕业学校</th>
                <th><input type="text" name="school" value="<%=cv.getSchool()%>"></th>
                <th>专业</th>
                <th><input type="text" name="major" value="<%=cv.getMajor()%>"></th>
            </tr>
            <tr>
                <th>工作经验</th>
                <th colspan="5"><input type="text" name="hobg" value="<%=cv.getHobg()%>"></th>
            </tr>
            <tr>
                <th>自我评价</th>
                <th colspan="5"><input type="text" name="selfeval" value="<%=cv.getSelfeval()%>"></th>
            </tr>
        </table>
        <input type="hidden" name="CVId" value="<%=cv.getId()%>">
        <input type="submit" value="确认添加">
    </form>
    <a href="success">返回主页</a>
</div>
</body>
</html>
