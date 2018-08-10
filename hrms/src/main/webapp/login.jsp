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
        th{
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
<br/>
<div id="d1" style="background-color: blanchedalmond">
    <form action="login" method="post" style="display: inline" >
        账号：<input type="text" name="name"/>
        密码：<input type="password" name="pass"/>
        <input type="submit" value="登录" >
    </form>
    <form action="register1" style="display: inline">
        <input type="submit"  value="注册">
    </form>
</div>
<br/>
<br/>
<div>
    <form action="getuserInt" style="display: inline">
        <input type="submit"  value="查看面试邀请">
    </form>
    <form action="getCV1" style="display: inline">
        <input type="submit"  value="查看你的简历">
    </form>
    <a href="manlogin1">管理员登录</a>
    <a href="emplogin1">员工登录</a>
</div>
<br/>
<div>
    <span>${logerror}</span>
    <span>${clogerror}</span>
</div>
<br/>
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
    <a href="?currentPage=<%=i%>" style="display:block;text-align:center;"><%=i%></a>
    <%
        }
    %>
</div>
</body>
</html>
