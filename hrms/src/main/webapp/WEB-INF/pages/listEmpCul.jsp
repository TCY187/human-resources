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
    List<Cul> culList = (List<Cul>) session.getAttribute("empCulList");
//    int totalPages= (int) session.getAttribute("empCultotalPages");
%>
<div id="div1">
    <h1>培训信息一览</h1>
    <table border="1" cellspacing="0">
        <tr>
            <th>主题</th>
            <th>内容</th>
            <th>开始</th>
            <th>结束</th>
            <th>地址</th>
            <th>发布时间</th>
        </tr>
        <%
            for (int i = 0; i < culList.size(); i++) {
        %>
        <tr>
            <td><%=culList.get(i).getTheme()%></td>
            <td><%=culList.get(i).getContent()%></td>
            <td><%=culList.get(i).getBegintime()%></td>
            <td><%=culList.get(i).getEndtime()%></td>
            <td><%=culList.get(i).getAddress()%></td>
            <td><%=culList.get(i).getIssuetime()%></td>
        </tr>
        <%
            }
        %>
    </table>
        <%--<%--%>
        <%--for (int i = 1; i <=totalPages; i++) {--%>
    <%--%>--%>
    <%--<a href="?currentPage=<%=i%>"><%=i%></a>--%>
        <%--<%--%>
        <%--}--%>
    <%--%>--%>
</body>
</html>
