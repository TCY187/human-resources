<%@ page import="com.iotek.model.Attendance" %>
<%@ page import="java.util.List" %>
<%@ page import="com.iotek.model.RAP" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/8/3
  Time: 18:34
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
            width: 1000px;
            height: 30px;
            text-align: center;
        }
        td{
            width: 1000px;
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
    List<RAP> rapList = (List<RAP>) session.getAttribute("rapList");
    int totalPages= (int) session.getAttribute("raptotalPages");
%>
<form action="getRAPByEid" method="post">
    <input type="date" name="rapdate" >
    <input type="submit" value="查询">
</form>
<div id="div1">
    <h1>奖惩记录一览</h1>
    <table border="1" cellspacing="0">
        <tr>
            <th>id</th>
            <th>日期</th>
            <th>金额</th>
            <th>缘由</th>
        </tr>
        <%
            for (int i = 0; i < rapList.size(); i++) {
        %>
        <tr>
            <td><%=rapList.get(i).getId()%></td>
            <td><%=rapList.get(i).getTime()%></td>
            <td><%=rapList.get(i).getMoney()%></td>
            <td><%=rapList.get(i).getIntro()%></td>
        </tr>
        <%
            }
        %>
    </table>
    <%
        for (int i = 1; i <=totalPages; i++) {
    %>
    <%
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String createdate = sdf.format(rapList.get(0).getTime());
    %>
    <a href="getRAPByEid?date1=<%=createdate%>&currentPage=<%=i%>" style="display:block;text-align:center;"><%=i%></a>
    <%
        }
    %>
    <a href="esuccess">返回员工主页</a>
</div>
</body>
</html>
