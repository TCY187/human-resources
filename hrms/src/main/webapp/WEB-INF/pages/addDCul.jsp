<%--
  Created by IntelliJ IDEA.
  User: TCY
  Date: 2018/8/2
  Time: 17:03
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
            if (document.getElementById('theme').value==""){
                alert('请输入主题！');
                document.getElementById('theme').focus();
                return false;
            }
            if (document.getElementById('content').value==""){
                alert('请输入内容！');
                document.getElementById('content').focus();
                return false;
            }
            if (document.getElementById('address').value==""){
                alert('请输入地点！');
                document.getElementById('address').focus();
                return false;
            }
            if (document.getElementById('betime').value==""){
                alert('请输入开始时间！');
                document.getElementById('betime').focus();
                return false;
            }
            if (document.getElementById('entime').value==""){
                alert('请输入结束时间！');
                document.getElementById('entime').focus();
                return false;
            }
            return true;
        }
    </script>
    <style>
        #div1{
            margin-left: auto;
            margin-right: auto;
            margin-top: 100px;
            padding-top: 100px;
            background-image: url("/pic/register.jpg");
            width: 800px;
            height: 400px;
            text-align: center;
        }
    </style>
</head>
<body>
<br/>
<br/>
<jsp:include page="/head.jsp"></jsp:include>
<br/>
<div id="div1">
    <form action="addDCul1" method="post" onsubmit="return check()">
        主题：<input type="text" name="theme" id="theme"/><br/>
        内容：<input type="text" name="content" id="content"/><br/>
        地点：<input type="text" name="address" id="address"/><br/>
        开始：<input type="date" name="betime" id="betime"/><br/>
        结束：<input type="date" name="entime" id="entime"/><br/>
        <input type="submit" value="下一步">
    </form>
</div>
</body>
</html>
