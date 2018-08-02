<%@ page import="com.iotek.model.Cul" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/8/2
  Time: 16:34
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
            margin-top: 100px;
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
    List<Cul> culList = (List<Cul>) session.getAttribute("culList");
    int totalPages= (int) session.getAttribute("cultotalPages");
%>
<div id="div1">
    <h1>已发布培训信息一览</h1>
    <table border="1" cellspacing="0">
        <tr>
            <th>id</th>
            <th>主题</th>
            <th>内容</th>
            <th>开始</th>
            <th>结束</th>
            <th>地址</th>
            <th>状态</th>
            <th>发布时间</th>
            <th>撤回</th>
        </tr>
        <%
            for (int i = 0; i < culList.size(); i++) {
        %>
        <tr>
            <td><%=culList.get(i).getId()%></td>
            <td><%=culList.get(i).getTheme()%></td>
            <td><%=culList.get(i).getContent()%></td>
            <td><%=culList.get(i).getBegintime()%></td>
            <td><%=culList.get(i).getEndtime()%></td>
            <td><%=culList.get(i).getAddress()%></td>
            <td><%=culList.get(i).getState()%></td>
            <td><%=culList.get(i).getIssuetime()%></td>
            <td>
                <form action="recall" method="post">
                    <input type="hidden" name="cid" value="<%=culList.get(i).getId()%>">
                    <input type="submit" value="撤回">
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
    <span>${recallerror}</span>
    <a href="noIssueCul">查看未发布培训</a>
    <a href="addECul">新增员工培训</a>
    <a href="addDCul">新增部门培训</a>
</body>
</html>
