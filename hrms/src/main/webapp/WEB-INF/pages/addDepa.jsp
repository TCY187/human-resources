<%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/8/7
  Time: 16:06
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
    <script type="text/javascript">
        function check() {
            if (document.getElementById('dname').value==""){
                alert('请输入部门名！');
                document.getElementById('dname').focus();
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div id="div1">
    <form action="addDepa1" method="post" onsubmit="return check()">
        部门名：<input type="text" name="dname" id="dname"/><br/>
        <input type="submit" value="添加">
    </form>
    <span>${depaerror}</span>
</div>
</body>
</html>
