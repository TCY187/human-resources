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
        td{
            width: 200px;
            height: 30px;
            text-align: center;
        }
        th{
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
    List<Recr> recrList = (List<Recr>) session.getAttribute("recr0List");
    int totalPages= (int) session.getAttribute("recr0totalPages");
%>
<div id="div1">
    <h1>未发布招聘信息一览</h1>
    <table border="1" cellspacing="0">
        <tr>
            <th>id</th>
            <th>职位</th>
            <th>部门</th>
            <th>工资</th>
            <th>描述</th>
            <th>人数</th>
            <th>状态</th>
            <th>发布</th>
            <th>修改</th>
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
            <td>
                <form action="issueRecr" method="post">
                    <input type="hidden" name="rid" value="<%=recrList.get(i).getId()%>">
                    <input type="submit" value="发布">
                </form>
            </td>
            <td>
                <form action="updateRecr" method="post">
                    <input type="hidden" name="rid1" value="<%=recrList.get(i).getId()%>">
                    <input type="submit" value="修改">
                </form>
            </td>
            <td>
                <form action="deleteRecr" method="post">
                    <input type="hidden" name="rid2" value="<%=recrList.get(i).getId()%>">
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
    <a href="getRecr?currentPage=<%=i%>" style="display:block;text-align:center;"><%=i%></a>
    <%
        }
    %>
    <a href="msuccess">返回管理员主页</a>
</div>
</body>
</html>
