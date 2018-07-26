<%@ page import="com.iotek.model.CV" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/7/26
  Time: 12:59
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
    List<CV> cvList = (List<CV>) session.getAttribute("cvList");
    int totalPages= (int) session.getAttribute("cvtotalPages");
%>
<div id="div1">
    <h1>简历信息一览</h1>
    <table border="1" cellspacing="0">
        <tr>
            <th>id</th>
            <th>简历名</th>
            <th>姓名</th>
            <th>性别</th>
            <th>详情</th>
            <th>投递</th>
            <th>删除</th>
        </tr>
        <%
            for (int i = 0; i < cvList.size(); i++) {
        %>
        <tr>
            <td><%=cvList.get(i).getId()%></td>
            <td><%=cvList.get(i).getCvname()%></td>
            <td><%=cvList.get(i).getUname()%></td>
            <td><%=cvList.get(i).getSex()%></td>
            <td>
                <form method="post" action="getCVDetail">
                    <input type="hidden" name="CVDId" value="<%=cvList.get(i).getId()%>">
                    <input type="submit" value="详情">
                </form>
            </td>
            <td>
                <form method="post" action="sendCV">
                    <input type="hidden" name="CVDId1" value="<%=cvList.get(i).getId()%>">
                    <input type="submit" value="投递">
                </form>
            </td>
            <td>
                <form method="post" action="deleteCV">
                    <input type="hidden" name="CVDId2" value="<%=cvList.get(i).getId()%>">
                    <input type="submit" value="删除">
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <a href="saveCV">添加</a>
        <%
        for (int i = 1; i <=totalPages; i++) {
    %>
    <a href="getCV?currentPage=<%=i%>"><%=i%></a>
        <%
        }
    %>
    <a href="success">返回主页</a>
</div>
</body>
</html>
