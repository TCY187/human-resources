<%@ page import="com.iotek.model.Recr" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/7/30
  Time: 1:41
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
    List<Recr> recrList = (List<Recr>) session.getAttribute("manrecrList");
    int totalPages= (int) session.getAttribute("mantotalPages");
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
            <th>删除</th>
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
                <form action="deleteRecr" method="post">
                    <input type="hidden" name="rid" value="<%=recrList.get(i).getId()%>">
                    <input type="submit" value="删除">
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
    <a href="getRecr?currentPage=<%=i%>"><%=i%></a>
    <%
        }
    %>
</div>
</body>
</html>
