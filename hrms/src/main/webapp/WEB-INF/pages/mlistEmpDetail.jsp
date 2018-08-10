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
<%
    Emp emp = (Emp) session.getAttribute("memp");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String birth = sdf.format(emp.getBirth());
    String entrytime = sdf.format(emp.getEntrytime());
%>
<div id="div1">
        <table border="1" cellspacing="0">
            <tr>
                <th>姓名</th>
                <th><input type="text" disabled="disabled" value="<%=emp.getUname()%>"></th>
                <th>性别</th>
                <th><input type="text" disabled="disabled" value="<%=emp.getSex()%>"></th>
                <th>出生日期</th>
                <th><input type="date" disabled="disabled" value="<%=birth%>"></th>
            </tr>
            <tr>
                <th>籍贯</th>
                <th><input type="text" disabled="disabled" value="<%=emp.getBp()%>"></th>
                <th>邮箱</th>
                <th><input type="text" disabled="disabled" value="<%=emp.getEmail()%>"></th>
                <th>联系电话</th>
                <th><input type="text" disabled="disabled" value="<%=emp.getPhone()%>"></th>
            </tr>
            <tr>
                <th>学历</th>
                <th><input type="text" disabled="disabled" value="<%=emp.getEdu()%>"></th>
                <th>毕业学校</th>
                <th><input type="text" disabled="disabled" value="<%=emp.getSchool()%>"></th>
                <th>专业</th>
                <th><input type="text" disabled="disabled" value="<%=emp.getMajor()%>"></th>
            </tr>
            <tr>
                <th>身份证</th>
                <th><input type="text" disabled="disabled" value="<%=emp.getCardno()%>"></th>
                <th>部门</th>
                <th><input type="text" disabled="disabled" value="<%=emp.getDepa().getDname()%>"></th>
                <th>职位</th>
                <th><input type="text" disabled="disabled" value="<%=emp.getPosition().getPname()%>"></th>
            </tr>
            <tr>
                <th>工号</th>
                <th><input type="text" disabled="disabled"  value="<%=emp.getEname()%>"></th>
                <th>密码</th>
                <th><input type="text" disabled="disabled" value="<%=emp.getPass()%>"></th>
                <th>入职时间</th>
                <th><input type="date" disabled="disabled"  value="<%=entrytime%>"></th>
            </tr>
        </table>
    <a href="msuccess">返回管理员主页</a>
</div>
</body>
</html>
