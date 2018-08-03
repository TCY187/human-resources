<%@ page import="com.iotek.model.Position" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/8/2
  Time: 12:27
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
    List<Position> positionList = (List<Position>) session.getAttribute("positionList");
    int totalPages= (int) session.getAttribute("ptotalPages");
%>
<div id="div1">
    <h1>职位浏览</h1>
    <table border="1" cellspacing="0">
        <tr>
            <th>id</th>
            <th>职位名</th>
            <th>工资</th>
            <th>绩效因子</th>
            <th>删除</th>
            <th>查看相关员工</th>
        </tr>
        <%
            for (int i = 0; i < positionList.size(); i++) {
        %>
        <tr>
            <td><%=positionList.get(i).getId()%></td>
            <td><%=positionList.get(i).getPname()%></td>
            <td><%=positionList.get(i).getJsal()%></td>
            <td><%=positionList.get(i).getPf()%></td>
            <td>
                <form action="deletePosition" method="post">
                    <input type="hidden" name="pid1" value="<%=positionList.get(i).getId()%>">
                    <input type="submit" value="删除">
                </form>
            </td>
            <td>
                <form action="getEmpByPosition" method="post">
                    <input type="hidden" name="pid2" value="<%=positionList.get(i).getId()%>">
                    <input type="submit" value="查看员工">
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
    <a href="getPositionByDepa?currentPage=<%=i%>"><%=i%></a>
    <%
        }
    %>
    <span>${operatePerror}</span>
</div>
</body>
</html>