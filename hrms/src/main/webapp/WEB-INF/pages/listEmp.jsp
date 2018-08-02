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
</head>
<body>
<%--<%
    List<Depa> depaList = (List<Depa>) session.getAttribute("depaList");
    int totalPages= (int) session.getAttribute("totalPages");
%>--%>
    请选择部门和职位：
    <select id="selectDep" name="selectDep">
        <option>请选择</option>
        <%--<%
            for (int i = 0; i < depaList.size(); i++) {
        %>
            <option value="<%=depaList.get(i).getId()%>" class="option1"><%=depaList.get(i).getDname()%></option>
        <%
            }
        %>--%>
        <c:forEach var="i" begin="0" end="${fn:length(sessionScope.depaList)-1}">
            <option value="${sessionScope.depaList[i].id}" class="option1">${sessionScope.depaList[i].dname}</option>
        </c:forEach>


    </select>
    <select id="selectPosition" name="selectPosition">
        <option>请选择</option>

    </select>
<a href="operateDepa">部门操作</a>
</body>
</html>
