<%@ page import="com.iotek.model.Interview" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/7/30
  Time: 1:14
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
    List<Interview> interviewList = (List<Interview>) session.getAttribute("interviewList");
    int totalPages= (int) session.getAttribute("intGCVtotalPages");
%>
<div id="div1">
    <h1>招聘信息一览</h1>
    <table border="1" cellspacing="0">
        <tr>
            <th>id</th>
            <th>职位</th>
            <th>部门</th>
            <th>地址</th>
            <th>时间</th>
            <th>备注</th>
            <th>接受</th>
            <th>不接受</th>
        </tr>
        <%
            for (int i = 0; i < interviewList.size(); i++) {
        %>
        <tr>
            <td><%=interviewList.get(i).getId()%></td>
            <td><%=interviewList.get(i).getRecr().getPosition().getPname()%></td>
            <td><%=interviewList.get(i).getRecr().getDepa().getDname()%></td>
            <td><%=interviewList.get(i).getTime()%></td>
            <td><%=interviewList.get(i).getAddress()%></td>
            <td><%=interviewList.get(i).getRemarks()%></td>
            <td>
                <form action="acceptInt" method="post">
                    <input type="hidden" name="iid1" value="<%=interviewList.get(i).getId()%>">
                    <input type="submit" value="接受">
                </form>
            </td>
            <td>
                <form action="unacceptInt" method="post">
                    <input type="hidden" name="iid2" value="<%=interviewList.get(i).getId()%>">
                    <input type="submit" value="不接受">
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
    <a href="getuserInt?currentPage=<%=i%>" style="display:block;text-align:center;"><%=i%></a>
        <%
        }
    %>
</body>
</body>
</html>
