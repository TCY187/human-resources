<%@ page import="com.iotek.model.Cul" %>
<%@ page import="com.iotek.model.Depa" %><%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/8/3
  Time: 0:29
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
    Cul cul = (Cul) session.getAttribute("cul");
    Depa depa = (Depa) session.getAttribute("culdepa");
%>
<div id="div1">
    <h1>选择部门</h1>
    <table border="1" cellspacing="0">
        <tr>
            <th>id</th>
            <th>主题</th>
            <th>内容</th>
            <th>开始</th>
            <th>结束</th>
            <th>地址</th>
            <th>培训部门</th>
            <th>是否发布</th>
        </tr>
        <tr>
            <td><%=cul.getId()%></td>
            <td><%=cul.getTheme()%></td>
            <td><%=cul.getContent()%></td>
            <td><%=cul.getBegintime()%></td>
            <td><%=cul.getEndtime()%></td>
            <td><%=cul.getAddress()%></td>
            <td><%=depa.getDname()%></td>
            <td>
                <form action="issueCul" method="post">
                    <input type="hidden" name="cid" value="<%=cul.getId()%>">
                    <input type="submit" value="发布">
                </form>
            </td>
        </tr>
    </table>
    <a href="msuccess">返回管理员主页</a>
</div>
</body>
</html>
