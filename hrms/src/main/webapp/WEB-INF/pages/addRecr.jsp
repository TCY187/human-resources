<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.iotek.model.Depa" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/8/1
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script>
        $(function () {
            $("#selectDep").change(function () {
                //alert("aaa")
                var sel=$("#selectDep option:selected").val();
                alert(sel);
                $.getJSON("getDepa1","key="+sel,function (obj) {
                    $("#selectPosition").empty();
                    $(obj).each(function () {
                        $("#selectPosition").append("<option value="+this.id+">"+this.pname+"</option>")
                    })
                })
            })
        })
    </script>
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
<div>
<form action="addRecr1" method="post">
    请选择部门和职位：
    <select id="selectDep" name="selectDep">
        <option>请选择</option>
        <c:forEach var="i" begin="0" end="${fn:length(sessionScope.addRecrdepaList)-1}">
            <option value="${sessionScope.addRecrdepaList[i].id}" class="option1">${sessionScope.addRecrdepaList[i].dname}</option>
        </c:forEach>
    </select>
    <select id="selectPosition" name="selectPosition">
        <option>请选择</option>
    </select>
    <input type="submit" value="确定">
</form>
</div>
</body>
</html>
