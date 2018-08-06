<%@ page import="com.iotek.model.CV" %>
<%@ page import="com.iotek.model.Emp" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
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
    Emp emp = (Emp) session.getAttribute("emp");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String birth = sdf.format(emp.getBirth());
    String entrytime = sdf.format(emp.getEntrytime());
%>
<div id="div1">
    <form action="updateEmpDetail" method="post">
        <table border="1" cellspacing="0">
            <tr>
                <th>姓名</th>
                <th><input type="text" name="uname" value="<%=emp.getUname()%>"></th>
                <th>性别</th>
                <th><input type="text" name="sex" value="<%=emp.getSex()%>"></th>
                <th>出生日期</th>
                <th><input type="date" name="birth1" value="<%=birth%>"></th>
            </tr>
            <tr>
                <th>籍贯</th>
                <th><input type="text" name="bp" value="<%=emp.getBp()%>"></th>
                <th>邮箱</th>
                <th><input type="text" name="email" value="<%=emp.getEmail()%>"></th>
                <th>联系电话</th>
                <th><input type="text" name="phone" value="<%=emp.getPhone()%>"></th>
            </tr>
            <tr>
                <th>学历</th>
                <th><input type="text" name="edu" value="<%=emp.getEdu()%>"></th>
                <th>毕业学校</th>
                <th><input type="text" name="school" value="<%=emp.getSchool()%>"></th>
                <th>专业</th>
                <th><input type="text" name="major" value="<%=emp.getMajor()%>"></th>
            </tr>
            <tr>
                <th>身份证</th>
                <th><input type="text" name="cardno" value="<%=emp.getCardno()%>"></th>
                <th>部门</th>
                <th><input type="text" disabled="disabled" value="<%=emp.getDepa().getDname()%>"></th>
                <th>职位</th>
                <th><input type="text" disabled="disabled" value="<%=emp.getPosition().getPname()%>"></th>
            </tr>
            <tr>
                <th>工号</th>
                <th><input type="text" disabled="disabled"  value="<%=emp.getEname()%>"></th>
                <th>密码</th>
                <th><input type="text" name="pass" value="<%=emp.getPass()%>"></th>
                <th>入职时间</th>
                <th><input type="date" disabled="disabled"  value="<%=entrytime%>"></th>
            </tr>
            <tr>
                <th>状态</th>
                <th><input type="text" disabled="disabled"  value="<%=emp.getState()%>"></th>
            </tr>
        </table>
        <input type="hidden" name="eid" value="<%=emp.getId()%>">
        <input type="submit" value="确认修改">
    </form>
    <a href="esuccess">返回员工主页</a>
</div>
</body>
</html>
