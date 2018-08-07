<%@ page import="com.iotek.model.GetCV" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/7/29
  Time: 18:11
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
    List<GetCV> getCVList = (List<GetCV>) session.getAttribute("getCVList");
    int totalPages= (int) session.getAttribute("GCVtotalPages");
%>
<div id="div1">
    <h1>招聘信息一览</h1>
    <table border="1" cellspacing="0">
        <tr>
            <th>id</th>
            <th>职位</th>
            <th>部门</th>
            <th>应聘者姓名</th>
            <th>面试</th>
            <th>不合适</th>
        </tr>
        <%
            for (int i = 0; i < getCVList.size(); i++) {
        %>
        <tr>
            <td><%=getCVList.get(i).getId()%></td>
            <td><%=getCVList.get(i).getRecr().getPosition().getPname()%></td>
            <td><%=getCVList.get(i).getRecr().getDepa().getDname()%></td>
            <td><%=getCVList.get(i).getCv().getUname()%></td>
            <td>
                <form action="miansi" method="post">
                    <input type="hidden" name="gid1" value="<%=getCVList.get(i).getId()%>">
                    <input type="submit" value="面试">
                </form>
            </td>
            <td>
                <form action="buheshi" method="post">
                    <input type="hidden" name="gid2" value="<%=getCVList.get(i).getId()%>">
                    <input type="submit" value="不合适">
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
    <a href="getGetCV?currentPage=<%=i%>"><%=i%></a>
        <%
        }
    %>
    <a href="msuccess">返回管理员主页</a>
</body>
</html>
