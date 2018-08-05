<%@ page import="com.iotek.model.Emp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.iotek.model.Sal" %><%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/8/2
  Time: 13:25
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
    List<Sal> salList = (List<Sal>) session.getAttribute("salList");
    int totalPages= (int) session.getAttribute("saltotalPages");
%>
<div id="div1">
    <h1>工资浏览</h1>
    <table border="1" cellspacing="0">
        <tr>
            <th>姓名</th>
            <th>时间</th>
            <th>基本薪资</th>
            <th>绩效薪资</th>
            <th>加班薪资</th>
            <th>奖惩薪资</th>
            <th>社保</th>
            <th>总薪资</th>
            <th>备注</th>
        </tr>
        <%
            for (int i = 0; i < salList.size(); i++) {
        %>
        <tr>
            <td><%=salList.get(i).getEmp().getUname()%></td>
            <td><%=salList.get(i).getMonthtime()%></td>
            <td><%=salList.get(i).getJsal()%></td>
            <td><%=salList.get(i).getPfsal()%></td>
            <td><%=salList.get(i).getOversal()%></td>
            <td><%=salList.get(i).getRapsal()%></td>
            <td><%=salList.get(i).getSssal()%></td>
            <td><%=salList.get(i).getSal()%></td>
            <td><%=salList.get(i).getIntro()%></td>
        </tr>
        <%
            }
        %>
    </table>
        <%
        for (int i = 1; i <=totalPages; i++) {
    %>
    <a href="payMoney?currentPage=<%=i%>"><%=i%></a>
        <%
        }
    %>
</body>
</html>
