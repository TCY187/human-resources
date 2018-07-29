<%@ page import="com.iotek.model.Recr" %>
<%@ page import="java.util.List" %>
<%@ page import="com.iotek.model.User" %><%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/7/25
  Time: 13:11
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
        #div1{
            width: 800px;
            margin-left: auto;
            margin-right: auto;
            margin-top: -300px;
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
<%
    User user = (User) session.getAttribute("user");
%>
<div id="d1">
    <h2>游客登录</h2>
    <form action="login" method="post">
        账号：<input type="text" name="name"/><br/>
        密码：<input type="password" name="pass"/><br/>
        <input type="submit" value="登录">
    </form>
    <form action="register1">
        <input type="submit" name="register1" value="注册">
    </form>
    <span>${logerror}</span>
    <span>${clogerror}</span>
</div>
<div id="d2">
    <h2>员工登录</h2>
    <form action="emplogin" method="post">
        账号：<input type="text" name="ename"/><br/>
        密码：<input type="password" name="epass"/><br/>
        <input type="submit" value="登录">
    </form>
    <span>${emplogerror}</span>
    <span>${empclogerror}</span>
</div>
<div id="d3">
    <h2>管理员登录</h2>
    <form action="manlogin" method="post">
        账号：<input type="text" name="mname"/><br/>
        密码：<input type="password" name="mpass"/><br/>
        <input type="submit" value="登录">
    </form>
    <span>${manlogerror}</span>
    <span>${manclogerror}</span>
</div>
<%
    List<Recr> recrList = (List<Recr>) session.getAttribute("recrList");
    int totalPages= (int) session.getAttribute("totalPages");
%>
<div id="div1">
    <h1>招聘信息一览</h1>
    <table border="1" cellspacing="0">
        <tr>
            <th>id</th>
            <th>职位</th>
            <th>部门</th>
            <th>工资</th>
            <th>描述</th>
            <th>人数</th>
            <th>状态</th>
            <th>时间</th>
            <th>投递</th>
        </tr>
        <%
            for (int i = 0; i < recrList.size(); i++) {
        %>
        <tr>
            <td><%=recrList.get(i).getId()%></td>
            <td><%=recrList.get(i).getPosition().getPname()%></td>
            <td><%=recrList.get(i).getDepa().getDname()%></td>
            <td><%=recrList.get(i).getPosition().getJsal()%></td>
            <td><%=recrList.get(i).getDesc()%></td>
            <td><%=recrList.get(i).getNum()%></td>
            <td><%=recrList.get(i).getState()%></td>
            <td><%=recrList.get(i).getTime()%></td>
            <td>
                <form action="getCV" method="post">
                    <input type="hidden" name="rid" value="<%=recrList.get(i).getId()%>">
                    <input type="submit" value="投递">
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <%
        for (int i = 1; i <=totalPages; i++) {
    %>
    <a href="?currentPage=<%=i%>"><%=i%></a>
    <%
        }
    %>
</div>
</body>
</html>
