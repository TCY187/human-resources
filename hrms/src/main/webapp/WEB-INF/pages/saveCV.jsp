<%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/7/26
  Time: 16:22
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
<div id="div1">
    <form action="saveCV1" method="post">
    <h1><input type="text" name="cvname"></h1>
        <table border="1" cellspacing="0">
            <tr>
                <th>姓名</th>
                <th><input type="text" name="uname"></th>
                <th>性别</th>
                <th><input type="text" name="sex"></th>
                <th>出生日期</th>
                <th><input type="date" name="birth1"></th>
            </tr>
            <tr>
                <th>籍贯</th>
                <th><input type="text" name="bp"></th>
                <th>邮箱</th>
                <th><input type="text" name="email"></th>
                <th>联系电话</th>
                <th><input type="text" name="phone"></th>
            </tr>
            <tr>
                <th>学历</th>
                <th><input type="text" name="edu"></th>
                <th>毕业学校</th>
                <th><input type="text" name="school"></th>
                <th>专业</th>
                <th><input type="text" name="major"></th>
            </tr>
            <tr>
                <th>身份证</th>
                <th><input type="text" name="cardno" ></th>
                <th>邮编</th>
                <th><input type="text" name="zp" ></th>
                <th>技能</th>
                <th><input type="text" name="skill"></th>
            </tr>
            <tr>
                <th>工作经验</th>
                <th colspan="5"><input type="text" name="hobg"></th>
            </tr>
            <tr>
                <th>自我评价</th>
                <th colspan="5"><input type="text" name="selfeval"></th>
            </tr>
        </table>
        <input type="submit" value="确认添加">
    </form>
    <a href="success1">返回首页</a>
</div>
</body>
</html>
