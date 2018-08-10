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
        th{
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
    List<Sal> salList = (List<Sal>) session.getAttribute("gzfysalList");
    int totalPages= (int) session.getAttribute("gzfysaltotalPages");
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
            <th>处理</th>
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
            <td>
                <form action="gzfy1" method="post">
                    <input type="hidden" name="sid" value="<%=salList.get(i).getId()%>">
                    <input type="submit" value="处理">
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
    <a href="gzfy?currentPage=<%=i%>" style="display:block;text-align:center;"><%=i%></a>
        <%
        }
    %>
    <a href="msuccess">返回管理员主页</a>
</body>
</html>
