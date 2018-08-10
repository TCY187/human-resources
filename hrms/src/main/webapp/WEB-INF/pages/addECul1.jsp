<%@ page import="com.iotek.model.Cul" %>
<%@ page import="com.iotek.model.Depa" %>
<%@ page import="java.util.List" %>
<%@ page import="com.iotek.model.Emp" %><%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/8/3
  Time: 0:29
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
    Cul cul = (Cul) session.getAttribute("cul");
    List<Emp> empList =(List<Emp>) session.getAttribute("culempList");
    String culempname = "";
    for(int i=0;i<empList.size();i++){
        culempname = culempname+empList.get(i).getUname()+",";
    }
%>
<div id="div1">
    <h1>选择部门</h1>
    <table border="1" cellspacing="0">
        <tr>
            <th>id</th>
            <th>主题</th>
            <th>内容</th>
            <th>开始</th>
            <th>结束</th>
            <th>地址</th>
            <th>培训人员</th>
            <th>是否发布</th>
        </tr>
        <tr>
            <td><%=cul.getId()%></td>
            <td><%=cul.getTheme()%></td>
            <td><%=cul.getContent()%></td>
            <td><%=cul.getBegintime()%></td>
            <td><%=cul.getEndtime()%></td>
            <td><%=cul.getAddress()%></td>
            <td><%=culempname%></td>
            <td>
                <form action="issueCul" method="post">
                    <input type="hidden" name="cid" value="<%=cul.getId()%>">
                    <input type="submit" value="发布">
                </form>
            </td>
        </tr>
    </table>
    <a href="msuccess">返回管理员主页</a>
</div>
</body>
</html>
