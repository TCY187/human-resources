<%@ page import="com.iotek.model.Emp" %>
<%@ page import="java.util.List" %><%--
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
    List<Emp> empList = (List<Emp>) session.getAttribute("stateempList");
    int totalPages= (int) session.getAttribute("stateemptotalPages");
%>
<div id="div1">
    <h1>未转正员工浏览</h1>
    <table border="1" cellspacing="0">
        <tr>
            <th>id</th>
            <th>姓名</th>
            <th>身份证号</th>
            <th>部门</th>
            <th>职位</th>
            <th>入职时间</th>
            <th>转正</th>
        </tr>
        <%
            for (int i = 0; i < empList.size(); i++) {
        %>
        <tr>
            <td><%=empList.get(i).getId()%></td>
            <td><%=empList.get(i).getUname()%></td>
            <td><%=empList.get(i).getCardno()%></td>
            <td><%=empList.get(i).getDepa().getDname()%></td>
            <td><%=empList.get(i).getPosition().getPname()%></td>
            <td><%=empList.get(i).getEntrytime()%></td>
            <td>
                <form action="zhuanzheng1" method="post">
                    <input type="hidden" name="eid1" value="<%=empList.get(i).getId()%>">
                    <input type="submit" value="转正">
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
    <a href="zhuanzheng?currentPage=<%=i%>" style="display:block;text-align:center;"><%=i%></a>
        <%
        }
    %>
    <br/><span>${stateerror}</span>
</div>
</body>
</html>
